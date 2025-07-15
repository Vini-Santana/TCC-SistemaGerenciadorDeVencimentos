import CampoTexto from '../CampoTexto';
import CampoListProdutos from '../CampoListProdutos';
import './Formulario.css';
import { useState } from 'react';
import { atualizarProduto, cadastrarProduto, listarTodosProdutos } from '../../servicos/produtos';

const Formulario = ({ onClose, dadosFormulario }) => {
    const [parametros, setParametros] = useState(() => {
        if (dadosFormulario.modo !== 'cadastro' && dadosFormulario.produto) {
            return {
                id: dadosFormulario.produto.id || '',
                nomeProduto: dadosFormulario.produto.nomeProduto || '',
                codigo: dadosFormulario.produto.codigo || '',
                lote: dadosFormulario.produto.lote || '',
                validade: dadosFormulario.produto.validade || '',
                quantidade: dadosFormulario.produto.quantidade || '',
                observacoes: dadosFormulario.produto.observacoes || '',
            };
        } else {
            return {
                id: '',
                nomeProduto: '',
                codigo: '',
                lote: '',
                validade: '',
                quantidade: '',
                observacoes: ''
            };
        }
    });

    const [produtoSelecionado, setProdutoSelecionado] = useState(null);
    const [codigoInvalido, setCodigoInvalido] = useState(false);
    const emModoEdicao = dadosFormulario.modo !== 'cadastro';

    const atualizarCampo = (campo, valor) => {
        setParametros(prev => ({ ...prev, [campo]: valor }));
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

    const aoSalvar = async (e) => {
        e.preventDefault();

        if (produtoSelecionado && parametros.codigo !== produtoSelecionado.codigo) {
            alert('O código inserido não corresponde ao produto selecionado.');
            return;
        }
        const hojeCorrigido = new Date();
        hojeCorrigido.setMinutes(hojeCorrigido.getMinutes() - hojeCorrigido.getTimezoneOffset());

        const produto = {
            ...parametros,
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
                    alert('Produto ja cadastrado');
                    console.log('Produto ja cadastrado');
                } else {
                    await cadastrarProduto(produto);
                    dadosFormulario.acao(produto);
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

                <div className="linha-dupla">

                    <CampoTexto
                        obrigatorio
                        type="text"
                        label="Código do produto"
                        placeholder="Digite o código do produto"
                        valor={parametros.codigo}
                        aoAlterado={emModoEdicao ? '' : aoAlterarCodigo}
                        readOnly={emModoEdicao}
                        erro={codigoInvalido}
                    />
                    <CampoTexto
                        obrigatorio
                        type="number"
                        label="Lote"
                        placeholder="Digite o lote"
                        valor={parametros.lote}
                        readOnly={emModoEdicao}
                        aoAlterado={valor => atualizarCampo('lote', valor)}
                    />
                </div>

                <CampoTexto
                    obrigatorio
                    label="Dia de vencimento"
                    type="date"
                    placeholder="Digite o dia de vencimento"
                    valor={parametros.validade}
                    readOnly={emModoEdicao}
                    aoAlterado={valor => atualizarCampo('validade', valor)}
                />

                <CampoTexto
                    label="Quantidade em estoque"
                    type="number"
                    placeholder="Digite a quantidade em estoque"
                    valor={parametros.quantidade}
                    aoAlterado={valor => atualizarCampo('quantidade', valor)}
                />

                <CampoTexto
                    label="Observações"
                    type="text"
                    placeholder="Digite as observações"
                    valor={parametros.observacoes}
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