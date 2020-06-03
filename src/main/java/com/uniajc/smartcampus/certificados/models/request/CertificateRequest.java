package com.uniajc.smartcampus.certificados.models.request;

import com.uniajc.smartcampus.certificados.models.CertificateGenerate;
import com.uniajc.smartcampus.certificados.models.TypeCertificate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CertificateRequest {

    private Long cdId;
    private String ceCode;
    private  String ceName;
    private  Boolean ceState;
    private TypeCertificate typeCertificate;
    private List<CertificateGenerate> certificateGenerates;
}
