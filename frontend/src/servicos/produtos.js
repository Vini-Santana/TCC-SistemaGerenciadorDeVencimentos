import axios from 'axios';

const produtosAPI = axios.create({baseURL: 'http://localhost:8080/produtos',})

async function listarTodosProdutos(){

    const response = await produtosAPI.get('')
    return response.data
}

async function cadastrarProduto(produto){
    await produtosAPI.post('', produto)
}

async function deletarProduto(id){
    await produtosAPI.delete(`/${id}`)
}

export{
    listarTodosProdutos, 
    cadastrarProduto, 
    deletarProduto
}