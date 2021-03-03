import React, {Component} from "react";
import {Navbar} from "react-bootstarp";
import {BrowserRouter as Router, Route} from "react-router-dom";

import MainComponent from './MainComponent'
import DashboardComponent from './Dashboard'

class TopMenuComponent extends Component{
    render(){
        return(
            <Router>
                <Navbar
                    bg="dark"
                    className="mb-4">
                    <Navbar.Brand href="/">
                        Home
                    </Navbar.Brand>
                    <Navbar.Brand href="/main">
                        Main
                    </Navbar.Brand>
                    <Navbar.Brand href="/dashboard">
                        Dashboard
                    </Navbar.Brand>                       
                </Navbar>

                <Route Path="/main" component={MainComponent}/>
                <Route path="/dashboard" component={DashboardComponent}/>
            </Router>
        )
    }
}

export default TopMenuComponent;