import axios from 'axios';

const baseURL = process.env.REACT_APP_API_BASE_URL;
const tempoAPI = axios.create({baseURL: baseURL + '/config/tempo-notificacao',})

async function listarTempoNotificacao(){
    const response = await tempoAPI.get('')
    return response.data
}

export{
    listarTempoNotificacao
}