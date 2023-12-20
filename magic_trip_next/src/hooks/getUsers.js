import { useEffect, useState } from "react";
import axios from "axios";

const GetUsers = () => {
	const [user, setuser] = useState([]);
	
  
  const fetchData = async () => {
    axios
      .get(`http://localhost:8080/usuarios`)
      .then((res) => setuser(res.data))
      .catch((err) =>
        console.error("Erro ao buscar a lista de usuários:", err)
      );
  };

	useEffect(() => {	
		fetchData();
	}, []);

	return { user };
};

export default GetUsers;
