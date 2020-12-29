package com.ricardococati.calculacotacoes.usecases.mediasimples;

import com.ricardococati.calculacotacoes.entities.domains.mediasimples.MediaMovelSimplesDiario;
import java.util.List;

public interface MediaMovelSimplesDiarioCalculaService {

	List<MediaMovelSimplesDiario> executeByCodNeg(final String codigoNegocio);

}
