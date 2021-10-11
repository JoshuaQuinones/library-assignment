//Video tutorial followed: https://www.youtube.com/watch?v=w7ejDZ8SWv8
//Stopped working along at 57 minutes exactly
import './App.css';
import { useState } from 'react'
import Header from './components/Header';
import Tasks from './components/Tasks'

const name = 'Joshua'

function App() {
  //useState is used so the tasks are part of the component, not ouside
  const [tasks, setTasks] = useState([ {
      "id": 1,
      "text": "Doctors Appointment",
      "day": "Feb 5th at 2:30pm",
      "reminder": true
    },
    {
      "id": 2,
      "text": "Meeting at School",
      "day": "Feb 6th at 1:30pm",
      "reminder": true
    }]
  )

  //Delete Task
  const deleteTask = (id) => {
    setTasks(tasks.filter((task)=>task.id !== id))
  }

  return (
    <div className="App">
      <Header name={name} />
      {tasks.length > 0 ? <Tasks tasks={tasks} onDelete={deleteTask}/> : 'No Tasks to show'}
    </div>
  );
}



export default App;
