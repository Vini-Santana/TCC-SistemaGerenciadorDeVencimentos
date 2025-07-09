import CampoTexto from '../CampoTexto';
import CampoListProdutos from '../CampoListProdutos';
import Botao from '../Botao';
import './Formulario.css';
import { useState } from 'react';
import { cadastrarProduto } from '../../servicos/produtos';
const Formulario = ({listaDeProdutos, aoProdutoCadastrado}) => {

    const [nomeProduto, setNomeProduto] = useState('');
    const [codigo, setCodigo] = useState('');
    const [lote, setLote] = useState('');
    const [validade, setValidade] = useState('');
    const [quantidade, setQuantidade] = useState('');
    const [observacoes, setObservacoes] = useState('');

    const aoSalvar = async (evento) => {
    evento.preventDefault();

    const produto = {
        nomeProduto,
        codigo,
        lote,
        validade,
        quantidade,
        observacoes,
        ultimaModificacao: new Date().toISOString().split("T")[0]
    };

    try {
        await cadastrarProduto(produto); // chamada à API
        aoProdutoCadastrado(produto);    // adiciona na lista local do App
    } catch (erro) {
        console.error('Erro ao cadastrar o produto:', erro);
        // Você pode exibir uma notificação aqui
    }
};
    

    return (
        <section className='formulario'>
            <form onSubmit={aoSalvar}>
                <h2>Cadastro de Produto</h2>
                <CampoListProdutos
                    obrigatorio={true}
                    label="Selecione o produto"
                    itens={listaDeProdutos}
                    valor={nomeProduto}
                    aoAlterado={valor => setNomeProduto(valor)}
                    
                />

                <div className="linha-dupla">
                    <CampoTexto 
                    obrigatorio={true}
                    type="text"
                    label="Código do produto" 
                    placeholder="Digite o código do produto"
                    valor={codigo}
                    aoAlterado={valor => setCodigo(valor)} 
                    />
                <CampoTexto 
                    obrigatorio={true} 
                    type="number"
                    label="Lote" 
                    placeholder="Digite o lote" 
                    valor={lote}
                    aoAlterado={valor => setLote(valor)} 
                    />
                </div>
                
                <CampoTexto 
                    obrigatorio={true} 
                    label="Dia de vencimento" 
                    type="date"
                    placeholder="Digite o dia de vencimento" 
                    valor={validade}
                    aoAlterado={valor => setValidade(valor)} 
                    />
                <CampoTexto 
                    label="Quantidade em estoque" 
                    type="number"
                    placeholder="Digite a quantidade em estoque" 
                    valor={quantidade}
                    aoAlterado={valor => setQuantidade(valor)} 
                    />
                <CampoTexto 
                    label="Observações" 
                    type="text"
                    placeholder="Digite as observações" 
                    valor={observacoes}
                    aoAlterado={valor => setObservacoes(valor)} 
                    />
                <div className="linha-dupla">
                    <button className='botao-salvar'>Salvar</button>
                    <button className='botao-cancelar'>Cancelar</button>    
                </div>

            </form>
        </section>
    )
}

export default Formulario;

