import { useEffect, useState } from "react";
import axios from "axios";

const useUsuarios = () => {
  const [usuarios, setUsuarios] = useState([]);

  const url = `http://localhost:8080/usuarios`;

  const listar = async () => {
    try {
      const response = await axios.get(url);
      setUsuarios(response.data);
    } catch (err) {
      console.error("Erro ao buscar a lista de usuários:", err);
    }
  };

  const criar = async (userData) => {
    try {
      await axios.post(url, userData);
      console.log("Cadastro realizado!!!");
      listar(); // Refresh the user list after creating
    } catch (err) {
      console.error("Erro ao criar usuário:", err);
    }
  };

  const atualizar = async (id, userData) => {
    try {
      await axios.post(`${url}/${id}`, userData);
      console.log("Cadastro atualizado!!!");
      listar(); // Refresh the user list after updating
    } catch (err) {
      console.error("Erro ao atualizar usuário:", err);
    }
  };

  const deletar = async (id) => {
    try {
      await axios.delete(`${url}/${id}`);
      console.log("Exclusão feita com sucesso!!!");
      listar(); // Refresh the user list after deleting
    } catch (err) {
      console.error("Erro ao deletar usuário:", err);
    }
  };

  const [formValues, setFormValues] = useState({
    nome: "",
    cpf: "",
    endereco: "",
    cidade: "",
    estado: "",
    email: "",
    senha: "",
  });
  const resetFormValues = () => {
    setFormValues({
      nome: "",
      cpf: "",
      endereco: "",
      cidade: "",
      estado: "",
      email: "",
      senha: "",
    });
  };

  const handleInputChange = (event) => {
    const { id, value } = event.target;
    setFormValues({ ...formValues, [id]: value });
  };

  const handleSubmit = (event) => {
    event.preventDefault();
    criar(formValues);
    resetFormValues()
  };

  return { usuarios, formValues, handleInputChange, handleSubmit, listar, atualizar, criar, deletar };
};

export default useUsuarios;