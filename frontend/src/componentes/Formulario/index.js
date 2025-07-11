import CampoTexto from '../CampoTexto';
import CampoListProdutos from '../CampoListProdutos';
import './Formulario.css';
import { useState } from 'react';
import { cadastrarProduto } from '../../servicos/produtos';

const Formulario = ({ listaDeProdutos, aoProdutoCadastrado }) => {
    const [dados, setDados] = useState({
        nomeProduto: '',
        codigo: '',
        lote: '',
        validade: '',
        quantidade: '',
        observacoes: ''
    });

    const [produtoSelecionado, setProdutoSelecionado] = useState(null);
    const [codigoInvalido, setCodigoInvalido] = useState(false);

    const atualizarCampo = (campo, valor) => {
        setDados(prev => ({ ...prev, [campo]: valor }));
    };

    const aoAlterarProduto = (opcao) => {
        setProdutoSelecionado(opcao);
        atualizarCampo('codigo', opcao?.codigo || '');
        atualizarCampo('nomeProduto', opcao?.label || '');
        setCodigoInvalido(false);
    };

    const aoAlterarCodigo = (novoCodigo) => {
        atualizarCampo('codigo', novoCodigo);

        if (novoCodigo.length === 6 || novoCodigo.length === 14) {
            const produtoEncontradoPeloCodigo = listaDeProdutos.find(p =>
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

                if (novoCodigo.length === 14) {
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

        if (produtoSelecionado && dados.codigo !== produtoSelecionado.codigo) {
            alert('O código inserido não corresponde ao produto selecionado.');
            return;
        }

        const produto = {
            ...dados,
            ultimaModificacao: new Date().toISOString().split("T")[0]
        };

        try {
            await cadastrarProduto(produto);
            aoProdutoCadastrado(produto);
        } catch (erro) {
            console.error('Erro ao cadastrar o produto:', erro);
        }
    };

    return (
        <section className='formulario'>
            <form onSubmit={aoSalvar}>
                <h2>Cadastro de Produto</h2>

                <CampoListProdutos
                    itens={listaDeProdutos}
                    valor={produtoSelecionado?.value || ''}
                    aoAlterado={aoAlterarProduto}
                    label="Nome do produto"
                    obrigatorio
                />

                <div className="linha-dupla">
                    <CampoTexto
                        obrigatorio
                        type="text"
                        label="Código do produto"
                        placeholder="Digite o código do produto"
                        valor={dados.codigo}
                        aoAlterado={aoAlterarCodigo}
                        erro={codigoInvalido}
                    />
                    <CampoTexto
                        obrigatorio
                        type="number"
                        label="Lote"
                        placeholder="Digite o lote"
                        valor={dados.lote}
                        aoAlterado={valor => atualizarCampo('lote', valor)}
                    />
                </div>

                <CampoTexto
                    obrigatorio
                    label="Dia de vencimento"
                    type="date"
                    placeholder="Digite o dia de vencimento"
                    valor={dados.validade}
                    aoAlterado={valor => atualizarCampo('validade', valor)}
                />

                <CampoTexto
                    label="Quantidade em estoque"
                    type="number"
                    placeholder="Digite a quantidade em estoque"
                    valor={dados.quantidade}
                    aoAlterado={valor => atualizarCampo('quantidade', valor)}
                />

                <CampoTexto
                    label="Observações"
                    type="text"
                    placeholder="Digite as observações"
                    valor={dados.observacoes}
                    aoAlterado={valor => atualizarCampo('observacoes', valor)}
                />

                <div className="linha-dupla">
                    <button className='botao-salvar'>Salvar</button>
                    <button className='botao-cancelar'>Cancelar</button>
                </div>
            </form>
        </section>
    );
};

export default Formulario;