import CampoTexto from '../CampoTexto';
import CampoListProdutos from '../CampoListProdutos';
import './Formulario.css';
import { useState } from 'react';
import { atualizarProduto, cadastrarProduto, listarTodosProdutos } from '../../servicos/produtos';

const Formulario = ({ onClose, dadosFormulario, aoAtualizarProduto }) => {
    const [parametrosDoProduto, setParametrosDoProduto] = useState(() => {
        if (dadosFormulario.modo !== 'cadastro' && dadosFormulario.produto) {
            return {
                id: dadosFormulario.produto.id || '',
                nomeProduto: dadosFormulario.produto.nomeProduto || '',
                codigo: dadosFormulario.produto.codigo || '',
                validade: dadosFormulario.produto.validade || '',
                quantidade: dadosFormulario.produto.quantidade || '',
                observacoes: dadosFormulario.produto.observacoes || '',
            };
        } else {
            return {
                id: '',
                nomeProduto: '',
                codigo: '',
                validade: '',
                quantidade: '',
                observacoes: ''
            };
        }
    });

    const [produtoSelecionado, setProdutoSelecionado] = useState(null);
    const [codigoInvalido, setCodigoInvalido] = useState(false);
    const [emModoEdicao, setEmModoEdicao] = useState(dadosFormulario.modo !== 'cadastro');

    const atualizarCampo = (campo, valor) => {
        setParametrosDoProduto(prev => ({ ...prev, [campo]: valor }));
    };

    const aoAlterarProduto = (opcao) => {
        setProdutoSelecionado(opcao);
        atualizarCampo('codigo', opcao?.codigo || '');
        atualizarCampo('nomeProduto', opcao?.label || '');
        setCodigoInvalido(false);
    };

    const aoAlterarCodigo = (novoCodigo) => {
        atualizarCampo('codigo', novoCodigo);

        if (novoCodigo.length === 7 || novoCodigo.length === 13) {
            const produtoEncontradoPeloCodigo = dadosFormulario.listaDeProdutos.find(p =>
                p.codigo === novoCodigo || p.codigoBarras === novoCodigo
            );

            if (produtoEncontradoPeloCodigo) {
                const opcao = {
                    label: produtoEncontradoPeloCodigo.nomeProduto,
                    value: produtoEncontradoPeloCodigo.nomeProduto,
                    codigo: produtoEncontradoPeloCodigo.codigo
                };
                setProdutoSelecionado(opcao);
                atualizarCampo('nomeProduto', produtoEncontradoPeloCodigo.nomeProduto);

                if (novoCodigo.length === 13) {
                    atualizarCampo('codigo', produtoEncontradoPeloCodigo.codigo);
                }
                setCodigoInvalido(false);
            } else {
                setProdutoSelecionado(null);
                atualizarCampo('nomeProduto', '');
                setCodigoInvalido(true);
            }
        } else if (produtoSelecionado && novoCodigo !== produtoSelecionado.codigo) {
            setCodigoInvalido(true);
        } else {
            setCodigoInvalido(false);
        }
    };
    function formatarDataBR(dataISO) {
        if (!dataISO) return '';
        const [ano, mes, dia] = dataISO.split('-');
        return `${dia}/${mes}/${ano}`;
    }

    const trocarParaModoEdicao = (produtoExistente) => {
        dadosFormulario.label = 'Atualizar produto';

        setParametrosDoProduto({
            id: produtoExistente.id,
            nomeProduto: produtoExistente.nomeProduto,
            codigo: produtoExistente.codigo,
            validade: produtoExistente.validade,
            quantidade: produtoExistente.quantidade,
            observacoes: produtoExistente.observacoes
        });
        dadosFormulario.acao = aoAtualizarProduto;
        setEmModoEdicao("edicao");
    }

    const aoSalvar = async (e) => {
        e.preventDefault();

        if (produtoSelecionado && parametrosDoProduto.codigo !== produtoSelecionado.codigo) {
            alert('O código inserido não corresponde ao produto selecionado.');
            return;
        }
        const hojeCorrigido = new Date();
        hojeCorrigido.setMinutes(hojeCorrigido.getMinutes() - hojeCorrigido.getTimezoneOffset());

        const produto = {
            ...parametrosDoProduto,
            ultimaModificacao: hojeCorrigido.toISOString().split("T")[0]
        };

        try {
            if (emModoEdicao) {
                await atualizarProduto(produto.id, produto);
                dadosFormulario.acao(produto);
                onClose();
            } else {
                const produtos = await listarTodosProdutos();
                if (produtos.map(p => p.nomeProduto).includes(produto.nomeProduto) && produtos.map(p => p.validade).includes(produto.validade)) {
                    const confirmacao = window.confirm(`Produto "${produto.nomeProduto}" com a validade "${formatarDataBR(produto.validade)}" já está cadastrado. Deseja atualizá-lo?`);
                    if (confirmacao) {
                        const produtoExistente = produtos.find(
                            p => p.nomeProduto === produto.nomeProduto && p.validade === produto.validade
                        );
                        trocarParaModoEdicao(produtoExistente);
                    } else {
                        onClose();
                    }
                } else {
                    const produtoRetornado = await cadastrarProduto(produto);
                    dadosFormulario.acao(produtoRetornado);
                    onClose();
                }
            }
        } catch (erro) {
            console.error('Erro ao cadastrar o produto:', erro);
        }
    };
    return (
        <section className='formulario'>
            <h2>{dadosFormulario.label}</h2>
            <hr className='linha' />
            <form onSubmit={aoSalvar}>

                {dadosFormulario.modo === 'cadastro' ? (
                    <CampoListProdutos
                        itens={dadosFormulario.listaDeProdutos}
                        valor={produtoSelecionado?.value || ''}
                        aoAlterado={aoAlterarProduto}
                        label="Nome do produto"
                        placeholder="Digite o nome do produto"
                        obrigatorio
                    />
                ) : (
                    <CampoTexto
                        obrigatorio
                        type="text"
                        label="Nome do produto"
                        placeholder="Digite o nome do produto"
                        valor={dadosFormulario.produto?.nomeProduto || ''}
                        readOnly={true}
                    />
                )}

                    <CampoTexto
                        obrigatorio
                        type="text"
                        label="Código do produto"
                        placeholder="Digite o código do produto"
                        valor={parametrosDoProduto.codigo}
                        aoAlterado={emModoEdicao ? '' : aoAlterarCodigo}
                        readOnly={emModoEdicao}
                        erro={codigoInvalido}
                    />
                <div className="linha-dupla">

                <CampoTexto
                    obrigatorio
                    label="Dia de vencimento"
                    type="date"
                    placeholder="Digite o dia de vencimento"
                    valor={parametrosDoProduto.validade}
                    readOnly={emModoEdicao}
                    aoAlterado={valor => atualizarCampo('validade', valor)}
                />

                <CampoTexto
                    label="Quantidade em estoque"
                    type="number"
                    placeholder="Digite a quantidade em estoque"
                    valor={parametrosDoProduto.quantidade}
                    aoAlterado={valor => atualizarCampo('quantidade', valor)}
                />
                </div>

                <CampoTexto
                    label="Observações"
                    type="text"
                    placeholder="Digite as observações"
                    valor={parametrosDoProduto.observacoes}
                    aoAlterado={valor => atualizarCampo('observacoes', valor)}
                />

                <div className="linha-dupla">
                    <button className='botao-salvar' type='submit'>Salvar</button>
                    <button onClick={onClose} className='botao-cancelar' type='button'>Cancelar</button>
                </div>
            </form>
        </section>
    );
};

export default Formulario;