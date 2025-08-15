import React, { useEffect, useState } from 'react';
import './index.css';
import TabelaProdutos from './componentes/TabelaProdutos/index';
import {
  listarTodosProdutos,
  deletarProduto,
} from './servicos/produtos';
import { listarTodosBaseDeDadosProdutos } from './servicos/baseDeDadosProdutos';
import Alertas from './componentes/Alertas';
import { Button } from '@heroui/react';
import ModalFormularioProdutos from './componentes/ModalFormularioProdutos';
import CardContagemProdutosAVencer from './componentes/CardContagemProdutosAVencer';
import { listarEmailsCadastrados } from './servicos/emailsCadastrados';
import { listarTempoNotificacao } from './servicos/tempoParaNotificacao';

function App() {
  const [produtos, setProdutos] = useState([]);
  const [baseDeDadosProdutos, setBaseDeDadosProdutos] = useState([]);
  const [modalFormularioAberto, setModalFormularioAberto] = useState(false);
  const [isAlertVisible, setIsAlertVisible] = React.useState(true);
  const [dadosFormulario, setDadosFormulario] = useState(null);
  const [emailsCadastrados, setEmailsCadastrados] = useState([]);
  const [tempoParaNotificacao, setTempoParaNotificacao] = useState([]);
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

  async function getEmailsCadastrados() {
    const configs = await listarEmailsCadastrados();
    setEmailsCadastrados(configs);
  }

  async function getTempoParaNotificacao() {
    const configs = await listarTempoNotificacao();
    setTempoParaNotificacao(configs);
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
      await getEmailsCadastrados();
    }
    fetchData();
  }, []);

  useEffect(() => {
    // if (!configuracoes || configuracoes.tempoParaNotificacaoDeValidade === undefined || !Array.isArray(produtos) || produtos.length === 0) {
    if (!Array.isArray(produtos) || produtos.length === 0) {
      console.log('Condição de retorno para produtosAVencer: configuracoes ou produtos inválidos.');
      setProdutosAVencer([]);
      return;
    }
    const produtosAVencer = produtos.filter(p => p.isAVencer);
    setProdutosAVencer(produtosAVencer);

  }, [produtos, tempoParaNotificacao]);

  return (
    <div className="App">
       {produtosAVencer.length > 0 && (
      <Alertas
        isVisible={isAlertVisible}
        titulo="Produtos próximos do vencimento"
        color="warning"
        produtos={produtosAVencer}
        onClose={() => setIsAlertVisible(false)} 
      />
    )}
      <CardContagemProdutosAVencer
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
        produtosAVencer={produtosAVencer}
      />
    </div>
  );
}

export default App;
