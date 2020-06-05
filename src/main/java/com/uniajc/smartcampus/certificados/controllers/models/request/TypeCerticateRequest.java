package com.uniajc.smartcampus.certificados.controllers.models.request;

import com.uniajc.smartcampus.certificados.controllers.models.Certificate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * ModeloDTO de tipo de certifacado
 *
 * @author <a href="mailto:stivencastroarias2@gmail.com">
 * date: 15/05/2020
 * SP-0
 * */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TypeCerticateRequest {

    private Long tcId;
    private String tcName;
    private Boolean tcState;
    private String tcResponsable;
    private String tcJob;
    private String tcUserFirm;
    private String tcPassFirm;
    private String tcIssuer;
    private List<Certificate> certificate;

}
