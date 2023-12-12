package com.magictrip.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.magictrip.api.models.VendedorModel;

@Repository
public interface VendedorRepository extends JpaRepository<VendedorModel, Integer> {   
}
