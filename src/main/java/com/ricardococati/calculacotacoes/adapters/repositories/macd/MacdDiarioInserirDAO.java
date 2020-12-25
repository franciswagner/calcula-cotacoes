package com.ricardococati.calculacotacoes.adapters.repositories.macd;

import com.ricardococati.calculacotacoes.entities.domains.macd.MacdDiario;

public interface MacdDiarioInserirDAO {

  Boolean incluirMacd(final MacdDiario macdDiario);

}
