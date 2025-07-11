import './TabelaProdutos.css';
import BotaoOpcoesProduto from '../BotaoOpcoesProduto';
import { useState } from 'react';

const TabelaProdutos = ({ produtos, aoExcluirProduto, aoAtualizarProduto }) => {
  const [produtoEditando, setProdutoEditando] = useState(null);
  const [produtoTemp, setProdutoTemp] = useState({});

  const handleEditar = (produto) => {
    setProdutoEditando(produto.codigo);
    setProdutoTemp({ ...produto });
  };

  const handleCancelar = () => {
    setProdutoEditando(null);
    setProdutoTemp({});
  };

  const handleSalvar = () => {
    aoAtualizarProduto(produtoTemp);
    setProdutoEditando(null);
    setProdutoTemp({});
  };

  const handleAlterarCampo = (campo, valor) => {
    setProdutoTemp(prev => ({ ...prev, [campo]: valor }));
  };

  return (
    <section className='tabela-produtos'>
      <h2>Produtos Cadastrados</h2>
      <table>
        <thead>
          <tr>
            <th>Código</th>
            <th>Nome do produto</th>
            <th>Qtd em estoque</th>
            <th>Validade</th>
            <th>Lote</th>
            <th>Observações</th>
            <th>Opções</th>
          </tr>
        </thead>
        <tbody>
          {produtos.map((produto, index) => {
            const editando = produtoEditando === produto.codigo;
            return (
              <tr key={index}>
                <td>
                  {editando ? (
                    <input
                      value={produtoTemp.codigo}
                      onChange={e => handleAlterarCampo('codigo', e.target.value)}
                    />
                  ) : (
                    <strong>{produto.codigo}</strong>
                  )}
                </td>
                <td>
                  {editando ? (
                    <input
                      value={produtoTemp.nomeProduto}
                      onChange={e => handleAlterarCampo('nomeProduto', e.target.value)}
                    />
                  ) : (
                    produto.nomeProduto
                  )}
                </td>
                <td>
                  {editando ? (
                    <input
                      type="number"
                      value={produtoTemp.quantidade}
                      onChange={e => handleAlterarCampo('quantidade', e.target.value)}
                    />
                  ) : (
                    produto.quantidade
                  )}
                </td>
                <td>
                  {editando ? (
                    <input
                      type="date"
                      value={produtoTemp.validade}
                      onChange={e => handleAlterarCampo('validade', e.target.value)}
                    />
                  ) : (
                    <span
                      className="validade"
                      style={{
                        backgroundColor:
                          produto.validade < new Date().toISOString().split('T')[0]
                            ? '#c00'
                            : '#d4af37'
                      }}
                    >
                      {produto.validade}
                    </span>
                  )}
                </td>
                <td>
                  {editando ? (
                    <input
                      value={produtoTemp.lote}
                      onChange={e => handleAlterarCampo('lote', e.target.value)}
                    />
                  ) : (
                    produto.lote
                  )}
                </td>
                <td>
                  {editando ? (
                    <input
                      value={produtoTemp.observacoes}
                      onChange={e => handleAlterarCampo('observacoes', e.target.value)}
                    />
                  ) : (
                    produto.observacoes
                  )}
                </td>
                <td>
                  {editando ? (
                    <>
                      <button onClick={handleSalvar}>Salvar</button>
                      <button onClick={handleCancelar}>Cancelar</button>
                    </>
                  ) : (
                    <BotaoOpcoesProduto
                      aoEditar={() => handleEditar(produto)}
                      aoExcluir={() => aoExcluirProduto(produto)}
                    />
                  )}
                </td>
              </tr>
            );
          })}
        </tbody>
      </table>
    </section>
  );
};

export default TabelaProdutos;
