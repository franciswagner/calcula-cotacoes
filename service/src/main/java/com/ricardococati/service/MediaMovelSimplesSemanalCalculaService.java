package com.ricardococati.service;

import com.ricardococati.model.dto.MediaMovelSimplesSemanal;
import java.util.List;

public interface MediaMovelSimplesSemanalCalculaService {

	List<MediaMovelSimplesSemanal> executeByCodNeg(final String codigoNegocio);

}
