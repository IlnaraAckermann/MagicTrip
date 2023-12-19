import React from 'react'
import Image from 'next/image'
const PromotionCard = ({destino}) => {
    const { idDestino, nome, descricao } = destino
	const imgUrl=`/imgs/${idDestino}.jpg`
	return (
		<>
		
        <div className="card principal">
        <Image
        className="card-img-top "
        src={imgUrl}
        alt={nome}
        width={600}
        height={400}
        layout="responsive"
       /> 
       <div id="medal">
    <span className="badge bg-danger">20%off</span>
       </div>
<div className="card-body">
  <h5 className="card-title">
    {nome}
  </h5>
  <p className="card-text">{descricao}</p>
  <a href="#" className="btn btn-primary">Visitar</a>
</div>
</div>
        </>
);
}

export default PromotionCard;
