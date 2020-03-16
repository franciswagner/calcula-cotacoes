package com.ricardococati.repository.dao;

import com.ricardococati.model.entities.MediaMovelExponencialSemanal;

public interface MediaMovelExponencialSemanalInserirDAO {

  Boolean incluirMediaMovelExponencial(
      final MediaMovelExponencialSemanal mmeSemanal
  );

}