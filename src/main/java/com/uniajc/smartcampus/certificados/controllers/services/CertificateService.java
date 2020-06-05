package com.uniajc.smartcampus.certificados.controllers.services;

import com.uniajc.smartcampus.certificados.controllers.repository.CertificateRepository;
import com.uniajc.smartcampus.certificados.controllers.responses.CertificateResponse;
import com.uniajc.smartcampus.certificados.controllers.models.Certificate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CertificateService {

    private final CertificateRepository certificateRepository;

    @Autowired
    public CertificateService (CertificateRepository certificateRepository){
        this.certificateRepository=certificateRepository;
    }

    public List <CertificateResponse> getCertificateRepository(Long id) {

        List<Certificate> certificateList  = certificateRepository.findByTypeCertificate_TcId(id);
        List<CertificateResponse> responseList =  new ArrayList<>();
        certificateList.forEach(x->
            x.getCertificateGenerates().forEach(y->{
                CertificateResponse c = CertificateResponse.builder()
                        .cgid(y.getCgId())
                        .cgurl(y.getCgUrl())
                        .cgfecha(y.getCgFecha())
                        .cgperido(y.getCgPeriodo())
                        .cgprograma(y.getCgPrograma())
                        .cenombre(x.getCeName())
                        .tcnombre(x.getTypeCertificate().getTcName())
                        .build();
                responseList.add(c);
            })
        );
        return responseList;
    }
}
