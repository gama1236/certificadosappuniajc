package com.uniajc.smartcampus.certificados.controllers.repository;

import com.uniajc.smartcampus.certificados.controllers.models.TypeCertificate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * Repositorio del modelo Tipo de cetificado
 *
 * @author <a href="mailto:stivencastroarias2@gmail.com">
 * date: 15/05/2020
 * SP-0
 * */
@Repository
public interface TypeCertificateRepository extends JpaRepository<TypeCertificate, Long> {

    List<TypeCertificate> findByTcId(Long id);

}
