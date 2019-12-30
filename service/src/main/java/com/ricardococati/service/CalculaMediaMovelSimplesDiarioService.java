package com.ricardococati.service;

import com.ricardococati.model.dto.MediaMovelSimplesDiario;
import java.util.List;

public interface CalculaMediaMovelSimplesDiarioService {

	List<MediaMovelSimplesDiario> executeByCodNeg(final String codigoNegocio);

}
