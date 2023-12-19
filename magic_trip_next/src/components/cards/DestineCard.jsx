import React from "react";
import Image from "next/image";
const DestineCard = ({ destino }) => {
	const { idDestino, nome, descricao } = destino;
	const imgUrl = `/imgs/${idDestino}.jpg`;
	return (
		<>
			<div className="card">
				<Image
					className="card-img-top"
					src={imgUrl}
					alt={nome}
					width={600}
					height={400}
					layout="responsive"
				/>
				<div className="card-body">
					<h5 className="card-title">{nome}</h5>
					<p className="card-text">{descricao}</p>
					<a
						href="#"
						className="btn btn-primary"
					>
						Visitar
					</a>
				</div>
			</div>
		</>
	);
};

export default DestineCard;
