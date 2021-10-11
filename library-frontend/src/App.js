import './App.css';
import {BrowserRouter as Router, Link, Route, Switch } from 'react-router-dom'
//use react router to navigate from default page to employee and user views
//documentation: https://reactrouter.com/
import EmpView from './components/employee/EmpView';
import UserView from './components/user/UserView';

function App() {
  return (
    <div className="App">
      <h1>Welcome to the Library Web Page</h1>
      <br/>
      <Router>
        <Link to={'/employee'}><button>Employee View</button></Link>
        <Link to={'/user'}><button>User</button></Link>
        <Switch>
          <Route path='/employee' component={EmpView}/>
          <Route path='/user' component={UserView}/>
        </Switch>
      </Router>
    </div>
  );
}

export default App;
