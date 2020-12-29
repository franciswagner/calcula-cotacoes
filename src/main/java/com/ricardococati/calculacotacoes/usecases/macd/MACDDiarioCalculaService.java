package com.ricardococati.calculacotacoes.usecases.macd;

import com.ricardococati.calculacotacoes.entities.domains.macd.MacdDiario;
import java.util.List;

public interface MACDDiarioCalculaService {

	List<MacdDiario> executeByCodNeg(final String codigoNegocio);

}
