package com.ricardococati.repository.dao;

import com.ricardococati.model.dto.MediaMovelExponencialSemanal;

public interface MediaMovelExponencialSemanalInserirDAO {

  Boolean incluirMediaMovelExponencial(
      final MediaMovelExponencialSemanal mmeSemanal
  );

}