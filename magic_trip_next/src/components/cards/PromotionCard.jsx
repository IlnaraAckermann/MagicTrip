import React from 'react'
import Image from 'next/image'
const PromotionCard = ({destino}) => {
    const { idDestino, nome, descricao } = destino
	const imgUrl=`/imgs/${idDestino}.jpg`
	return (
		<>
		
        <div class="card principal bg-dark text-white">
        <Image
        className="card-img-top"
        src={imgUrl}
        width={300}
        height={400}
        alt={nome}
       />
<div class="card-body">
  <h5 class="card-title">
    {nome}
    <span class="badge bg-success ">20%off</span>
  </h5>
  <p class="card-text">{descricao}</p>
  <a href="#" class="btn btn-primary">Visitar</a>
</div>
</div>
        </>
);
}

export default PromotionCard;
