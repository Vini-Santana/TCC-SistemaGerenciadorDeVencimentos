import React, { useState } from 'react';
import './App.css';

function App() {
  // Estado que armazena os dados do produto
  const [produto, setProduto] = useState({
    codigo: '',
    lote: '',
    validade: '',
    quantidade: '',
    observacoes: ''
  });

  // Atualiza o estado quando o usuário digita algo
  const handleChange = (e) => {
    const { name, value } = e.target;
    setProduto(prevState => ({
      ...prevState,
      [name]: value
    }));
  };

  // Função que executa quando o formulário é enviado
  const handleSubmit = (e) => {
    e.preventDefault(); // evita o recarregamento da página
    console.log('Produto cadastrado:', produto); // mostra no console
    alert('Produto cadastrado com sucesso!');
  };

  return (
    <div className="container">
      <h1>Cadastro de Produto</h1>
      <form onSubmit={handleSubmit}>

        <label>Nome do Produto:</label>
        <input type="text" name="nome" value={produto.nome} onChange={handleChange} required />

        <label>Código do Produto:</label>
        <input type="text" name="codigo" value={produto.codigo} onChange={handleChange} required />
        
        <label>Código do Lote:</label>
        <input type="text" name="lote" value={produto.lote} onChange={handleChange} required />
        
        <label>Data de Validade:</label>
        <input type="date" name="validade" value={produto.validade} onChange={handleChange} required />
        
        <label>Quantidade:</label>
        <input type="number" name="quantidade" value={produto.quantidade} onChange={handleChange} required />
        
        <label>Observações:</label>
        <textarea name="observacoes" value={produto.observacoes} onChange={handleChange}></textarea>
        
        <button type="submit">Cadastrar</button>
      </form>
    </div>
  );
}

export default App;
