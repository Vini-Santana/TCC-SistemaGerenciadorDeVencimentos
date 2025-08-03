import axios from 'axios';

const baseURL = process.env.REACT_APP_API_BASE_URL;
const emailAPI = axios.create({baseURL: baseURL + '/config/email',})

async function listarEmailsCadastrados(){
    const response = await emailAPI.get('')
    return response.data
}

export{
    listarEmailsCadastrados
}