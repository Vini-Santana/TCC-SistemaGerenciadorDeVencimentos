import React, { useEffect, useState } from 'react';
import './index.css';
import Formulario from './componentes/Formulario';
import TabelaProdutos from './componentes/TabelaProdutos/index';
import { listarTodosProdutos, atualizarProduto, deletarProduto } from './servicos/produtos';
import { listarTodosBaseDeDadosProdutos } from './servicos/baseDeDadosProdutos';

function App() {
  const [produtos, setProdutos] = useState([]);
  const [baseDeDadosProdutos, setBaseDeDadosProdutos] = useState([]);

  function aoNovoProdutoAdicionado(produto) {
    setProdutos([...produtos, produto]);
  }

  async function fetchProdutos() {
    const listaDeProdutosRecebida = await listarTodosProdutos();
    setProdutos(listaDeProdutosRecebida);
  }

  async function fetchBaseDeDadosProdutos() {
    const listaDeProdutosRecebida = await listarTodosBaseDeDadosProdutos();
    setBaseDeDadosProdutos(listaDeProdutosRecebida);
  }

  async function aoAtualizar(produtoAtualizado) {
    try {
      await atualizarProduto(produtoAtualizado.id, produtoAtualizado);
      const novaLista = produtos.map(p =>
        p.id === produtoAtualizado.id ? produtoAtualizado : p
      );
      setProdutos(novaLista);
    } catch (erro) {
      console.error('Erro ao atualizar produto:', erro);
    }
  }

  async function aoExcluir(produto) {
    try {
      await deletarProduto(produto.id, produto);
      const novaLista = produtos.filter(p => p.id !== produto.id);
      setProdutos(novaLista);
    } catch (erro) {
      console.error('Erro ao excluir produto:', erro);
    }
  }

  useEffect(() => {
    fetchProdutos();
    fetchBaseDeDadosProdutos();
  }, []);


  
//   const baseDeDadosProdutosEstatico = [
//   {
//     nomeProduto: 'Produto A',
//     codigo: '123456',
//     codigoBarras: '12345678901231'
//   },
//   {
//     nomeProduto: 'Produto B',
//     codigo: '345678',
//     codigoBarras: '98765432109874'
//   }
// ];
  return (

      <div className="App">
      <Formulario 
        listaDeProdutos={baseDeDadosProdutos} 
        // listaDeProdutos={baseDeDadosProdutosEstatico} 
        aoProdutoCadastrado={produto => aoNovoProdutoAdicionado(produto)}
      />

      <TabelaProdutos
        produtos={produtos}
        aoAtualizarProduto={aoAtualizar}
        aoExcluirProduto={aoExcluir}
      />
    </div>
  );
}

export default App;
