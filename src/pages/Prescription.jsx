import { useState } from "react";
export default function Prescription(){
  const [med, setMed] = useState("");
  const save = () => {
    fetch("http://localhost:8080/api/prescriptions",{
      method:"POST", headers:{"Content-Type":"application/json"},
      body: JSON.stringify({patientId:1, doctorId:1, medicines:med, notes:"Take rest"})
    }).then(()=> alert("💊 Prescription Saved"));
  }
  return(
    <div style={{background:"#fff", padding:20, borderRadius:10}}>
      <h3>💊 Prescription Management</h3>
      <textarea placeholder="Paracetamol - 2 times, Azithromycin..." value={med} onChange={e=>setMed(e.target.value)} style={{width:"100%", height:80}}></textarea>
      <button onClick={save} style={{background:"#6f42c1", color:"#fff", padding:"8px 15px", border:0}}>Save Prescription</button>
    </div>
  )
}