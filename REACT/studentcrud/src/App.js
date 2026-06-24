import './App.css';
import {useState} from 'react';
let istudents=[{name:"CVR",age:20,grade:"S"},
  {name:"CVR1",age:21,grade:"A"},
  {name:"Palvasha",age:19,grade:"A+"},
  {name:"Deekshitha",age:16,grade:"B+"},
  {name:"Swathi",age:18,grade:"A++"}];
function App() {
  let [students,setStudents]=useState(istudents);
  let [editIndex,setEditIndex]=useState(null);
  let [formData,setFormData]=useState({name:"",age:"",grade:""})
  let [search,setsearch]=useState("");
  let [ascending,setAscending]=useState(true);
  const handleDelete=(i)=>{
    const updatedStudents=students.filter((s,index)=>index!==i) //the index which is not matching is updated in to updatedstudents
    setStudents(updatedStudents)
  }
  const handleChange=(e)=>{
    setFormData({...formData,[e.target.name]:e.target.value}) //object so curly braces
  }
  const handleAdd=()=>{
    setStudents([...students,formData]) //students is array so []
    setFormData({name:"",age:"",grade:""})
  }
  const handleEdit=(i)=>{
    setEditIndex(i);
    setFormData(students[i]);
  }
  const handleUpdate=()=>{
    const updateStudents=students.map((s,i)=>i===editIndex?formData:s);
    setStudents(updateStudents);
    setEditIndex(null);
    setFormData({name:"",age:"",grade:""});
  }
  const filteredStudents=students.filter((s)=>s.name.toLowerCase().includes(search.toLowerCase()))
  //const sortedStundents=[...filteredStudents].sort((a,b)=>a.name.localeCompare(b.name));
const handleSort = () => {
  const sortedStudents = [...students].sort((a,b) =>
    ascending
      ? a.name.localeCompare(b.name)
      : b.name.localeCompare(a.name)
  );

  setStudents(sortedStudents);
  setAscending(!ascending);
};
  return (
    <div className="App">
      <input
  className="form-control"
  placeholder="Type to search"
  value={search}
  onChange={(e)=>setsearch(e.target.value)}
/>
      <div className='form'>
        <h2>{editIndex==null?"Add Student" : "Edit Student"}</h2>
        <input className="form-control m-2" name="name" value={formData.name} onChange={handleChange} ></input>
        <input className="form-control m-2 " name="age" value={formData.age} onChange={handleChange} ></input>
        <input className="form-control m-2" name="grade" value={formData.grade} onChange={handleChange}></input>
        {editIndex==null?<button className='btn btn-primary m-4 'onClick={()=>handleAdd()} >Add Student</button>
        :<button className='btn btn-primary m-4 'onClick={()=>handleUpdate()} >Update Student</button>}
      </div>
      <h2>Student List</h2>
      <table className='table table-bordered m-3'>
        <thead>
          <tr>
            <th style={{cursor:"pointer"}} onClick={handleSort}>NAME</th>
            <th>AGE</th>
            <th>GRADE</th>
            <th>ACTIONS</th>
          </tr>
        </thead>
        <tbody>
          {filteredStudents.map((s,index)=>
              <tr key={index}>
              <td>{s.name}</td><td>{s.age}</td><td>{s.grade}</td>
              <td><button className='btn btn-primary m-2' onClick={()=>handleEdit(index)}>Edit</button >
              <button className='btn btn-danger' onClick={()=>handleDelete(index)}>Delete</button></td>
            </tr>
            
          )}
        </tbody>
      </table>
    </div>
  );
}

export default App;
