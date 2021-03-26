package com.ricardococati.calculacotacoes.usecases.mediasimples.impl;

import static com.ricardococati.calculacotacoes.utils.geral.BigDecimalCustomizado.sendDoubleGetValueBigDecimalArredonda4Casas;
import static java.util.Objects.nonNull;
import static java.util.stream.Collectors.toList;

import com.ricardococati.calculacotacoes.usecases.mediasimples.CalculaMediaSimples;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
import java.util.OptionalDouble;
import java.util.stream.IntStream;
import org.springframework.stereotype.Component;

@Component
public class CalculaMediaSimplesImpl implements CalculaMediaSimples {

  @Override
  public BigDecimal calcula(
      final int rangeInicio,
      final int rangeLimite,
      final List<BigDecimal> listaValor
  ) {
    BigDecimal resultado = BigDecimal.ZERO;
    final List<BigDecimal> listaTratada = listaTratada(rangeInicio, rangeLimite, listaValor);
    OptionalDouble average =  listaTratada
        .stream()
        .filter(Objects::nonNull)
        .mapToDouble(value -> value.doubleValue())
        .average();
    if (average.isPresent()) {
      resultado = sendDoubleGetValueBigDecimalArredonda4Casas(average.getAsDouble());
    }
    return resultado;
  }

  private List<BigDecimal> listaTratada(
      final int rangeInicio,
      final int rangeLimite,
      final List<BigDecimal> listaValor
  ){
    final boolean isValidList = nonNull(listaValor) && !listaValor.isEmpty();
    return IntStream
        .range(rangeInicio, rangeLimite)
        .filter(Objects::nonNull)
        .filter(value ->  rangeInicio >= 0)
        .filter(value ->  isValidList && rangeInicio <= listaValor.size())
        .filter(value -> isValidList && rangeLimite <= listaValor.size())
        .mapToObj(indice -> listaValor.get(indice))
        .collect(toList());
  }

}
