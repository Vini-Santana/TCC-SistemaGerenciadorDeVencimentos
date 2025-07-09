import './TabelaProdutos.css';

const TabelaProdutos = ({produtos}) => {

    return(
        <section className='tabela-produtos'>
            <h2>Produtos Cadastrados</h2>
            <table>
                <thead>
                    <tr>
                        <th>Nome do Produto</th>
                        <th>Código</th>
                        <th>Lote</th>
                        <th>Dia de Vencimento</th>
                        <th>Quantidade em Estoque</th>
                        <th>Observações</th>
                        <th>Última Modificacao</th>
                    </tr>
                </thead>
                <tbody>
                    {produtos.map((produto, index) => (
                        <tr key={index}>
                            <td>{produto.nomeProduto}</td>
                            <td>{produto.codigo}</td>
                            <td>{produto.lote}</td>
                            <td>{produto.quantidade}</td>
                            <td>{produto.validade}</td>
                            <td>{produto.observacoes}</td>
                            <td>{produto.ultimaModificacao}</td>
                        </tr>
                    ))}
                </tbody>
            </table>
        </section>
    )
}

export default TabelaProdutos