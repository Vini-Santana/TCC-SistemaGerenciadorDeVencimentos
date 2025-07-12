import axios from 'axios';

const baseURL = process.env.REACT_APP_API_BASE_URL;
const baseDeDadosProdutosAPI = axios.create({baseURL: baseURL + '/baseDeDadosProdutos',})

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