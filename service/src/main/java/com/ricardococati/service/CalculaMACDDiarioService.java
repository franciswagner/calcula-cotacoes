package com.ricardococati.service;

import com.ricardococati.model.dto.MacdDiario;
import java.util.List;

public interface CalculaMACDDiarioService {

	List<MacdDiario> executeByCodNeg(final String codigoNegocio);

}
