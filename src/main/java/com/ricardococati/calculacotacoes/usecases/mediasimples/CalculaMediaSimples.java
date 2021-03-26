package com.ricardococati.calculacotacoes.usecases.mediasimples;

import java.math.BigDecimal;
import java.util.List;

public interface CalculaMediaSimples {

  BigDecimal calcula(
      final int periodo,
      final int posicao,
      final List<BigDecimal> listaValor
  );

}
