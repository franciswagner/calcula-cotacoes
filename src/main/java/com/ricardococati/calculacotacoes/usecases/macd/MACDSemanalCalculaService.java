package com.ricardococati.calculacotacoes.usecases.macd;

import com.ricardococati.calculacotacoes.entities.domains.macd.MacdSemanal;
import java.util.List;

public interface MACDSemanalCalculaService {

	List<MacdSemanal> executeByCodNeg(final String codigoNegocio);

}
