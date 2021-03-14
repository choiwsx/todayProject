import React from 'react';
import ChatService from '../service/ChatService';
// import SockJS from 'sockjs-client';
// import Stomp from 'stompjs';
import Button from '@material-ui/core/Button';
import SockJsClient from 'react-stomp';


// import 'bootstrap/dist/css/bootstrap.min.css';
class ChatComponent extends React.Component{
    constructor(props){
        super(props);

        this.state = {
            message : [],
            typedMessage : "",
            name : ""
        }
    }

    handleInputChanged(event){
        console.log(event.target.value);
        this.setState({
            name : event.target.value
        });
    }


    handleButtonClicked(){
        this.clientRef.sendMessage('/app/user-all', JSON.stringify({
            name : this.state.name,
            message : this.state.typedMessage
        }));
    };



    render(){
        return(
            <div>
                <div>
                User : <input type="text" value={this.state.name} onChange={this.handleInputChanged.bind(this)}/>
                </div>

                <div>
                    
                </div>
                <button onClick={this.handleButtonClicked.bind(this)}>
                    submmit                
                </button>

                

                <SockJsClient url='http://localhost:8080/websocket-chat/'
                              topics={['/topic/user']}
                              onConnect={()=>{
                                  console.log("connected");
                              }}
                              onDisconnect={()=>{
                                  console.log("Disconnected");
                              }}
                              onMessage={(msg)=>{
                                  let jobs = this.state.message;
                                  jobs.push(msg);
                                  this.setState({message:jobs});
                                  console.log(this.state);
                              }}
                              ref={(client)=>{
                                  this.clientRef = client
                              }}
                              />
            </div>
        )
    }
}

export default ChatComponent