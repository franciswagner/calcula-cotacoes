package com.ricardococati.service;

import com.ricardococati.model.entities.MediaMovelSimplesSemanal;
import java.util.List;

public interface MediaMovelSimplesSemanalCalculaService {

	List<MediaMovelSimplesSemanal> executeByCodNeg(final String codigoNegocio);

}
