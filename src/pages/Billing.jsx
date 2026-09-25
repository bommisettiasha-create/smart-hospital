export default function Billing(){
  const gen = () => {
    fetch("http://localhost:8080/api/billing",{
      method:"POST", headers:{"Content-Type":"application/json"},
      body: JSON.stringify({patientId:1, amount:850, status:"PAID", billDate:new Date().toISOString()})
    }).then(()=> alert("🧾 Bill Generated - Rs 850"));
  }
  return(
    <div style={{background:"#fff", padding:20, borderRadius:10}}>
      <h3>🧾 Billing</h3>
      <p>Consultation: ₹500</p><p>Medicines: ₹350</p><b>Total: ₹850</b><br/>
      <button onClick={gen} style={{background:"#fd7e14", color:"#fff", padding:"8px 15px", border:0, marginTop:10}}>Generate Bill</button>
    </div>
  )
}