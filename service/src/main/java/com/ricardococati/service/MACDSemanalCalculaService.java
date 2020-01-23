package com.ricardococati.service;

import com.ricardococati.model.dto.MacdSemanal;
import java.util.List;

public interface MACDSemanalCalculaService {

	List<MacdSemanal> executeByCodNeg(final String codigoNegocio);

}
