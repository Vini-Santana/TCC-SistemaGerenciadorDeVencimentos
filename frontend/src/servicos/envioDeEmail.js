import axios from 'axios';

const baseURL = process.env.REACT_APP_API_BASE_URL;
const produtosAPI = axios.create({baseURL: baseURL + '/email',})

async function enviarEmail(email){
    const resposta = await produtosAPI.post('', email);
    return resposta.data;
}

export{
    enviarEmail
}