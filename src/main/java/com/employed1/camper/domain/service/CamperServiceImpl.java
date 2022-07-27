package com.employed1.camper.domain.service;

import com.employed1.camper.domain.core.expections.CamperNotFoundException;
import com.employed1.camper.domain.model.Camper;
import com.employed1.camper.domain.model.CamperType;
import com.employed1.camper.domain.repository.CamperRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CamperServiceImpl implements CamperService{

    private static Logger logger = LoggerFactory.getLogger(CamperServiceImpl.class);

    private CamperRepo camperRepo;

    @Autowired
    public CamperServiceImpl(CamperRepo camperRepo){
        this.camperRepo = camperRepo;
    }


    @Override
    public Camper create(Camper camper) {
        return null;
    }

    @Override
    public List<Camper> getAllCamper() {
        return null;
    }

    @Override
    public Camper getById(Long id) throws CamperNotFoundException {
        return null;
    }

    @Override
    public List<Camper> getByLastName(String lastName) throws CamperNotFoundException {
        return null;
    }

    @Override
    public Camper getByEmail(String email) throws CamperNotFoundException {
        return null;
    }

    @Override
    public List<Camper> getByCamperType(CamperType type) throws CamperNotFoundException {
        return null;
    }

    @Override
    public Camper update(Long id, Camper camper) throws CamperNotFoundException {
        return null;
    }

    @Override
    public void delete(Long id) throws CamperNotFoundException {

    }
}
