import './CampoTexto.css';

const CampoTexto = (props) => {

    
    const aoDigitado = (evento) => {
        props.aoAlterado(evento.target.value)
        
    }

    // const { type = 'text', label, value, onChange, placeholder } = props;
    return (
        <div className="campo-texto">
            <label>{props.label}</label>
            <input onChange={aoDigitado} required={props.obrigatorio} type={props.type} value={props.value}placeholder={props.placeholder}/>
        </div>
    );
}

export default CampoTexto