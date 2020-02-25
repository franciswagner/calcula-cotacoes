package com.ricardococati.service.impl.templates;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;
import com.ricardococati.model.dto.CandlestickDTO;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class CandlestickDTOTemplateLoader implements TemplateLoader {

  public static final String CANDLESTICK_DTO_VALID_001 = "CANDLESTICK_DTO_VALID_001";
  public static final String CANDLESTICK_DTO_VALID_002 = "CANDLESTICK_DTO_VALID_002";
  public static final String CANDLESTICK_DTO_VALID_003 = "CANDLESTICK_DTO_VALID_003";
  public static final String CANDLESTICK_DTO_VALID_004 = "CANDLESTICK_DTO_VALID_004";
  public static final String CANDLESTICK_DTO_VALID_005 = "CANDLESTICK_DTO_VALID_005";
  public static final String CANDLESTICK_DTO_VALID_006 = "CANDLESTICK_DTO_VALID_006";
  public static final String CANDLESTICK_DTO_VALID_007 = "CANDLESTICK_DTO_VALID_007";
  public static final String CANDLESTICK_DTO_VALID_008 = "CANDLESTICK_DTO_VALID_008";
  public static final String CANDLESTICK_DTO_VALID_009 = "CANDLESTICK_DTO_VALID_009";
  public static final String CANDLESTICK_DTO_VALID_010 = "CANDLESTICK_DTO_VALID_010";
  public static final String CANDLESTICK_DTO_VALID_011 = "CANDLESTICK_DTO_VALID_011";
  public static final String CANDLESTICK_DTO_VALID_012 = "CANDLESTICK_DTO_VALID_012";
  public static final String CANDLESTICK_DTO_VALID_013 = "CANDLESTICK_DTO_VALID_013";
  public static final String CANDLESTICK_DTO_VALID_014 = "CANDLESTICK_DTO_VALID_014";
  public static final String CANDLESTICK_DTO_VALID_015 = "CANDLESTICK_DTO_VALID_015";
  public static final String CANDLESTICK_DTO_VALID_016 = "CANDLESTICK_DTO_VALID_016";
  public static final String CANDLESTICK_DTO_VALID_017 = "CANDLESTICK_DTO_VALID_017";
  public static final String CANDLESTICK_DTO_VALID_018 = "CANDLESTICK_DTO_VALID_018";
  public static final String CANDLESTICK_DTO_VALID_019 = "CANDLESTICK_DTO_VALID_019";
  public static final String CANDLESTICK_DTO_VALID_020 = "CANDLESTICK_DTO_VALID_020";

  @Override
  public void load() {
    Fixture.of(CandlestickDTO.class)
        .addTemplate(CANDLESTICK_DTO_VALID_001, new Rule() {{
          add("codneg", "MGLU3");
          add("preabe", new BigDecimal(9.1).setScale(4, RoundingMode.HALF_UP));
          add("premax", new BigDecimal(12.1).setScale(4, RoundingMode.HALF_UP));
          add("premin", new BigDecimal(9.0).setScale(4, RoundingMode.HALF_UP));
          add("preult", new BigDecimal(11.1).setScale(4, RoundingMode.HALF_UP));
          add("voltot", new BigDecimal(100000.0).setScale(4, RoundingMode.HALF_UP));
          add("semana", 1);
          add("mediaMovelGerada", Boolean.TRUE);
          add("mediaExponencialGerada", Boolean.TRUE);
          add("macdGerada", Boolean.FALSE);
          add("sinalMacdGerada", Boolean.TRUE);
          add("histogramaGerada", Boolean.FALSE);
        }})
        .addTemplate(CANDLESTICK_DTO_VALID_002, new Rule() {{
          add("codneg", "MGLU3");
          add("preabe", new BigDecimal(2.1).setScale(4, RoundingMode.HALF_UP));
          add("premax", new BigDecimal(13.1).setScale(4, RoundingMode.HALF_UP));
          add("premin", new BigDecimal(9.0).setScale(4, RoundingMode.HALF_UP));
          add("preult", new BigDecimal(11.1).setScale(4, RoundingMode.HALF_UP));
          add("voltot", new BigDecimal(100000.0).setScale(4, RoundingMode.HALF_UP));
          add("semana", 1);
          add("mediaMovelGerada", Boolean.TRUE);
          add("mediaExponencialGerada", Boolean.TRUE);
          add("macdGerada", Boolean.FALSE);
          add("sinalMacdGerada", Boolean.TRUE);
          add("histogramaGerada", Boolean.FALSE);
        }})
        .addTemplate(CANDLESTICK_DTO_VALID_003, new Rule() {{
          add("codneg", "MGLU3");
          add("preabe", new BigDecimal(3.1).setScale(4, RoundingMode.HALF_UP));
          add("premax", new BigDecimal(14.1).setScale(4, RoundingMode.HALF_UP));
          add("premin", new BigDecimal(8.0).setScale(4, RoundingMode.HALF_UP));
          add("preult", new BigDecimal(11.2).setScale(4, RoundingMode.HALF_UP));
          add("voltot", new BigDecimal(200000.0).setScale(4, RoundingMode.HALF_UP));
          add("semana", 1);
          add("mediaMovelGerada", Boolean.TRUE);
          add("mediaExponencialGerada", Boolean.TRUE);
          add("macdGerada", Boolean.FALSE);
          add("sinalMacdGerada", Boolean.TRUE);
          add("histogramaGerada", Boolean.FALSE);
        }})
        .addTemplate(CANDLESTICK_DTO_VALID_004, new Rule() {{
          add("codneg", "MGLU3");
          add("preabe", new BigDecimal(4.1).setScale(4, RoundingMode.HALF_UP));
          add("premax", new BigDecimal(15.1).setScale(4, RoundingMode.HALF_UP));
          add("premin", new BigDecimal(4.0).setScale(4, RoundingMode.HALF_UP));
          add("preult", new BigDecimal(11.3).setScale(4, RoundingMode.HALF_UP));
          add("voltot", new BigDecimal(300000.0).setScale(4, RoundingMode.HALF_UP));
          add("semana", 1);
          add("mediaMovelGerada", Boolean.TRUE);
          add("mediaExponencialGerada", Boolean.TRUE);
          add("macdGerada", Boolean.FALSE);
          add("sinalMacdGerada", Boolean.TRUE);
          add("histogramaGerada", Boolean.FALSE);
        }})
        .addTemplate(CANDLESTICK_DTO_VALID_005, new Rule() {{
          add("codneg", "MGLU3");
          add("preabe", new BigDecimal(6.1).setScale(4, RoundingMode.HALF_UP));
          add("premax", new BigDecimal(16.1).setScale(4, RoundingMode.HALF_UP));
          add("premin", new BigDecimal(5.0).setScale(4, RoundingMode.HALF_UP));
          add("preult", new BigDecimal(11.4).setScale(4, RoundingMode.HALF_UP));
          add("voltot", new BigDecimal(400000.0).setScale(4, RoundingMode.HALF_UP));
          add("semana", 1);
          add("mediaMovelGerada", Boolean.TRUE);
          add("mediaExponencialGerada", Boolean.TRUE);
          add("macdGerada", Boolean.FALSE);
          add("sinalMacdGerada", Boolean.TRUE);
          add("histogramaGerada", Boolean.FALSE);
        }})
        .addTemplate(CANDLESTICK_DTO_VALID_006, new Rule() {{
          add("codneg", "MGLU3");
          add("preabe", new BigDecimal(8.1).setScale(4, RoundingMode.HALF_UP));
          add("premax", new BigDecimal(17.1).setScale(4, RoundingMode.HALF_UP));
          add("premin", new BigDecimal(6.0).setScale(4, RoundingMode.HALF_UP));
          add("preult", new BigDecimal(11.5).setScale(4, RoundingMode.HALF_UP));
          add("voltot", new BigDecimal(500000.0).setScale(4, RoundingMode.HALF_UP));
          add("semana", 1);
          add("mediaMovelGerada", Boolean.TRUE);
          add("mediaExponencialGerada", Boolean.TRUE);
          add("macdGerada", Boolean.FALSE);
          add("sinalMacdGerada", Boolean.TRUE);
          add("histogramaGerada", Boolean.FALSE);
        }})
        .addTemplate(CANDLESTICK_DTO_VALID_007, new Rule() {{
          add("codneg", "MGLU3");
          add("preabe", new BigDecimal(9.1).setScale(4, RoundingMode.HALF_UP));
          add("premax", new BigDecimal(18.1).setScale(4, RoundingMode.HALF_UP));
          add("premin", new BigDecimal(7.0).setScale(4, RoundingMode.HALF_UP));
          add("preult", new BigDecimal(11.6).setScale(4, RoundingMode.HALF_UP));
          add("voltot", new BigDecimal(600000.0).setScale(4, RoundingMode.HALF_UP));
          add("semana", 1);
          add("mediaMovelGerada", Boolean.TRUE);
          add("mediaExponencialGerada", Boolean.TRUE);
          add("macdGerada", Boolean.FALSE);
          add("sinalMacdGerada", Boolean.TRUE);
          add("histogramaGerada", Boolean.FALSE);
        }})
        .addTemplate(CANDLESTICK_DTO_VALID_008, new Rule() {{
          add("codneg", "MGLU3");
          add("preabe", new BigDecimal(11.1).setScale(4, RoundingMode.HALF_UP));
          add("premax", new BigDecimal(19.1).setScale(4, RoundingMode.HALF_UP));
          add("premin", new BigDecimal(8.0).setScale(4, RoundingMode.HALF_UP));
          add("preult", new BigDecimal(11.7).setScale(4, RoundingMode.HALF_UP));
          add("voltot", new BigDecimal(700000.0).setScale(4, RoundingMode.HALF_UP));
          add("semana", 1);
          add("mediaMovelGerada", Boolean.TRUE);
          add("mediaExponencialGerada", Boolean.TRUE);
          add("macdGerada", Boolean.FALSE);
          add("sinalMacdGerada", Boolean.TRUE);
          add("histogramaGerada", Boolean.FALSE);
        }})
        .addTemplate(CANDLESTICK_DTO_VALID_009, new Rule() {{
          add("codneg", "MGLU3");
          add("preabe", new BigDecimal(12.1).setScale(4, RoundingMode.HALF_UP));
          add("premax", new BigDecimal(12.1).setScale(4, RoundingMode.HALF_UP));
          add("premin", new BigDecimal(9.0).setScale(4, RoundingMode.HALF_UP));
          add("preult", new BigDecimal(11.8).setScale(4, RoundingMode.HALF_UP));
          add("voltot", new BigDecimal(800000.0).setScale(4, RoundingMode.HALF_UP));
          add("semana", 1);
          add("mediaMovelGerada", Boolean.TRUE);
          add("mediaExponencialGerada", Boolean.TRUE);
          add("macdGerada", Boolean.FALSE);
          add("sinalMacdGerada", Boolean.TRUE);
          add("histogramaGerada", Boolean.FALSE);
        }})
        .addTemplate(CANDLESTICK_DTO_VALID_010, new Rule() {{
          add("codneg", "MGLU3");
          add("preabe", new BigDecimal(11.1).setScale(4, RoundingMode.HALF_UP));
          add("premax", new BigDecimal(13.1).setScale(4, RoundingMode.HALF_UP));
          add("premin", new BigDecimal(2.0).setScale(4, RoundingMode.HALF_UP));
          add("preult", new BigDecimal(11.9).setScale(4, RoundingMode.HALF_UP));
          add("voltot", new BigDecimal(900000.0).setScale(4, RoundingMode.HALF_UP));
          add("semana", 1);
          add("mediaMovelGerada", Boolean.TRUE);
          add("mediaExponencialGerada", Boolean.TRUE);
          add("macdGerada", Boolean.FALSE);
          add("sinalMacdGerada", Boolean.TRUE);
          add("histogramaGerada", Boolean.FALSE);
        }})
        .addTemplate(CANDLESTICK_DTO_VALID_011, new Rule() {{
          add("codneg", "MGLU3");
          add("preabe", new BigDecimal(10.1).setScale(4, RoundingMode.HALF_UP));
          add("premax", new BigDecimal(14.1).setScale(4, RoundingMode.HALF_UP));
          add("premin", new BigDecimal(3.0).setScale(4, RoundingMode.HALF_UP));
          add("preult", new BigDecimal(11.2).setScale(4, RoundingMode.HALF_UP));
          add("voltot", new BigDecimal(200000.0).setScale(4, RoundingMode.HALF_UP));
          add("semana", 1);
          add("mediaMovelGerada", Boolean.TRUE);
          add("mediaExponencialGerada", Boolean.TRUE);
          add("macdGerada", Boolean.FALSE);
          add("sinalMacdGerada", Boolean.TRUE);
          add("histogramaGerada", Boolean.FALSE);
        }})
        .addTemplate(CANDLESTICK_DTO_VALID_012, new Rule() {{
          add("codneg", "MGLU3");
          add("preabe", new BigDecimal(11.1).setScale(4, RoundingMode.HALF_UP));
          add("premax", new BigDecimal(15.1).setScale(4, RoundingMode.HALF_UP));
          add("premin", new BigDecimal(5.0).setScale(4, RoundingMode.HALF_UP));
          add("preult", new BigDecimal(11.3).setScale(4, RoundingMode.HALF_UP));
          add("voltot", new BigDecimal(300000.0).setScale(4, RoundingMode.HALF_UP));
          add("semana", 1);
          add("mediaMovelGerada", Boolean.TRUE);
          add("mediaExponencialGerada", Boolean.TRUE);
          add("macdGerada", Boolean.FALSE);
          add("sinalMacdGerada", Boolean.TRUE);
          add("histogramaGerada", Boolean.FALSE);
        }})
        .addTemplate(CANDLESTICK_DTO_VALID_013, new Rule() {{
          add("codneg", "MGLU3");
          add("preabe", new BigDecimal(6.1).setScale(4, RoundingMode.HALF_UP));
          add("premax", new BigDecimal(16.1).setScale(4, RoundingMode.HALF_UP));
          add("premin", new BigDecimal(6.0).setScale(4, RoundingMode.HALF_UP));
          add("preult", new BigDecimal(11.4).setScale(4, RoundingMode.HALF_UP));
          add("voltot", new BigDecimal(400000.0).setScale(4, RoundingMode.HALF_UP));
          add("semana", 1);
          add("mediaMovelGerada", Boolean.TRUE);
          add("mediaExponencialGerada", Boolean.TRUE);
          add("macdGerada", Boolean.FALSE);
          add("sinalMacdGerada", Boolean.TRUE);
          add("histogramaGerada", Boolean.FALSE);
        }})
        .addTemplate(CANDLESTICK_DTO_VALID_014, new Rule() {{
          add("codneg", "MGLU3");
          add("preabe", new BigDecimal(11.1).setScale(4, RoundingMode.HALF_UP));
          add("premax", new BigDecimal(17.1).setScale(4, RoundingMode.HALF_UP));
          add("premin", new BigDecimal(8.0).setScale(4, RoundingMode.HALF_UP));
          add("preult", new BigDecimal(11.5).setScale(4, RoundingMode.HALF_UP));
          add("voltot", new BigDecimal(500000.0).setScale(4, RoundingMode.HALF_UP));
          add("semana", 1);
          add("mediaMovelGerada", Boolean.TRUE);
          add("mediaExponencialGerada", Boolean.TRUE);
          add("macdGerada", Boolean.FALSE);
          add("sinalMacdGerada", Boolean.TRUE);
          add("histogramaGerada", Boolean.FALSE);
        }})
        .addTemplate(CANDLESTICK_DTO_VALID_015, new Rule() {{
          add("codneg", "MGLU3");
          add("preabe", new BigDecimal(6.1).setScale(4, RoundingMode.HALF_UP));
          add("premax", new BigDecimal(17.1).setScale(4, RoundingMode.HALF_UP));
          add("premin", new BigDecimal(2.0).setScale(4, RoundingMode.HALF_UP));
          add("preult", new BigDecimal(11.6).setScale(4, RoundingMode.HALF_UP));
          add("voltot", new BigDecimal(600000.0).setScale(4, RoundingMode.HALF_UP));
          add("semana", 1);
          add("mediaMovelGerada", Boolean.TRUE);
          add("mediaExponencialGerada", Boolean.TRUE);
          add("macdGerada", Boolean.FALSE);
          add("sinalMacdGerada", Boolean.TRUE);
          add("histogramaGerada", Boolean.FALSE);
        }})
        .addTemplate(CANDLESTICK_DTO_VALID_016, new Rule() {{
          add("codneg", "MGLU3");
          add("preabe", new BigDecimal(10.1).setScale(4, RoundingMode.HALF_UP));
          add("premax", new BigDecimal(18.1).setScale(4, RoundingMode.HALF_UP));
          add("premin", new BigDecimal(3.0).setScale(4, RoundingMode.HALF_UP));
          add("preult", new BigDecimal(11.7).setScale(4, RoundingMode.HALF_UP));
          add("voltot", new BigDecimal(700000.0).setScale(4, RoundingMode.HALF_UP));
          add("semana", 1);
          add("mediaMovelGerada", Boolean.TRUE);
          add("mediaExponencialGerada", Boolean.TRUE);
          add("macdGerada", Boolean.FALSE);
          add("sinalMacdGerada", Boolean.TRUE);
          add("histogramaGerada", Boolean.FALSE);
        }})
        .addTemplate(CANDLESTICK_DTO_VALID_017, new Rule() {{
          add("codneg", "MGLU3");
          add("preabe", new BigDecimal(10.1).setScale(4, RoundingMode.HALF_UP));
          add("premax", new BigDecimal(19.1).setScale(4, RoundingMode.HALF_UP));
          add("premin", new BigDecimal(4.0).setScale(4, RoundingMode.HALF_UP));
          add("preult", new BigDecimal(11.8).setScale(4, RoundingMode.HALF_UP));
          add("voltot", new BigDecimal(800000.0).setScale(4, RoundingMode.HALF_UP));
          add("semana", 1);
          add("mediaMovelGerada", Boolean.TRUE);
          add("mediaExponencialGerada", Boolean.TRUE);
          add("macdGerada", Boolean.FALSE);
          add("sinalMacdGerada", Boolean.TRUE);
          add("histogramaGerada", Boolean.FALSE);
        }})
        .addTemplate(CANDLESTICK_DTO_VALID_018, new Rule() {{
          add("codneg", "MGLU3");
          add("preabe", new BigDecimal(11.1).setScale(4, RoundingMode.HALF_UP));
          add("premax", new BigDecimal(19.1).setScale(4, RoundingMode.HALF_UP));
          add("premin", new BigDecimal(5.0).setScale(4, RoundingMode.HALF_UP));
          add("preult", new BigDecimal(11.9).setScale(4, RoundingMode.HALF_UP));
          add("voltot", new BigDecimal(900000.0).setScale(4, RoundingMode.HALF_UP));
          add("semana", 1);
          add("mediaMovelGerada", Boolean.TRUE);
          add("mediaExponencialGerada", Boolean.TRUE);
          add("macdGerada", Boolean.FALSE);
          add("sinalMacdGerada", Boolean.TRUE);
          add("histogramaGerada", Boolean.FALSE);
        }})
        .addTemplate(CANDLESTICK_DTO_VALID_019, new Rule() {{
          add("codneg", "MGLU3");
          add("preabe", new BigDecimal(12.1).setScale(4, RoundingMode.HALF_UP));
          add("premax", new BigDecimal(14.1).setScale(4, RoundingMode.HALF_UP));
          add("premin", new BigDecimal(6.0).setScale(4, RoundingMode.HALF_UP));
          add("preult", new BigDecimal(11.2).setScale(4, RoundingMode.HALF_UP));
          add("voltot", new BigDecimal(200000.0).setScale(4, RoundingMode.HALF_UP));
          add("semana", 1);
          add("mediaMovelGerada", Boolean.TRUE);
          add("mediaExponencialGerada", Boolean.TRUE);
          add("macdGerada", Boolean.FALSE);
          add("sinalMacdGerada", Boolean.TRUE);
          add("histogramaGerada", Boolean.FALSE);
        }})
        .addTemplate(CANDLESTICK_DTO_VALID_020, new Rule() {{
          add("codneg", "MGLU3");
          add("preabe", new BigDecimal(13.1).setScale(4, RoundingMode.HALF_UP));
          add("premax", new BigDecimal(15.1).setScale(4, RoundingMode.HALF_UP));
          add("premin", new BigDecimal(7.0).setScale(4, RoundingMode.HALF_UP));
          add("preult", new BigDecimal(11.3).setScale(4, RoundingMode.HALF_UP));
          add("voltot", new BigDecimal(400000.0).setScale(4, RoundingMode.HALF_UP));
          add("semana", 1);
          add("mediaMovelGerada", Boolean.TRUE);
          add("mediaExponencialGerada", Boolean.TRUE);
          add("macdGerada", Boolean.FALSE);
          add("sinalMacdGerada", Boolean.TRUE);
          add("histogramaGerada", Boolean.FALSE);
        }})
    ;
  }
}