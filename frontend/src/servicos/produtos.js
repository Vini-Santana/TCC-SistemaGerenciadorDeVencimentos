import axios from 'axios';
const baseURL = process.env.REACT_APP_API_BASE_URL;
const produtosAPI = axios.create({baseURL: baseURL + '/produtos',})

async function listarTodosProdutos(){
    const response = await produtosAPI.get('')
    return response.data
}

async function listarProdutosPorId(id){
    const response = await produtosAPI.get(`/buscarPor?id=${id}`, id)
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
    deletarProduto,
    listarProdutosPorId,
};