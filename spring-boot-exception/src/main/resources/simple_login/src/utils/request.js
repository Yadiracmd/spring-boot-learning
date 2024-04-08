import axios from "axios";

const baseURL = '/api'
const request = axios.create({
    baseURL,
    timeout: 10000
})




export { baseURL, request }