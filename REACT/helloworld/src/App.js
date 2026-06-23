import logo from './logo.svg';
import './App.css';
import React, { useState } from "react";
import comp from './functionalComponentProp';
function App() {
  const [count,setCount]=React.useState(0);
  const handleClick=()=>{
    setCount(count+1);
  };
  return ( 
    <div className="App">
      <br></br>
      {count}
      <br></br>
      <br></br>
      <button onClick={handleClick}>Click Me</button>
       <h1>HELLO WORLD!!!</h1>
    </div>
   
  );
}

export default App;
