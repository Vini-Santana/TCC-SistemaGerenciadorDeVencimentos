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
  const [contagemAVencer, setContagemAVencer] = useState(0);
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
    setProdutos(prev => [...produtos, produto]);
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
    if (!configuracoes || produtos.length === 0) return;

    const diasParaVencer = configuracoes.tempoParaNotificacaoDeValidade;
    const hoje = new Date();

    const produtosAVencer = produtos.filter(p => {
      const validade = new Date(p.validade);
      const diferencaEmDias = Math.ceil((validade - hoje) / (1000 * 60 * 60 * 24));
      return diferencaEmDias <= diasParaVencer && diferencaEmDias >= 0;
    });

    setContagemAVencer(produtosAVencer.length);
  }, [produtos, configuracoes]);

  return (

    <div className="App">
      <CardContagemProdutos
        titulo="Produtos a vencer"
        // acao={}
        contagem={contagemAVencer}
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
      />

    </div>
  );
}

export default App;
