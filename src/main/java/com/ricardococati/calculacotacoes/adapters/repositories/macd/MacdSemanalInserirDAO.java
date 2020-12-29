package com.ricardococati.calculacotacoes.adapters.repositories.macd;

import com.ricardococati.calculacotacoes.entities.domains.macd.MacdSemanal;

public interface MacdSemanalInserirDAO {

  Boolean incluirMacd(final MacdSemanal macdSemanal);

}
