import logo from './logo.svg';
import './App.css';
import React, { useState } from "react";
function App() {
   const [count, setCount] = React.useState(0);

  const handleClick = () => {
    setCount(count + 1);
  };
  return (
    <div className="App">
      {count}
      <br></br>
      <button onClick={handleClick}>Click me</button>

    </div>
  );
}

export default App;
