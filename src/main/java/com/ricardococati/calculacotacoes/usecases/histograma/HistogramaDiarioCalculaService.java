package com.ricardococati.calculacotacoes.usecases.histograma;

import com.ricardococati.calculacotacoes.entities.domains.histograma.HistogramaDiario;
import java.util.List;

public interface HistogramaDiarioCalculaService {

  List<HistogramaDiario> executeByCodNeg(String codneg);

}
