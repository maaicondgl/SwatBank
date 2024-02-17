import React, { useState, useEffect } from "react";
import { FiPower, FiEdit, FiTrash2 } from 'react-icons/fi';
import { useNavigate } from 'react-router-dom';
import './styleConta.css';
import Menu from "../menu/menu";

import api from '../../services/api';
import ContaBancariaForm from "./ContaBancaria";

export default function ListaContaBancaria() {
  const [listaContaBancaria, setListaContaBancaria] = useState([]);

  const navigate = useNavigate();

  useEffect(() => {
    api.get('/contaBancaria').then(response => {
      setListaContaBancaria(response.data);
    });
  }, []);

  return (
    <>
      <body>
        <div>
          <Menu />
        </div>
        <h1>Lista de Contas</h1>
        <div className="lista-container">
          <ul>
            {listaContaBancaria.map(contaBancaria => (
              <li key={contaBancaria.idConta}>
                <strong>ID Conta:</strong>
                <p>{contaBancaria.idConta}</p>
                <strong>Agência Bancária:</strong>
                <p>{contaBancaria.agencia}</p>
                <strong>Número da Conta:</strong>
                <p>{contaBancaria.conta}</p>
                <strong>Saldo:</strong>
                <p>{contaBancaria.saldo}</p>
                <strong>Limite:</strong>
                <p>{contaBancaria.limite}</p>
                <strong>Cheque Especial:</strong>
                <p>{contaBancaria.chequeEspecial}</p>
                <strong>Juros da conta:</strong>
                <p>{contaBancaria.jurosChequeEspecial}</p>


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
      </body>
    </>
  );
}