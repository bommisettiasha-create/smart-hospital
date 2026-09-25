import { useState, useEffect } from "react";
export default function AdminDashboard(){
  const [stats, setStats] = useState({doctors:2, patients:3, appointments:5});
  const [search, setSearch] = useState("");
  useEffect(()=>{
    fetch("http://localhost:8080/api/admin/stats").then(r=>r.json()).then(setStats).catch(()=>{});
  },[]);
  return(
    <div style={{background:"#fff", padding:20, borderRadius:10}}>
      <h3>📊 Admin Dashboard + 🔍 Advanced Search/Filter</h3>
      <input placeholder="Search Doctor / Patient / Bill" value={search} onChange={e=>setSearch(e.target.value)} style={{width:"100%", padding:10, marginBottom:10}} />
      <div style={{display:"flex", gap:10}}>
        <div style={{background:"#e3f2fd", padding:15, flex:1, borderRadius:8}}><b>Doctors</b><br/>{stats.doctors}</div>
        <div style={{background:"#e8f5e9", padding:15, flex:1, borderRadius:8}}><b>Patients</b><br/>{stats.patients}</div>
        <div style={{background:"#fff3e0", padding:15, flex:1, borderRadius:8}}><b>Appointments</b><br/>{stats.appointments}</div>
      </div>
    </div>
  )
}