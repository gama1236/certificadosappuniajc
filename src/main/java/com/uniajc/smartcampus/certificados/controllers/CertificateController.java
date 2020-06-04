package com.uniajc.smartcampus.certificados.controllers;

import com.uniajc.smartcampus.certificados.responses.CertificateResponse;
import com.uniajc.smartcampus.certificados.responses.SimpleResponse;
import com.uniajc.smartcampus.certificados.services.CertificateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/certificate")
public class CertificateController {

    private final CertificateService certificateService;

    @Autowired
    public CertificateController (CertificateService certificateService) {
        this.certificateService= certificateService;
    }

    @GetMapping("/show/{id}")
    public ResponseEntity<SimpleResponse> getalgo(@PathVariable Long id){
        List<CertificateResponse> certificateList = certificateService.getCertificateRepository(id);

        return new ResponseEntity<>(SimpleResponse.builder().code(200).message("Exito").value(certificateList).build(), HttpStatus.OK);
    }

}
