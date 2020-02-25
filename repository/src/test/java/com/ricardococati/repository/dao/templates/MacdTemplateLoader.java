package com.ricardococati.repository.dao.templates;

import static com.ricardococati.repository.util.BigDecimalCustomizado.getValueBigDecimalHalfUpArredondado4Casas;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;
import com.ricardococati.model.dto.Macd;

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
              add("premacd", getValueBigDecimalHalfUpArredondado4Casas(11.11));
            }})
        .addTemplate(MACD_VALID_002).inherits(MACD_VALID_001,
        new Rule() {{
          add("premacd", getValueBigDecimalHalfUpArredondado4Casas(10.9));
        }})
        .addTemplate(MACD_VALID_003).inherits(MACD_VALID_001,
        new Rule() {{
          add("premacd", getValueBigDecimalHalfUpArredondado4Casas(10.23));
        }})
        .addTemplate(MACD_VALID_004).inherits(MACD_VALID_001,
        new Rule() {{
          add("premacd", getValueBigDecimalHalfUpArredondado4Casas(10.32));
        }})
        .addTemplate(MACD_VALID_005).inherits(MACD_VALID_001,
        new Rule() {{
          add("premacd", getValueBigDecimalHalfUpArredondado4Casas(10.54));
        }})
        .addTemplate(MACD_VALID_006).inherits(MACD_VALID_001,
        new Rule() {{
          add("premacd", getValueBigDecimalHalfUpArredondado4Casas(11.2));
        }})
        .addTemplate(MACD_VALID_007).inherits(MACD_VALID_001,
        new Rule() {{
          add("premacd", getValueBigDecimalHalfUpArredondado4Casas(11.3));
        }})
        .addTemplate(MACD_VALID_007).inherits(MACD_VALID_001,
        new Rule() {{
          add("premacd", getValueBigDecimalHalfUpArredondado4Casas(11.1));
        }})
        .addTemplate(MACD_VALID_008).inherits(MACD_VALID_001,
        new Rule() {{
          add("premacd", getValueBigDecimalHalfUpArredondado4Casas(10.4));
        }})
        .addTemplate(MACD_VALID_009).inherits(MACD_VALID_001,
        new Rule() {{
          add("premacd", getValueBigDecimalHalfUpArredondado4Casas(10.37));
        }})
        .addTemplate(MACD_VALID_010).inherits(MACD_VALID_001,
        new Rule() {{
          add("premacd", getValueBigDecimalHalfUpArredondado4Casas(10.56));
        }})
        .addTemplate(MACD_VALID_011).inherits(MACD_VALID_001,
        new Rule() {{
          add("premacd", getValueBigDecimalHalfUpArredondado4Casas(10.76));
        }});
  }
}