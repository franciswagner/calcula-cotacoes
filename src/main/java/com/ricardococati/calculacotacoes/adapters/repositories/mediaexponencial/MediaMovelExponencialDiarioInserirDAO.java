package com.ricardococati.calculacotacoes.adapters.repositories.mediaexponencial;

import com.ricardococati.calculacotacoes.entities.domains.mediaexponencial.MediaMovelExponencialDiario;

public interface MediaMovelExponencialDiarioInserirDAO {

  Boolean incluirMediaMovelExponencial(
      final MediaMovelExponencialDiario mmeDiario);

}
