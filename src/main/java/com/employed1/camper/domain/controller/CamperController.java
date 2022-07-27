package com.employed1.camper.domain.controller;

import com.employed1.camper.domain.core.expections.CamperNotFoundException;
import com.employed1.camper.domain.model.Camper;
import com.employed1.camper.domain.model.CamperType;
import com.employed1.camper.domain.service.CamperService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/campers")
public class CamperController {
    private final Logger logger = LoggerFactory.getLogger(CamperController.class);
    private CamperService camperService;

    @Autowired
    public CamperController(CamperService camperService){
        this.camperService = camperService;
    }

    @PostMapping("")
    public ResponseEntity<Camper> createCamper(@RequestBody Camper camper){
        Camper savedCamper = camperService.create(camper);
        ResponseEntity response = new ResponseEntity(savedCamper, HttpStatus.CREATED);
        return response;
    }

    @GetMapping("")
    public ResponseEntity<List<Camper>> getAllCampers(){
        List<Camper> campers = camperService.getAllCamper();
        ResponseEntity<List<Camper>> response = new ResponseEntity<>(campers, HttpStatus.OK);
        return response;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCamperById(@PathVariable Long id){
        try {
            Camper camper = camperService.getById(id);
            ResponseEntity<?> response = new ResponseEntity<>(camper, HttpStatus.OK);
            return response;
        } catch (CamperNotFoundException e) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .build();
        }
    }
    @GetMapping("/{email}")
    public ResponseEntity<?> getByEmail(@PathVariable String email){
        try {
            Camper camper = camperService.getByEmail(email);
            ResponseEntity<?> response = new ResponseEntity<>(camper, HttpStatus.OK);
            return response;
        } catch (CamperNotFoundException e) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .build();
        }
    }

    @GetMapping("")
    public ResponseEntity<List<Camper>> getByLastName(String lastName) {
        try {
            List<Camper> campers = camperService.getByLastName(lastName);
            ResponseEntity<List<Camper>> response = new ResponseEntity<>(campers, HttpStatus.OK);
            return response;
        } catch (CamperNotFoundException e) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .build();
        }
    }
    @GetMapping("")
    public ResponseEntity<List<Camper>> getByCamperType(CamperType type) {
        try {
            List<Camper> campers = camperService.getByCamperType(type);
            ResponseEntity<List<Camper>> response = new ResponseEntity<>(campers, HttpStatus.OK);
            return response;
        } catch (CamperNotFoundException e) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .build();
        }
    }



    @PutMapping("/{id}")
    public ResponseEntity<?> updateCamper(@PathVariable Long id, @RequestBody Camper camper){
        try{
            Camper updatedCamper = camperService.update(id, camper);
            ResponseEntity response = new ResponseEntity(updatedCamper,HttpStatus.OK);
            return response;
        } catch (CamperNotFoundException e) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCamper(@PathVariable Long id){
        try{
            camperService.delete(id);
            return ResponseEntity
                    .status(HttpStatus.NO_CONTENT)
                    .build();
        } catch (CamperNotFoundException e) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .build();
        }
    }



}
