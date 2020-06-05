package com.uniajc.smartcampus.certificados.controllers.models.request;

import com.uniajc.smartcampus.certificados.controllers.models.Certificate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CertificateGenerateRequest {

    private  Long cgId;
    private String cgUrl;
    private String cgPrograma;
    private String cgPeriodo;
    private Instant cgFecha;
    private Integer cgReciboId;
    private Certificate certificate;

}
