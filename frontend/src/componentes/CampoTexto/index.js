import './CampoTexto.css';

const CampoTexto = ({ label, valor, aoAlterado, placeholder, obrigatorio, type, erro, readOnly}) => {
    return (
        <div className={`campo-texto ${erro ? 'erro' : ''}`}>
            <label>{label}</label>
            <input
                type={type}
                value={valor}
                onChange={e => aoAlterado(e.target.value)}
                placeholder={placeholder}
                required={obrigatorio}
                readOnly={readOnly}
            />
        </div>
    );
};

export default CampoTexto