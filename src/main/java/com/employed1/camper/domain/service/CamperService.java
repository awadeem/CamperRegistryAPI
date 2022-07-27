package com.employed1.camper.domain.service;

import com.employed1.camper.domain.core.expections.CamperNotFoundException;
import com.employed1.camper.domain.model.Camper;
import com.employed1.camper.domain.model.CamperType;

import java.util.List;

public interface CamperService {
    Camper create(Camper camper);
    List<Camper> getAllCamper();
    Camper getById(Long id) throws CamperNotFoundException;
    List<Camper> getByLastName(String lastName) throws CamperNotFoundException;
    Camper getByEmail(String email) throws CamperNotFoundException;
    List<Camper> getByCamperType(CamperType type) throws CamperNotFoundException;
    Camper update(Long id, Camper camper) throws CamperNotFoundException;
    void delete(Long id) throws CamperNotFoundException;


}
