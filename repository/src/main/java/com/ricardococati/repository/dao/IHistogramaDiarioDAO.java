package com.ricardococati.repository.dao;

import com.ricardococati.model.dto.HistogramaDiario;
import java.util.List;

public interface IHistogramaDiarioDAO {

  Boolean incluirHistograma(final List<HistogramaDiario> macdList);

  Boolean deleteAllHistograma();

  List<HistogramaDiario> listHistogramaByCodNeg(final String codneg);

}
