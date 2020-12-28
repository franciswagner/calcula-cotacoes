package com.ricardococati.calculacotacoes.usecases.mediasimples;

import com.ricardococati.calculacotacoes.entities.domains.mediasimples.MediaMovelSimplesSemanal;
import java.util.List;

public interface MediaMovelSimplesSemanalCalculaService {

	List<MediaMovelSimplesSemanal> executeByCodNeg(final String codigoNegocio);

}
