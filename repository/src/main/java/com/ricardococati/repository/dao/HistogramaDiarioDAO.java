package com.ricardococati.repository.dao;

import com.ricardococati.model.dto.HistogramaDiario;
import java.util.List;

public interface HistogramaDiarioDAO {

  Boolean incluirHistograma(final List<HistogramaDiario> macdList);

}
