package com.ricardococati.service.impl.templates;

import static com.ricardococati.service.impl.templates.CandlestickDTOTemplateLoader.CANDLESTICK_DTO_VALID;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;
import com.ricardococati.model.dto.CandlestickDTO;
import com.ricardococati.model.dto.CandlestickDiarioDTO;
import java.time.LocalDate;

public class CandlestickDiarioDTOTemplateLoader implements TemplateLoader {

  public static final String CANDLESTICK_DIARIO_DTO_VALID = "CANDLESTICK_DIARIO_DTO_VALID";

  @Override
  public void load() {
    Fixture.of(CandlestickDiarioDTO.class)
        .addTemplate(CANDLESTICK_DIARIO_DTO_VALID,
            new Rule() {{
              add("idCandleDiario", random(Long.class, range(1L, 200L)));
              add("dtpreg", LocalDate.of(1978, 02, 16));
              add("candlestickDTO", one(CandlestickDTO.class, CANDLESTICK_DTO_VALID));
            }});
  }
}