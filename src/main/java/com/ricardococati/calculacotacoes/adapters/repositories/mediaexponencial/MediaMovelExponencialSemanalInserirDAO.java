package com.ricardococati.calculacotacoes.adapters.repositories.mediaexponencial;

import com.ricardococati.calculacotacoes.entities.domains.mediaexponencial.MediaMovelExponencialSemanal;

public interface MediaMovelExponencialSemanalInserirDAO {

  Boolean incluirMediaMovelExponencial(
      final MediaMovelExponencialSemanal mmeSemanal
  );

}