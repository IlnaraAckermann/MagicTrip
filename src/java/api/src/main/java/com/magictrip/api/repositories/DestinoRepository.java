package com.magictrip.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.magictrip.api.models.DestinoModel;
@Repository
public interface DestinoRepository extends JpaRepository<DestinoModel, Integer> {

    
} 
