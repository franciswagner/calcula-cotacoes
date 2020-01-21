package com.ricardococati.service;

import com.ricardococati.model.dto.MacdDiario;
import java.util.List;

public interface MACDDiarioCalculaService {

	List<MacdDiario> executeByCodNeg(final String codigoNegocio);

}
