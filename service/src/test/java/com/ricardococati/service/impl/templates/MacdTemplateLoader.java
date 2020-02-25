package com.ricardococati.service.impl.templates;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;
import com.ricardococati.model.dto.Macd;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class MacdTemplateLoader implements TemplateLoader {

  public static final String MACD_VALID_001 = "MACD_VALID_001";
  public static final String MACD_VALID_002 = "MACD_VALID_002";
  public static final String MACD_VALID_003 = "MACD_VALID_003";
  public static final String MACD_VALID_004 = "MACD_VALID_004";
  public static final String MACD_VALID_005 = "MACD_VALID_005";
  public static final String MACD_VALID_006 = "MACD_VALID_006";
  public static final String MACD_VALID_007 = "MACD_VALID_007";
  public static final String MACD_VALID_008 = "MACD_VALID_008";
  public static final String MACD_VALID_009 = "MACD_VALID_009";
  public static final String MACD_VALID_010 = "MACD_VALID_010";
  public static final String MACD_VALID_011 = "MACD_VALID_011";

  @Override
  public void load() {
    Fixture.of(Macd.class)
        .addTemplate(MACD_VALID_001,
            new Rule() {{
              add("codneg", "MGLU3");
              add("premacd", new BigDecimal(11.11).setScale(4, RoundingMode.HALF_UP));
            }})
        .addTemplate(MACD_VALID_002).inherits(MACD_VALID_001,
        new Rule() {{
          add("premacd", new BigDecimal(10.9).setScale(4, RoundingMode.HALF_UP));
        }})
        .addTemplate(MACD_VALID_003).inherits(MACD_VALID_001,
        new Rule() {{
          add("premacd", new BigDecimal(10.23).setScale(4, RoundingMode.HALF_UP));
        }})
        .addTemplate(MACD_VALID_004).inherits(MACD_VALID_001,
        new Rule() {{
          add("premacd", new BigDecimal(10.32).setScale(4, RoundingMode.HALF_UP));
        }})
        .addTemplate(MACD_VALID_005).inherits(MACD_VALID_001,
        new Rule() {{
          add("premacd", new BigDecimal(10.54).setScale(4, RoundingMode.HALF_UP));
        }})
        .addTemplate(MACD_VALID_006).inherits(MACD_VALID_001,
        new Rule() {{
          add("premacd", new BigDecimal(11.2).setScale(4, RoundingMode.HALF_UP));
        }})
        .addTemplate(MACD_VALID_007).inherits(MACD_VALID_001,
        new Rule() {{
          add("premacd", new BigDecimal(11.3).setScale(4, RoundingMode.HALF_UP));
        }})
        .addTemplate(MACD_VALID_007).inherits(MACD_VALID_001,
        new Rule() {{
          add("premacd", new BigDecimal(11.1).setScale(4, RoundingMode.HALF_UP));
        }})
        .addTemplate(MACD_VALID_008).inherits(MACD_VALID_001,
        new Rule() {{
          add("premacd", new BigDecimal(10.4).setScale(4, RoundingMode.HALF_UP));
        }})
        .addTemplate(MACD_VALID_009).inherits(MACD_VALID_001,
        new Rule() {{
          add("premacd", new BigDecimal(10.37).setScale(4, RoundingMode.HALF_UP));
        }})
        .addTemplate(MACD_VALID_010).inherits(MACD_VALID_001,
        new Rule() {{
          add("premacd", new BigDecimal(10.56).setScale(4, RoundingMode.HALF_UP));
        }})
        .addTemplate(MACD_VALID_011).inherits(MACD_VALID_001,
        new Rule() {{
          add("premacd", new BigDecimal(10.76).setScale(4, RoundingMode.HALF_UP));
        }});
  }
}