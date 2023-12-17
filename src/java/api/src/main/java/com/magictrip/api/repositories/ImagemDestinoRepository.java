package com.magictrip.api.repositories;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.magictrip.api.models.ImagemDestinoModel;

@Repository
public interface ImagemDestinoRepository extends JpaRepository<ImagemDestinoModel, Integer> {
    @Query("SELECT img FROM ImagemDestinoModel img WHERE img.destino.idDestino = :destinoId")
    List<ImagemDestinoModel> findAllByDestinoId(@Param("destinoId") int destinoId);
}
