package com.ricardococati.repository.dao;

import com.ricardococati.model.dto.MacdDiario;
import java.time.LocalDate;
import java.util.List;

public interface MacdDiarioInserirDAO {

  Boolean incluirMacd(final MacdDiario macdDiario);

}
