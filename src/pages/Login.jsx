import { useState } from "react";

export default function Login({ setRole }) {
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");

  const handleLogin = async () => {
    if (!email || !password) {
      alert("Email and Password enter chey");
      return;
    }
    try {
      const res = await fetch("http://localhost:8081/api/auth/login", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({ email, password }),
      });
      const data = await res.json();
      if (data.role) {
        localStorage.setItem("role", data.role);
        localStorage.setItem("userId", data.userId);
        setRole(data.role);
        alert("Login Success: " + data.role);
      } else {
        alert(data.message || "Login Failed");
      }
    } catch (err) {
      alert("Backend connect avvatledu. 8081 run avuthunda chudu");
    }
  };

  return (
    <div style={{ background: "#fff", padding: "20px", borderRadius: "10px", maxWidth: "350px", margin: "20px auto", boxShadow: "0 0 10px #ccc" }}>
      <h3 style={{ color: "#0d6efd" }}>🔐 Smart Hospital Login</h3>
      <input 
        style={{ width: "100%", padding: "8px", margin: "8px 0" }}
        placeholder="Email" 
        value={email}
        onChange={(e) => setEmail(e.target.value)} 
      />
      <input 
        style={{ width: "100%", padding: "8px", margin: "8px 0" }}
        placeholder="Password" 
        type="password" 
        value={password}
        onChange={(e) => setPassword(e.target.value)} 
      />
      <button 
        onClick={handleLogin} 
        style={{ background: "#0d6efd", color: "#fff", padding: "8px", width: "100%", border: "none", borderRadius: "5px", cursor: "pointer" }}
      >
        Login
      </button>
      <p style={{ fontSize: "12px", marginTop: "10px" }}>
        Test IDs: <br/>
        admin@gmail.com / 123 <br/>
        doctor@gmail.com / 123 <br/>
        patient@gmail.com / 123
      </p>
    </div>
  );
}