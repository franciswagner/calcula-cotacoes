package com.ricardococati.calculacotacoes.adapters.repositories.sinalmacd;

import com.ricardococati.calculacotacoes.entities.domains.sinalmacd.SinalMacdDiario;

public interface SinalMacdDiarioInserirDAO {

  Boolean incluirSinalMacd(final SinalMacdDiario sinalMacdDiario);

}
