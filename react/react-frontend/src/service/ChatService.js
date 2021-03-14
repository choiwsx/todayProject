import axios from 'axios';

const CONNECT_CHAT_REST_API_URL = "ws://localhost:8080/chat";

class ChatService{

    createChat(){
        return axios.get(CONNECT_CHAT_REST_API_URL);
    }
}

export default new ChatService();