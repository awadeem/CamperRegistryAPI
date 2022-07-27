package com.employed1.camper.domain.repository;

import com.employed1.camper.domain.model.Camper;
import com.employed1.camper.domain.model.CamperType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CamperRepo extends JpaRepository<Camper, Long> {
    Optional<Camper> findByEmail(String email);
    List<Camper> findByLastName (String lastName);
    List<Camper> findByCamperType (CamperType type);

}
