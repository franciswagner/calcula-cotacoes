package com.ricardococati.service.impl.templates;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;
import com.ricardococati.model.dto.CandlestickDTO;
import java.math.BigDecimal;

public class CandlestickDTOTemplateLoader implements TemplateLoader {

  public static final String CANDLESTICK_DTO_VALID = "CANDLESTICK_DTO_VALID";

  @Override
  public void load() {
    Fixture.of(CandlestickDTO.class)
        .addTemplate(CANDLESTICK_DTO_VALID,
            new Rule() {{
              add("codneg", "MGLU3");
              add("preabe", new BigDecimal(9.1).setScale(4, BigDecimal.ROUND_HALF_UP));
              add("premax", new BigDecimal(12.1).setScale(4, BigDecimal.ROUND_HALF_UP));
              add("premin", new BigDecimal(9.0).setScale(4, BigDecimal.ROUND_HALF_UP));
              add("preult", new BigDecimal(11.1).setScale(4, BigDecimal.ROUND_HALF_UP));
              add("voltot", new BigDecimal(100000.0).setScale(4, BigDecimal.ROUND_HALF_UP));
              add("semana", 1);
              add("mediaMovelGerada", Boolean.TRUE);
              add("mediaExponencialGerada", Boolean.TRUE);
              add("macdGerada", Boolean.FALSE);
              add("sinalMacdGerada", Boolean.TRUE);
              add("histogramaGerada", Boolean.FALSE);
            }});
  }
}