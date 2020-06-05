package com.uniajc.smartcampus.certificados.controllers.responses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CertificateResponse {

   private String tcnombre;
   private String cenombre;
   private String cgurl;
   private String cgprograma;
   private String cgperido;
   private String cgfecha;
   private Long cgid;


}
