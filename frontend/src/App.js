import React, { useEffect, useState } from 'react';
import './index.css';
import Formulario from './componentes/Formulario';
import TabelaProdutos from './componentes/TabelaProdutos/index';
import { listarTodosProdutos, atualizarProduto, deletarProduto } from './servicos/produtos';
import { listarTodosBaseDeDadosProdutos } from './servicos/baseDeDadosProdutos';
import { Button, useDisclosure } from '@heroui/react';
import ModalFormularioProdutos from './componentes/ModalFormularioProdutos';

function App() {
  const [produtos, setProdutos] = useState([]);
  const [baseDeDadosProdutos, setBaseDeDadosProdutos] = useState([]);
  const [modalFormularioAberto, setModalFormularioAberto] = useState(false);

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

  const { onOpen, onOpenChange } = useDisclosure();
  return (

    <div className="App">
      <Button onPress={() => setModalFormularioAberto(true)} class="bg-laranja text-white p-4 hover:bg-laranjaHouver transition-colors duration-300 rounded">Cadastrar produto</Button>

      <ModalFormularioProdutos
        aoProdutoCadastrado={produto => aoNovoProdutoAdicionado(produto)}
        listaDeProdutos={baseDeDadosProdutos}
        isOpen={modalFormularioAberto}
        onOpenChange={onOpenChange}

        onClose={() => setModalFormularioAberto(false)}
        placement="top"
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
