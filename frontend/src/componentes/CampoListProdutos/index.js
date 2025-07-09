import './CampoListProdutos.css';
const CampoListProdutos = (props) => {

    return (
        <div className='lista-de-produtos'>
            <label>{props.label}</label>
            <select onChange={evento => props.aoAlterado(evento.target.value)} required={props.obrigatorio} 
            value={props.valor}>
                {props.itens.map(item => {
                    return <option key={item}>{item}</option>
                })}                                                                                                                                                                                                                                                                
            </select>
        </div>
        // <div className='lista-de-produtos'>
        //     <label>{props.label}</label>
        //     <input
        //         list="lista-produtos"
        //         value={props.valor}
        //         onChange={evento => props.aoAlterado(evento.target.value)}
        //         required={props.obrigatorio}
        //     />
        //     <datalist id="lista-produtos">
        //         {props.itens.map(item => (
        //             <option key={item} value={item} />
        //         ))}
        //     </datalist>
        // </div>
    )
}

export default CampoListProdutos;