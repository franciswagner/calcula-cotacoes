package com.ricardococati.calculacotacoes.adapters.repositories.histograma;

import com.ricardococati.calculacotacoes.entities.domains.histograma.HistogramaSemanal;

public interface HistogramaSemanalInserirDAO {

  Boolean incluirHistograma(final HistogramaSemanal histogramaSemanal);

}
