package com.ricardococati.service.impl.templates;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;
import com.ricardococati.model.dto.SinalMacd;
import java.math.BigDecimal;

public class SinalMacdTemplateLoader implements TemplateLoader {

  public static final String SINAL_MACD_VALID_001 = "SINAL_MACD_VALID_001";
  public static final String SINAL_MACD_VALID_002 = "SINAL_MACD_VALID_002";
  public static final String SINAL_MACD_VALID_003 = "SINAL_MACD_VALID_003";
  public static final String SINAL_MACD_VALID_004 = "SINAL_MACD_VALID_004";
  public static final String SINAL_MACD_VALID_005 = "SINAL_MACD_VALID_005";
  public static final String SINAL_MACD_VALID_006 = "SINAL_MACD_VALID_006";
  public static final String SINAL_MACD_VALID_007 = "SINAL_MACD_VALID_007";
  public static final String SINAL_MACD_VALID_008 = "SINAL_MACD_VALID_008";
  public static final String SINAL_MACD_VALID_009 = "SINAL_MACD_VALID_009";
  public static final String SINAL_MACD_VALID_010 = "SINAL_MACD_VALID_010";
  public static final String SINAL_MACD_VALID_011 = "SINAL_MACD_VALID_011";

  @Override
  public void load() {
    Fixture.of(SinalMacd.class)
        .addTemplate(SINAL_MACD_VALID_001,
            new Rule() {{
              add("codneg", "MGLU3");
              add("presinal", new BigDecimal(11.11).setScale(4, BigDecimal.ROUND_HALF_UP));
            }})
        .addTemplate(SINAL_MACD_VALID_002).inherits(SINAL_MACD_VALID_001,
        new Rule() {{
          add("presinal", new BigDecimal(10.9).setScale(4, BigDecimal.ROUND_HALF_UP));
        }})
        .addTemplate(SINAL_MACD_VALID_003).inherits(SINAL_MACD_VALID_001,
        new Rule() {{
          add("presinal", new BigDecimal(10.23).setScale(4, BigDecimal.ROUND_HALF_UP));
        }})
        .addTemplate(SINAL_MACD_VALID_004).inherits(SINAL_MACD_VALID_001,
        new Rule() {{
          add("presinal", new BigDecimal(10.32).setScale(4, BigDecimal.ROUND_HALF_UP));
        }})
        .addTemplate(SINAL_MACD_VALID_005).inherits(SINAL_MACD_VALID_001,
        new Rule() {{
          add("presinal", new BigDecimal(10.54).setScale(4, BigDecimal.ROUND_HALF_UP));
        }})
        .addTemplate(SINAL_MACD_VALID_006).inherits(SINAL_MACD_VALID_001,
        new Rule() {{
          add("presinal", new BigDecimal(11.2).setScale(4, BigDecimal.ROUND_HALF_UP));
        }})
        .addTemplate(SINAL_MACD_VALID_007).inherits(SINAL_MACD_VALID_001,
        new Rule() {{
          add("presinal", new BigDecimal(11.3).setScale(4, BigDecimal.ROUND_HALF_UP));
        }})
        .addTemplate(SINAL_MACD_VALID_007).inherits(SINAL_MACD_VALID_001,
        new Rule() {{
          add("presinal", new BigDecimal(11.1).setScale(4, BigDecimal.ROUND_HALF_UP));
        }})
        .addTemplate(SINAL_MACD_VALID_008).inherits(SINAL_MACD_VALID_001,
        new Rule() {{
          add("presinal", new BigDecimal(10.4).setScale(4, BigDecimal.ROUND_HALF_UP));
        }})
        .addTemplate(SINAL_MACD_VALID_009).inherits(SINAL_MACD_VALID_001,
        new Rule() {{
          add("presinal", new BigDecimal(10.37).setScale(4, BigDecimal.ROUND_HALF_UP));
        }})
        .addTemplate(SINAL_MACD_VALID_010).inherits(SINAL_MACD_VALID_001,
        new Rule() {{
          add("presinal", new BigDecimal(10.56).setScale(4, BigDecimal.ROUND_HALF_UP));
        }})
        .addTemplate(SINAL_MACD_VALID_011).inherits(SINAL_MACD_VALID_001,
        new Rule() {{
          add("presinal", new BigDecimal(10.76).setScale(4, BigDecimal.ROUND_HALF_UP));
        }});
  }
}