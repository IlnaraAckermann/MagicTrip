import React from 'react'
import Image from 'next/image'
const DestineCard = ({destino}) => {
    const { idDestino, nome, descricao } = destino
	const imgUrl=`/imgs/${idDestino}.jpg`
	return (
		<>
		
			<div className="card bg-dark text-white ">
				<Image
					className="card-img-top"
					src={imgUrl}
					width={300}
					height={400}
					alt={nome}
				/>
				<div className="card-body">
					<h5 className="card-title">{nome}</h5>
					<p className="card-text">
						{descricao}
					</p>
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
}

export default DestineCard;
