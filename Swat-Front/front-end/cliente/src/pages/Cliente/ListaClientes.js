import React, { useState, useEffect } from "react";
import { FiPower, FiEdit, FiTrash2 } from 'react-icons/fi';
import { useNavigate } from 'react-router-dom';
import './styleListaCliente.css';
import Menu from "../menu/menu";
import api from '../../services/api';

export default function ListaCliente() {
  const [ListaCliente, setListaCliente] = useState([]);
  const navigate = useNavigate();

  useEffect(() => {
    api.get('/cliente').then(response => {
      setListaCliente(response.data);
    });
  }, []);

  return (
    <>
      <div>
        <Menu />
      </div>
      <h1>Lista Clientes</h1>
      <div className="lista-container">
        <ul>
          {ListaCliente.map(cliente => (
            <li key={cliente.id}>
              <strong>Nome:</strong>
              <p>{cliente.nome}</p>
              <strong>RG:</strong>
              <p>{cliente.rg}</p>
              <strong>CPF:</strong>
              <p>{cliente.cpf}</p>
              <strong>Conta Bancária:</strong>
              <p>{cliente.contaBancaria ? cliente.contaBancaria.idConta : ''}</p>

              <button type="button">
                <FiEdit size={20} color="#251FC5" />
              </button>

              <button type="button">
                <FiTrash2 size={20} color="#FF0000" />
              </button>
            </li>
          ))}
        </ul>
      </div>
    </>
  );
}