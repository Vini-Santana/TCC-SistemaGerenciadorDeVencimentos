import React, { useEffect, useState } from 'react';
import './index.css';
import TabelaProdutos from './componentes/TabelaProdutos/index';
import {
  listarTodosProdutos,
  deletarProduto,
} from './servicos/produtos';
import { listarTodosBaseDeDadosProdutos } from './servicos/baseDeDadosProdutos';
import { Button } from '@heroui/react';
import ModalFormularioProdutos from './componentes/ModalFormularioProdutos';
import CardContagemProdutos from './componentes/CardContagemProdutos';
import { listarConfiguracoes } from './servicos/configuracoes';

function App() {
  const [produtos, setProdutos] = useState([]);
  const [baseDeDadosProdutos, setBaseDeDadosProdutos] = useState([]);
  const [modalFormularioAberto, setModalFormularioAberto] = useState(false);
  const [dadosFormulario, setDadosFormulario] = useState(null);
  const [configuracoes, setConfiguracoes] = useState(null);
  const [produtosAVencer, setProdutosAVencer] = useState([]);
  const abrirModalFormulario = (dados) => {
    setDadosFormulario(dados);
    setModalFormularioAberto(true);
  };

  async function getTodosProdutos() {
    const listaDeProdutosRecebida = await listarTodosProdutos();
    setProdutos(listaDeProdutosRecebida);
  }

  async function getBaseDeDadosProdutos() {
    const listaDeProdutosRecebida = await listarTodosBaseDeDadosProdutos();
    setBaseDeDadosProdutos(listaDeProdutosRecebida);
  }

  async function getConfiguracoes() {
    const configs = await listarConfiguracoes();
    setConfiguracoes(configs);
  }

  function aoNovoProdutoAdicionado(produto) {
    setProdutos(prev => [...prev, produto]);
  }


  async function aoAtualizar(produtoAtualizado) {
    try {
      setProdutos(prev => prev.map(p => p.id === produtoAtualizado.id ? produtoAtualizado : p));
    } catch (erro) {
      console.error('Erro ao atualizar produto: ', erro);
    }
  }

  async function aoExcluir(produto) {
    try {
      await deletarProduto(produto.id, produto);
      setProdutos(prev => prev.filter(p => p.id !== produto.id));
    } catch (erro) {
      console.error('Erro ao excluir produto:', erro);
    }
  }

  useEffect(() => {
    async function fetchData() {
      await getTodosProdutos();
      await getBaseDeDadosProdutos();
      await getConfiguracoes();
    }
    fetchData();
  }, []);

  useEffect(() => {
    // if (!configuracoes || configuracoes.tempoParaNotificacaoDeValidade === undefined || !Array.isArray(produtos) || produtos.length === 0) {
    if (!configuracoes || !Array.isArray(produtos) || produtos.length === 0) {
      console.log('Condição de retorno para produtosAVencer: configuracoes ou produtos inválidos.');
      setProdutosAVencer([]);
      return;
    }
    const produtosAVencer = produtos.filter(p => p.isAVencer);
    setProdutosAVencer(produtosAVencer);

  }, [produtos, configuracoes]);

  return (

    <div className="App">
      <CardContagemProdutos
        titulo="Produtos a vencer"
        contagem={produtosAVencer.length}
      />
      <Button onPress={() => abrirModalFormulario({
        label: "Cadastro de produto",
        acao: aoNovoProdutoAdicionado,
        listaDeProdutos: baseDeDadosProdutos,
        modo: "cadastro",
        // })} class="bg-laranja text-white p-4 hover:bg-laranjaHover duration-30">Cadastrar produto</Button>
      })} className="botao-cadastrar">Cadastrar Produto</Button>


      <ModalFormularioProdutos
        dadosFormulario={dadosFormulario}
        isOpen={modalFormularioAberto}
        onClose={() => setModalFormularioAberto(false)}
        placement="top"
        aoAtualizarProduto={aoAtualizar}
      />

        <TabelaProdutos
          abrirModalFormulario={abrirModalFormulario}
          produtos={produtos}
          aoExcluirProduto={aoExcluir}
          aoAtualizarProduto={aoAtualizar}
          // tempoParaNotificacao={configuracoes.tempoParaNotificacaoDeValidade}
          produtosAVencer={produtosAVencer}
        />
    </div>
  );
}

export default App;
