package com.uniajc.smartcampus.certificados.controllers.controllers;

import com.uniajc.smartcampus.certificados.controllers.responses.CertificateResponse;
import com.uniajc.smartcampus.certificados.controllers.responses.SimpleResponse;
import com.uniajc.smartcampus.certificados.controllers.services.CertificateService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/certificate")
public class CertificateController {

    public static final String URL_CONTROLLER = "/certificate";

    private final CertificateService certificateService;

    @Autowired
    public CertificateController(CertificateService certificateService) {
        this.certificateService = certificateService;
    }

    /**
     * Metodo encargado de mostrar los certificados generados a partir de el id de un tipo de certificado
     *
     * @author <a href="mailto:raulandres462@gmail.com">
     * @param id id del tipo de certificado
     * date: 05/06/2020
     * SP-1
     * */
    @ApiOperation(value = "Shows all certificates generated from a certificate type, and displays them as a list", response = SimpleResponse.class, produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Certificates obtained successfully", response = CertificateResponse.class, responseContainer = "List"),
            @ApiResponse(code = 400, message = "Something went wrong"),
            @ApiResponse(code = 401, message = "Expired or invalid JWT token"),
            @ApiResponse(code = 404, message = "The table doesn't exist"),
            @ApiResponse(code = 403, message = "Role not allowed")})
    @ApiImplicitParams({
            @ApiImplicitParam(name = "JWT Token User", value = "Roles allowed: REGISTRO_ACADEMICO y TESORERIA", required = true, dataType = "string", paramType = "Authorization") })
    @GetMapping("/showGeneratedCertificates/TypeCertificate/{id}")
    @PreAuthorize("hasAnyRole('REGISTRO_ACADEMICO', 'TESORERIA')")
    public ResponseEntity<SimpleResponse> showGeneratedCertificatesByTypeCertificate(@PathVariable Long id) {
        List<CertificateResponse> certificateList = certificateService.getCertificateRepository(id);
        return new ResponseEntity<>(SimpleResponse.builder().code(200).message("Certificados Obtenidos con éxito").value(certificateList).build(), HttpStatus.OK);
    }

}
