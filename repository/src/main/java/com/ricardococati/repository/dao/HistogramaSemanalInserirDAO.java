package com.ricardococati.repository.dao;

import com.ricardococati.model.dto.HistogramaSemanal;
import java.util.List;

public interface HistogramaSemanalInserirDAO {

  Boolean incluirHistograma(final HistogramaSemanal histogramaSemanal);

}
