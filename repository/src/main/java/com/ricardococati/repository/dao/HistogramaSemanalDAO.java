package com.ricardococati.repository.dao;

import com.ricardococati.model.dto.HistogramaSemanal;
import java.util.List;

public interface HistogramaSemanalDAO {

  Boolean incluirHistograma(final List<HistogramaSemanal> macdList);

}
