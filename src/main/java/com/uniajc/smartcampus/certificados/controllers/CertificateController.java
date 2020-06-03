package com.uniajc.smartcampus.certificados.controllers;

import com.uniajc.smartcampus.certificados.models.Certificate;
import com.uniajc.smartcampus.certificados.services.CertificateService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<Certificate> getalgo(@PathVariable Long id){
        return certificateService.getCertificateRepository(id);
    }

}
