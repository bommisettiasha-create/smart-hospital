export default function MedicalHistory(){
  return(
    <div style={{background:"#fff", padding:20, borderRadius:10}}>
      <h3>📋 Patient Medical History</h3>
      <table border="1" cellPadding="8" style={{width:"100%"}}>
        <tr><th>Date</th><th>Doctor</th><th>Problem</th></tr>
        <tr><td>2025-12-10</td><td>Dr. Ramesh</td><td>Fever</td></tr>
        <tr><td>2026-08-15</td><td>Dr. Suresh</td><td>BP Check</td></tr>
      </table>
    </div>
  )
}