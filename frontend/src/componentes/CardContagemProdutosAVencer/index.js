import './CardContagemProdutosAVencer.css'
const CardContagemProdutosAVencer = ({ titulo, contagem, acao}) => {

    return (

        <div className="produtos-a-vencer" onClick={acao}>
            <span className="titulo">{titulo}</span>
            <span className="quantidade"> {contagem} <small>Produtos</small></span>
        </div>
    )
}

export default CardContagemProdutosAVencer;