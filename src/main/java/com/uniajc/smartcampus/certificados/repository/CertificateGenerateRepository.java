package com.uniajc.smartcampus.certificados.repository;

import com.uniajc.smartcampus.certificados.models.CertificateGenerate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CertificateGenerateRepository extends JpaRepository<CertificateGenerate,Long> {



}
