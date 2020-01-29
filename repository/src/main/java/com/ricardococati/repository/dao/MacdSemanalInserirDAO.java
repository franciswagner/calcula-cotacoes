package com.ricardococati.repository.dao;

import com.ricardococati.model.dto.MacdSemanal;
import java.time.LocalDate;
import java.util.List;

public interface MacdSemanalInserirDAO {

  Boolean incluirMacd(final List<MacdSemanal> macdList);

}
