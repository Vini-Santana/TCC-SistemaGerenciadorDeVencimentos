import axios from 'axios';

const produtosAPI = axios.create({baseURL: 'http://localhost:8080/produtos',})

async function listarTodosProdutos(){

    const response = await produtosAPI.get('')
    return response.data
}

async function cadastrarProduto(produto){
    await produtosAPI.post('', produto)
}

async function atualizarProduto(id, produtoAtualizado) {
    await produtosAPI.put(`/${id}`, produtoAtualizado);
}

async function deletarProduto(id, produto) {
    await produtosAPI.delete(`/${id}`, { data: produto });
}

export {
    listarTodosProdutos,
    cadastrarProduto,
    atualizarProduto,
    deletarProduto
};