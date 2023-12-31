import React, { useEffect } from "react";
import PageHead from "@/components/head/Head";
import getDestinos from "@/hooks/getDestinos";
import DestineCard from "@/components/cards/DestineCard";


  const Destinos = () => {
    const { destinos } = getDestinos();
  return (
    <>
    <PageHead titulo="MagicTrip - Viaje, sonhe, encante-se!"></PageHead>
    <main className='container d-flex flex-column align-content-center '> 

    <div className="text-center mt-3 ">
          <h1>Promoções</h1>
          <p>
          Venha descobrir o lado mágico do mundo com nossos destinos místicos! Explore ruínas antigas, templos sagrados e lugares misteriosos que vão despertar sua imaginação.
          </p>
        </div>
        <section className="my-5 ">
          <h2 className="text-center mb-3">Promoções Mágicas</h2>
          <div className="d-flex gap-5 flex-wrap justify-content-around mx-auto ">
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
        );
      };
      
export default Destinos;
