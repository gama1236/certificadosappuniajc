package com.uniajc.smartcampus.certificados.controllers.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

/**
 * Modelo de tipo de certificado
 *
 * @author <a href="mailto:stivencastroarias2@gmail.com"> Stiven Castrp</a>
 * @date 15/05/2020
 * @HU_CU_REQ SP0
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tipo_certificado")
@ApiModel(description = "Entidad JPA para tipos de certificado")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "tcId", scope = TypeCertificate.class)
public class TypeCertificate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tc_id")
    @ApiModelProperty(notes = "ID del tipo de certificado", required = true)
    private  Long tcId;

    @Column(name = "tc_nombre")
    @ApiModelProperty(notes = "Nombre del tipo de certificado", required = true)
    private String tcName;

    @Column(name = "tc_estado")
    @ApiModelProperty(notes = "Estado del tipo de certificado", required = true)
    private Boolean tcState;

    @Column(name = "tc_responsable")
    @ApiModelProperty(notes = "Responsable de generar el tipo de certificado", required = true)
    private String tcResponsable;

    @Column(name = "tc_cargo_responsable")
    @ApiModelProperty(notes= "Cargo del responsable de generar el tipo de certificado ", required = true)
    private String tcJob;

    @Column(name = "tc_usuario_firma")
    @ApiModelProperty(notes = "Firma del usuario", required = true)
    private String tcUserFirm;

    @Column(name = "tc_pass_firma")
    @ApiModelProperty(notes = "Contraseña de la firma",required = true)
    private String tcPassFirm;

    @Column(name = "tc_issuer")
    private  String tcIssuer;

    @OneToMany(mappedBy = "typeCertificate", cascade = CascadeType.ALL)
    private List <Certificate> certificate;

}
