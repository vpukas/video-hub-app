import React, { useState } from 'react';
import axios from 'axios';
import { Link, useNavigate }  from 'react-router-dom';
import './Login.css';

const Login = () => {
    const [formData, setFormData] = useState({
        email: '',
        password: '',
    });
    const navigate = useNavigate();

    const handleChange = (e) => {
        const { name, value } = e.target;
        setFormData({
            ...formData,
            [name]: value,
        });
    };

    const handleSubmit = (e) => {
        e.preventDefault();

        axios.post('http://localhost:8080/api/v1/auth/authenticate',formData, {
            headers: {
                'Content-type': 'application/json'
            }
        })
            .then(response => {
                localStorage.setItem('token', response.data.token);
                navigate("/");
            })
    };

    return (
        <div className="login-container">
            <form className="login-form" onSubmit={handleSubmit}>
                <h2>Login</h2>
                <div>
                    <label>Email:</label>
                    <input
                        type="email"
                        name="email"
                        value={formData.email}
                        onChange={handleChange}
                        required
                    />
                </div>
                <div>
                    <label>Password:</label>
                    <input
                        type="password"
                        name="password"
                        value={formData.password}
                        onChange={handleChange}
                        required
                    />
                </div>
                <button type="submit">Login</button>
               <p>Don't have an account yet? <Link to="/register">Register</Link></p>
            </form>
        </div>
    );
};

export default Login;
