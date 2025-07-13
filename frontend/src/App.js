import React, { useEffect, useState } from 'react';
import './index.css';
import TabelaProdutos from './componentes/TabelaProdutos/index';
import {
  listarTodosProdutos,
  atualizarProduto,
  deletarProduto,
  listarProdutosPorId
} from './servicos/produtos';
import { listarTodosBaseDeDadosProdutos } from './servicos/baseDeDadosProdutos';
import { Button, useDisclosure } from '@heroui/react';
import ModalFormularioProdutos from './componentes/ModalFormularioProdutos';

function App() {
  const [produtos, setProdutos] = useState([]);
  const [baseDeDadosProdutos, setBaseDeDadosProdutos] = useState([]);
  const [modalFormularioAberto, setModalFormularioAberto] = useState(false);
  const [dadosFormulario, setDadosFormulario] = useState(null); // <- aqui ficam os dados do formulário



  function aoNovoProdutoAdicionado(produto) {
    setProdutos(prev => [...produtos, produto]);
  }

  async function getTodosProdutos() {
    const listaDeProdutosRecebida = await listarTodosProdutos();
    setProdutos(listaDeProdutosRecebida);
  }

  async function getProdutosPorId() {
    const listaDeProdutosRecebida = await listarProdutosPorId();
    setProdutos(listaDeProdutosRecebida);
  }

  async function getBaseDeDadosProdutos() {
    const listaDeProdutosRecebida = await listarTodosBaseDeDadosProdutos();
    setBaseDeDadosProdutos(listaDeProdutosRecebida);
  }

  async function aoAtualizar(produtoAtualizado) {
    try {
      setProdutos(prev =>
        prev.map(p => p.id === produtoAtualizado.id ? produtoAtualizado : p)
      );

    } catch (erro) {
      console.error('Erro ao atualizar produto: ', erro);
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
    async function fetchData() {
      await getTodosProdutos();
      await getBaseDeDadosProdutos();
    }
    fetchData();
  }, []);

  // function atualizarProdutoNaLista(produtoAtualizado) {
  //   setProdutos(produtos.map(p => p.id === produtoAtualizado.id ? produtoAtualizado : p));
  // }
  // const abrirModalFormulario = (dados) => {
  //   const acao = dados.modo === "cadastro"
  //     ? aoNovoProdutoAdicionado
  //     : atualizarProdutoNaLista;

  //   setDadosFormulario({
  //     ...dados,
  //     acao
  //   });
  //   setModalFormularioAberto(true);
  // };
  const abrirModalFormulario = (dados) => {
    setDadosFormulario(dados);
    setModalFormularioAberto(true);
  };
  return (

    <div className="App">
      <Button onPress={() => abrirModalFormulario({
        label: "Cadastro de Produto",
        acao: aoNovoProdutoAdicionado,
        listaDeProdutos: baseDeDadosProdutos,
        modo: "cadastro"
      })} class="bg-laranja text-white p-4 hover:bg-laranjaHouver duration-300">Cadastrar produto</Button>

      <ModalFormularioProdutos
        dadosFormulario={dadosFormulario}
        isOpen={modalFormularioAberto}
        onClose={() => setModalFormularioAberto(false)}
        placement="top"
      />

      <TabelaProdutos
        abrirModalFormulario={abrirModalFormulario}
        produtos={produtos}
        aoExcluirProduto={aoExcluir}
        aoAtualizarProduto={aoAtualizar}
      />

    </div>
  );
}

export default App;
