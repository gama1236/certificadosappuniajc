package com.uniajc.smartcampus.certificados.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "certificado")
@ApiModel(description = "Entidad JPA para certificado")
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "ceId")
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

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "ce_tipo_certificado_id")
    private TypeCertificate typeCertificate;

    @JsonManagedReference
    @OneToMany(mappedBy = "certificate")
    private List<CertificateGenerate> certificateGenerates;
}

