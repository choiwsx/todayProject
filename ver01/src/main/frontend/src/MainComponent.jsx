import React, {Component} from "react";
import axios from "axios";

class MainComponent extends Component{

    constructor(props){
        super(props)
        this.state={
            message:""
        }
    }
    componentDidMount(){
        this.getApi();
    }

    getApi = () => {
        axios.get("http://localhost:8080/api/hello")
            .then(res=>{
                console.log(res);
                this.setState({
                    message : res.data.message
                })
            })
            .catch(res=>console.log(res))
    }


    render(){
        return(
            <div>
                메인 페이지
            </div>
        )
    }
}
export default MainComponent