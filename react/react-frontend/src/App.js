import logo from './logo.svg';
import './App.css';
import UserComponent from './components/UserComponent';
import ChatComponent from './components/ChatComponent';
import ChatComponent2 from './components/ChatComponent2';
function App() {
  return (
    <div className="App">
      {/* <UserComponent /> */}
      
      <h1>1번 채팅방
        </h1><ChatComponent />
      <br/>
      <br/>
      <h1>2번 채팅방</h1>
      <ChatComponent2 />
    </div>
  );
}

export default App;
