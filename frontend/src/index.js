import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import App from './App';

// Renderiza o componente principal <App /> dentro da div com id 'root' (no index.html)
const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <React.StrictMode>
    <App />
  </React.StrictMode>
);
