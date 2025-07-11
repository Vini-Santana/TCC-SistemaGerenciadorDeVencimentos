import './CampoTexto.css';

const CampoTexto = ({ label, valor, aoAlterado, placeholder, obrigatorio, type = "text", erro }) => {
    return (
        <div className={`campo-texto ${erro ? 'erro' : ''}`}>
            <label>{label}</label>
            <input
                type={type}
                value={valor}
                onChange={e => aoAlterado(e.target.value)}
                placeholder={placeholder}
                required={obrigatorio}
            />
        </div>
    );
};

export default CampoTexto