package com.ricardococati.repository.dao;

import com.ricardococati.model.dto.HistogramaSemanal;
import java.util.List;

public interface IHistogramaSemanalDAO {

  Boolean incluirHistograma(final List<HistogramaSemanal> macdList);

  Boolean deleteAllHistograma();

  List<HistogramaSemanal> listHistogramaByCodNeg(final String codneg);

}
