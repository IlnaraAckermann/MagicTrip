import { useEffect, useState } from "react";
import axios from "axios";

const getDestinos = () => {
  const [destinos, setDestinos] = useState([]);

  useEffect(() => {
    const fetchData = async () => {
      try {
        const response = await axios.get("http://localhost:8080/destinos");
        setDestinos(response.data);
      } catch (error) {
        console.error("Erro ao buscar a lista de destinos:", error);
      }
    };

    fetchData();
  }, []);

  return { destinos };
};

export default getDestinos;
