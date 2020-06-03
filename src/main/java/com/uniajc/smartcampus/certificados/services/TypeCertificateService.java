package com.uniajc.smartcampus.certificados.services;


import com.uniajc.smartcampus.certificados.models.TypeCertificate;
import com.uniajc.smartcampus.certificados.repository.TypeCertificateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Servicios del modelo tipo de certificado
 *
 * @author <a href="mailto:stivencastroarias2@gmail.com">
 * date: 15/05/2020
 * SP-0
 * */
@Service
public class TypeCertificateService {

    private final TypeCertificateRepository typeCertificateRepository;

    @Autowired
    public TypeCertificateService(TypeCertificateRepository typeCertificateRepository) {
        this.typeCertificateRepository = typeCertificateRepository;
    }

    /**
     * Metodo del servicio, encargado de guardar el modelo de tipo de certificado
     *
     * @author <a href="mailto:stivencastroarias2@gmail.com">
     * @param typeCertificate
     * @return TypeCertificate {@link TypeCertificate}
     * date: 15/05/2020
     * SP-0
     * */
    public TypeCertificate saveTypeCertificate(TypeCertificate typeCertificate) {
        return typeCertificateRepository.save(typeCertificate);
    }

    /**
     * Metodo del servicio encargado de actulizar el modelo de tipo de certificado
     *
     * @author <a href="mailto:stivencastroarias2@gmail.com">
     * @param typeCertificate
     * @return TypeCertificate {@link TypeCertificate}
     * date: 15/05/2020
     * SP-0
     * */
    public TypeCertificate updateTypeCertificate(TypeCertificate typeCertificate) {
        return typeCertificateRepository.save(typeCertificate);
    }

    /**
     * Metodo encargado de obtener una lista del modelo de tipo de certificado
     *
     * @author <a href="mailto:stivencastroarias2@gmail.com">
     * @return Lista de {@link TypeCertificate}
     * date: 15/05/2020
     * SP-0
     * */
    public List<TypeCertificate> getAllTypeCertificate() {
        return typeCertificateRepository.findAll();
    }

    /**
     * Metodo encargado de Borrar el modelo de tipo de certificado por id
     *
     * @author <a href="mailto:stivencastroarias2@gmail.com">
     * date: 15/05/2020
     * SP-0
     * */
    public  void  delectTypeCertificate(Long id) {
        typeCertificateRepository.deleteById(id);
    }

    public List<TypeCertificate> findbyIdCertificate(Long id) {
        return typeCertificateRepository.findByTcId(id);
    }

}
