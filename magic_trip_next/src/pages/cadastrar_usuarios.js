import React, { useEffect } from "react";
import UserCard from "@/components/cards/UserCard";
import PageHead from "@/components/head/Head";
import useUsuarios from "../hooks/useUsuarios";


const CadastrarUsuarios = () => {
  const { usuarios, listar } = useUsuarios();
  useEffect(() => {
    listar();
  }, []);

  
      return (
      <>
      <PageHead titulo="Usuários Mágicos!" />
        <div className='your-page-container'>
          <h1>Nossos usuarios</h1>
          <section className="my-5 ">
          <h2 className="text-center mb-3">Destinos Mágicos</h2>
          <div className="d-flex gap-5 flex-wrap justify-content-around mx-auto ">
            {usuarios.map((user, i) => (
              <UserCard
                key={i}
                user={user}
              />
            ))}
          </div>
        </section>
        </div>
      </>
      );
    };
    
    export default CadastrarUsuarios;