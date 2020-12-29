package com.ricardococati.calculacotacoes.usecases.histograma;

import com.ricardococati.calculacotacoes.entities.domains.histograma.HistogramaSemanal;
import java.util.List;

public interface HistogramaSemanalCalculaService {

  List<HistogramaSemanal> executeByCodNeg(String codneg);

}
