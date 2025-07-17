import axios from 'axios';

const baseURL = process.env.REACT_APP_API_BASE_URL;
const produtosAPI = axios.create({baseURL: baseURL + '/config',})

async function listarConfiguracoes(){
    const response = await produtosAPI.get('')
    return response.data[0]
}

export{
    listarConfiguracoes
}