export default function AppointmentBooking(){
  const book = () => {
    fetch("http://localhost:8080/api/appointments/book",{
      method:"POST", headers:{"Content-Type":"application/json"},
      body: JSON.stringify({patientId:1, doctorId:1, date:"2026-09-24", status:"BOOKED"})
    }).then(()=> alert("✅ Appointment Booked!"));
  }
  return(
    <div style={{background:"#fff", padding:20, borderRadius:10}}>
      <h3>📅 Doctor Appointment Booking</h3>
      <select><option>Dr. Ramesh - Cardiology</option><option>Dr. Suresh - Dental</option></select>
      <input type="date" defaultValue="2026-09-24" />
      <button onClick={book} style={{background:"#198754", color:"#fff", padding:"8px 15px", border:0, marginTop:10}}>Book Now</button>
    </div>
  )
}