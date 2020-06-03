package com.uniajc.smartcampus.certificados.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.Instant;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "certificado_generado")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "cgId", scope = CertificateGenerate.class)
public class CertificateGenerate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cg_id")
    @ApiModelProperty(notes = "ID del certificado generado", required = true)
    private Long cgId;

    @Column(name = "cg_url")
    @ApiModelProperty(notes = "Url del certificado generado", required = true)
    private String cgUrl;

    @Column(name = "cg_programa")
    @ApiModelProperty(notes = "programa del certificado generado", required = true)
    private String cgPrograma;

    @Column(name = "cg_periodo")
    @ApiModelProperty(notes = "periodo del certificado generado", required = true)
    private String cgPeriodo;

    @Column(name = "cg_fecha")
    @ApiModelProperty(notes = "Fecha del certificado generado", required = true)
    private String cgFecha;

    @Column(name = "cg_recibo_id")
    @ApiModelProperty(notes = "periodo del certificado generado", required = true)
    private Integer cgReciboId;

    @ManyToOne
    @JoinColumn(name = "cg_certificado_id")
    private Certificate certificate;

}
