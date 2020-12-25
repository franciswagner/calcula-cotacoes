package com.ricardococati.calculacotacoes.adapters.repositories.mediasimples;

import com.ricardococati.calculacotacoes.entities.domains.mediasimples.MediaMovelSimplesDiario;

public interface MediaMovelSimplesDiarioInserirDAO {

  Boolean incluirMediaMovelSimples(
      final MediaMovelSimplesDiario mmsDiario
  );

}
