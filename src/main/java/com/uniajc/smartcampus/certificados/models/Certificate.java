package com.uniajc.smartcampus.certificados.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "certificado")
@ApiModel(description = "Entidad JPA para certificado")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "ceId", scope = Certificate.class)
public class Certificate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ce_id")
    @ApiModelProperty(notes = "ID del tipo de certificado", required = true)
    private Long ceId;

    @Column(name = "ce_codigo")
    @ApiModelProperty(notes = "Codigdo del certificado", required = true)
    private String ceCode;

    @Column(name = "ce_nombre")
    @ApiModelProperty(notes = "Nombre de certificado", required = true)
    private  String ceName;

    @Column(name = "ce_estado")
    @ApiModelProperty(notes = "Estado de certificado", required = true)
    private  Boolean ceState;

    @ManyToOne
    @JoinColumn(name = "ce_tipo_certificado_id")
    private TypeCertificate typeCertificate;

    @OneToMany(mappedBy = "certificate", cascade = CascadeType.ALL)
    private List<CertificateGenerate> certificateGenerates;
}

