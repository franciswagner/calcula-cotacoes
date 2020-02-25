package com.ricardococati.service.impl.templates;

import static com.ricardococati.service.util.BigDecimalCustomizado.getDoubleValueBigDecimalHalfUpArredondado4Casas;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;
import com.ricardococati.model.dto.SinalMacd;
import com.ricardococati.service.util.BigDecimalCustomizado;

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
              add("presinal", BigDecimalCustomizado.getDoubleValueBigDecimalHalfUpArredondado4Casas(12.11));
            }})
        .addTemplate(SINAL_MACD_VALID_002).inherits(SINAL_MACD_VALID_001,
        new Rule() {{
          add("presinal", BigDecimalCustomizado.getDoubleValueBigDecimalHalfUpArredondado4Casas(9.9));
        }})
        .addTemplate(SINAL_MACD_VALID_003).inherits(SINAL_MACD_VALID_001,
        new Rule() {{
          add("presinal", BigDecimalCustomizado.getDoubleValueBigDecimalHalfUpArredondado4Casas(9.23));
        }})
        .addTemplate(SINAL_MACD_VALID_004).inherits(SINAL_MACD_VALID_001,
        new Rule() {{
          add("presinal", BigDecimalCustomizado.getDoubleValueBigDecimalHalfUpArredondado4Casas(9.32));
        }})
        .addTemplate(SINAL_MACD_VALID_005).inherits(SINAL_MACD_VALID_001,
        new Rule() {{
          add("presinal", BigDecimalCustomizado.getDoubleValueBigDecimalHalfUpArredondado4Casas(9.54));
        }})
        .addTemplate(SINAL_MACD_VALID_006).inherits(SINAL_MACD_VALID_001,
        new Rule() {{
          add("presinal", BigDecimalCustomizado.getDoubleValueBigDecimalHalfUpArredondado4Casas(12.2));
        }})
        .addTemplate(SINAL_MACD_VALID_007).inherits(SINAL_MACD_VALID_001,
        new Rule() {{
          add("presinal", BigDecimalCustomizado.getDoubleValueBigDecimalHalfUpArredondado4Casas(12.3));
        }})
        .addTemplate(SINAL_MACD_VALID_007).inherits(SINAL_MACD_VALID_001,
        new Rule() {{
          add("presinal", BigDecimalCustomizado.getDoubleValueBigDecimalHalfUpArredondado4Casas(12.1));
        }})
        .addTemplate(SINAL_MACD_VALID_008).inherits(SINAL_MACD_VALID_001,
        new Rule() {{
          add("presinal", BigDecimalCustomizado.getDoubleValueBigDecimalHalfUpArredondado4Casas(9.4));
        }})
        .addTemplate(SINAL_MACD_VALID_009).inherits(SINAL_MACD_VALID_001,
        new Rule() {{
          add("presinal", BigDecimalCustomizado.getDoubleValueBigDecimalHalfUpArredondado4Casas(9.37));
        }})
        .addTemplate(SINAL_MACD_VALID_010).inherits(SINAL_MACD_VALID_001,
        new Rule() {{
          add("presinal", BigDecimalCustomizado.getDoubleValueBigDecimalHalfUpArredondado4Casas(9.56));
        }})
        .addTemplate(SINAL_MACD_VALID_011).inherits(SINAL_MACD_VALID_001,
        new Rule() {{
          add("presinal", BigDecimalCustomizado.getDoubleValueBigDecimalHalfUpArredondado4Casas(9.76));
        }});
  }
}