import axios from 'axios';

const baseDeDadosProdutosAPI = axios.create({baseURL: 'http://localhost:8080/baseDeDadosProdutos',})

async function listarTodosBaseDeDadosProdutos(){

    const response = await baseDeDadosProdutosAPI.get('')
    return response.data
}

async function listarBaseDeDadosProdutosPorCodigo(codigo){

    const response = await baseDeDadosProdutosAPI.get('', codigo)
    return response.data
}

async function cadastrarBaseDeDadosProdutos(produto){
    await baseDeDadosProdutosAPI.post('', produto)
}

export{
    listarTodosBaseDeDadosProdutos, 
    cadastrarBaseDeDadosProdutos
}