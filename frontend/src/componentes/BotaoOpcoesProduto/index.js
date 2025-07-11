import { useState } from 'react';
import './BotaoOpcoesProduto.css';

const BotaoOpcoesProduto = ({ aoEditar, aoExcluir }) => {
    const [aberto, setAberto] = useState(false);

    const alternarMenu = () => {
        setAberto(!aberto);
    };

    const handleEditar = () => {
        aoEditar();
        setAberto(false); // fecha o menu
    };

    const handleExcluir = () => {
        aoExcluir();
        setAberto(false); // fecha o menu
    };

    return (
        <div className="botao-opcoes-produto">
            <button className="botao-principal" onClick={alternarMenu}>⋮</button>
            {aberto && (
                <div className="menu-opcoes">
                    <button onClick={handleEditar}>Editar</button>
                    <button onClick={handleExcluir}>Excluir</button>
                </div>
            )}
        </div>
    );
};

export default BotaoOpcoesProduto;
