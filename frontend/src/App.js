import React, { useEffect, useState } from 'react';
import './index.css';
import Formulario from './componentes/Formulario';
import TabelaProdutos from './componentes/TabelaProdutos';
import { cadastrarProduto, listarTodosProdutos } from './servicos/produtos';

function App() {
  const [produtos, setProdutos] = useState([])
  
  function adicionarProduto(novoProduto) {
    setProdutos([...produtos, novoProduto]);
  }



  function aoNovoProdutoAdicionado(produto){
    setProdutos([...produtos, produto]);
  }
  

  async function fetchProdutos(){
    const listaDeProdutosRecebida = await listarTodosProdutos()
    setProdutos(listaDeProdutosRecebida);
  }

  useEffect(() => {
    fetchProdutos()
  }, [])

  const listaDeProdutos = [
    'Produto A',
    'Produto B',
    'Produto C',
    'Produto D',
    'Produto E'
  ]
  
  return (

  
    // <div className="container">
    <div className="App">
      <Formulario 
        // listaDeProdutos={produtos.map(produto => produto.nomeProduto)}
        listaDeProdutos={listaDeProdutos} 
        aoProdutoCadastrado={produto => aoNovoProdutoAdicionado(produto)}
      />
      <TabelaProdutos 
        produtos={produtos}
      />
    </div>
  );
}

export default App;
