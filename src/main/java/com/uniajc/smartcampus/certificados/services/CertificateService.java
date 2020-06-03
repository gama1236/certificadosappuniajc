package com.uniajc.smartcampus.certificados.services;

import com.uniajc.smartcampus.certificados.models.Certificate;
import com.uniajc.smartcampus.certificados.repository.CertificateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CertificateService {

    private final CertificateRepository certificateRepository;

    @Autowired
    public CertificateService (CertificateRepository certificateRepository){
        this.certificateRepository=certificateRepository;
    }

    public List <Certificate> getCertificateRepository(Long id) {
        return certificateRepository.findByTypeCertificate_TcId(id);
    }
}
