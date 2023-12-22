import React from 'react';
import Image from 'next/image';
const UserCard = ({ user }) => {
  const {nome, cpf, endereco, cidade, estado, email} =user;
  const imgUrl = `/imgs/avatar.jpg`;

  return (
		<>
      <div className="card mb-3">
        <div className="card-header">{nome}</div>
        <div className="card-body">
          <div className="card principal">
          <Image 
            	src={imgUrl}
              alt={nome}
              width={300}
              height={300}
               />  
            <ul className="list-group list-group-flush">
              <li className="list-group-item">CPF: {cpf}</li>
              <li className="list-group-item">Endereço: {endereco}</li>
              <li className="list-group-item">Cidade: {cidade}</li>
              <li className="list-group-item">Estado: {estado}</li>
              <li className="list-group-item">Email: {email}</li>
            </ul>
          </div> 
        </div>    
      </div>
    </>
);

}
export default UserCard;