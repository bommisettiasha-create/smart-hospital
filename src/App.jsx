import { useState } from "react";
import Login from "./pages/Login";
import AppointmentBooking from "./pages/AppointmentBooking";
import Prescription from "./pages/Prescription";
import Billing from "./pages/Billing";
import MedicalHistory from "./pages/MedicalHistory";
import AdminDashboard from "./pages/AdminDashboard";

export default function App(){
  const [role, setRole] = useState(localStorage.getItem("role") || "ADMIN");
  return(
    <div style={{background:"#f4f6f9", minHeight:"100vh", padding:20, fontFamily:"Arial"}}>
      <h1 style={{textAlign:"center"}}>🏥 SmartCare Hospital Management</h1>
      <p style={{textAlign:"center"}}>Role: {role} | All 7 Features Included</p>
      
      <Login setRole={setRole} />
      <div style={{display:"grid", gridTemplateColumns:"1fr 1fr", gap:15}}>
        <AppointmentBooking />
        <Prescription />
        <Billing />
        <MedicalHistory />
      </div>
      <div style={{marginTop:15}}>
        <AdminDashboard />
      </div>
    </div>
  )
}