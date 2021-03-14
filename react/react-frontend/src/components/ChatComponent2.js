import React from 'react';
import ChatService from '../service/ChatService';
// import SockJS from 'sockjs-client';
// import Stomp from 'stompjs';
import Button from '@material-ui/core/Button';
import TextField from '@material-ui/core/TextField';
import SockJsClient from 'react-stomp';


// import 'bootstrap/dist/css/bootstrap.min.css';
class ChatComponent extends React.Component{
    constructor(props){
        super(props);

        this.state = {
            messages : [],
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
        this.clientRef.sendMessage('/app/room/2', JSON.stringify({
            name : this.state.name,
            message : this.state.typedMessage
        }));
    };
    displayMessages = () =>{
        return(
            <div>
                {this.state.messages.map(msg=>{
                    return(
                        <div>
                            {this.state.name === msg.name ?
                                <div>
                                    <p className="title1">{msg.name} : </p>
                                    <p>{msg.message}</p>
                                </div> :
                                <div>
                                    <p className="title2">{msg.name} : </p>
                                    <p>{msg.message}</p>
                                </div>
                            }
                        </div>)
                })}
            </div>
        );
    };



    render(){
        return(
            <div>
                <div>
                User : <input type="text" value={this.state.name} onChange={this.handleInputChanged.bind(this)}/>
                </div>

                <div>
                    <table>
                        <tr>
                            <td>
                            <TextField id="outlined-basic" label="Eneter Message to Send" variant="outlined"
                                onChange={(event)=>{
                                    this.setState({typedMessage : event.target.value});
                                }}
                                />
                                
                            </td>
                            <td>                                
                                <button onClick={this.handleButtonClicked.bind(this)}>
                                    submmit                
                                </button>
                            </td>
                        </tr>
                    </table>
                    
                </div>
                <br/><br/>
                <div className="align-center">
                    {this.displayMessages()}
                </div>

                <SockJsClient url='http://localhost:8080/websocket-chat/'
                              topics={['/topic/room/2']}
                              onConnect={()=>{
                                  console.log("connected");
                              }}
                              onDisconnect={()=>{
                                  console.log("Disconnected");
                              }}
                              onMessage={(msg)=>{
                                  let jobs = this.state.messages;
                                  jobs.push(msg);
                                  this.setState({messages : jobs});
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