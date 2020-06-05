package com.uniajc.smartcampus.certificados.controllers.repository;

import com.uniajc.smartcampus.certificados.controllers.models.Certificate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CertificateRepository extends JpaRepository<Certificate, Long> {

    List<Certificate> findByTypeCertificate_TcId(Long id);

}
