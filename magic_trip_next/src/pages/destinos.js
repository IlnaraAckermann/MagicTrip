import DestineCard from "@/components/cards/DestineCard";
import PageHead from "@/components/head/Head";
import { useEffect, useState } from "react";
import axios from "axios";

const Destinos= () => {
  const [destinos, setDestinos] = useState([]);
 
  useEffect(() => {
    axios
      .get("http://localhost:8080/destinos")
      .then((response) => {
        setDestinos(response.data);
      })
      .catch((error) => {
        console.error("Erro ao buscar a lista de destinos:", error);
      });
  }, []);

  return (
    <>
    <PageHead titulo="MagicTrip - Viaje, sonhe, encante-se!"></PageHead>
    <main className='container d-flex flex-column align-content-center '> 

    <div className="text-center mt-3 ">
          <h1>Destinos</h1>
          <p>
          Venha descobrir o lado mágico do mundo com nossos destinos místicos! Explore ruínas antigas, templos sagrados e lugares misteriosos que vão despertar sua imaginação.
          </p>
        </div>
        <section className="my-5 ">
          <h2 className="text-center mb-3">Destinos Mágicos</h2>
          <div className="d-flex gap-5 flex-wrap justify-content-around mx-auto " id="nacionais">
            {destinos.map((destino, i) => (
              <DestineCard
                key={i}
                destino={destino}
              />
            ))}
          </div>
        </section>

    </main>
    </>
  )
}
export default Destinos;
