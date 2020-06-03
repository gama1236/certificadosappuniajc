
CREATE TABLE certificado (
    ce_id  SERIAL NOT NULL,
    ce_codigo CHARACTER VARYING(50) NOT NULL,
    ce_nombre CHARACTER VARYING(100) NOT NULL,
    ce_estado BOOLEAN NOT NULL,
    ce_tipo_certificado_id INTEGER NOT NULL,
    PRIMARY KEY (ce_id)
);



CREATE TABLE tipo_certificado (
    tc_id SERIAL NOT NULL,
    tc_nombre CHARACTER VARYING(50) NOT NULL,
    tc_estado BOOLEAN NOT NULL,
    tc_responsable CHARACTER VARYING(150) NOT NULL,
    tc_cargo_responsable CHARACTER VARYING(100) NOT NULL,
    tc_usuario_firma CHARACTER VARYING(50) NOT NULL,
    tc_pass_firma CHARACTER VARYING(100) NOT NULL,
    tc_issuer CHARACTER VARYING(250) NOT NULL,
    PRIMARY KEY (tc_id)
);

CREATE TABLE certificado_generado (
    cg_id  SERIAL NOT NULL,
    cg_url CHARACTER VARYING(100) NOT NULL,
    cg_programa CHARACTER VARYING(50) NOT NULL,
    cg_periodo CHARACTER VARYING(10) NOT NULL,
    cg_fecha CHARACTER VARYING NOT NULL ,
    cg_certificado_id INTEGER NOT NULL,
    cg_recibo_id INTEGER,
    PRIMARY KEY (cg_id)
);

ALTER TABLE certificado ADD CONSTRAINT FKcertificado_tipocert FOREIGN KEY (ce_tipo_certificado_id) REFERENCES tipo_certificado (tc_id);
ALTER TABLE certificado_generado ADD CONSTRAINT FKcertificadogen_cert FOREIGN KEY (cg_certificado_id) REFERENCES certificado (ce_id);
