package com.ricardococati.calculacotacoes.utils.converters;

import com.ricardococati.calculacotacoes.entities.domains.split.SplitInplit;
import com.ricardococati.calculacotacoes.entities.enums.OperacaoSplitInplit;
import java.time.LocalDate;
import org.springframework.stereotype.Component;

@Component
public class SplitInplitConverter {

  public SplitInplit convert(
      final LocalDate dtPregao,
      final String codneg,
      final Integer qtdSplitInplit,
      final String operacao) {
    return SplitInplit
        .builder()
        .codneg(codneg)
        .dtpreg(dtPregao)
        .qtdSplitInplit(qtdSplitInplit)
        .operacao(OperacaoSplitInplit.valueOf(operacao.toUpperCase()))
        .build();
  }

}
