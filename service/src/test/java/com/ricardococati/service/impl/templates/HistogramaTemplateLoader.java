package com.ricardococati.service.impl.templates;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;
import com.ricardococati.model.entities.Histograma;
import com.ricardococati.service.util.BigDecimalCustomizado;

public class HistogramaTemplateLoader implements TemplateLoader {

  public static final String HISTOGRAMA_VALID_001 = "HISTOGRAMA_VALID_001";
  public static final String HISTOGRAMA_VALID_002 = "HISTOGRAMA_VALID_002";
  public static final String HISTOGRAMA_VALID_003 = "HISTOGRAMA_VALID_003";
  public static final String HISTOGRAMA_VALID_004 = "HISTOGRAMA_VALID_004";
  public static final String HISTOGRAMA_VALID_005 = "HISTOGRAMA_VALID_005";
  public static final String HISTOGRAMA_VALID_006 = "HISTOGRAMA_VALID_006";
  public static final String HISTOGRAMA_VALID_007 = "HISTOGRAMA_VALID_007";
  public static final String HISTOGRAMA_VALID_008 = "HISTOGRAMA_VALID_008";
  public static final String HISTOGRAMA_VALID_009 = "HISTOGRAMA_VALID_009";
  public static final String HISTOGRAMA_VALID_010 = "HISTOGRAMA_VALID_010";
  public static final String HISTOGRAMA_VALID_011 = "HISTOGRAMA_VALID_011";

  @Override
  public void load() {
    Fixture.of(Histograma.class)
        .addTemplate(HISTOGRAMA_VALID_001,
            new Rule() {{
              add("codneg", "MGLU3");
              add("prehist", BigDecimalCustomizado.getDoubleValueBigDecimalHalfUpArredondado4Casas(11.11));
            }})
        .addTemplate(HISTOGRAMA_VALID_002).inherits(HISTOGRAMA_VALID_001,
        new Rule() {{
          add("prehist", BigDecimalCustomizado.getDoubleValueBigDecimalHalfUpArredondado4Casas(10.9));
        }})
        .addTemplate(HISTOGRAMA_VALID_003).inherits(HISTOGRAMA_VALID_001,
        new Rule() {{
          add("prehist", BigDecimalCustomizado.getDoubleValueBigDecimalHalfUpArredondado4Casas(10.23));
        }})
        .addTemplate(HISTOGRAMA_VALID_004).inherits(HISTOGRAMA_VALID_001,
        new Rule() {{
          add("prehist", BigDecimalCustomizado.getDoubleValueBigDecimalHalfUpArredondado4Casas(10.32));
        }})
        .addTemplate(HISTOGRAMA_VALID_005).inherits(HISTOGRAMA_VALID_001,
        new Rule() {{
          add("prehist", BigDecimalCustomizado.getDoubleValueBigDecimalHalfUpArredondado4Casas(10.54));
        }})
        .addTemplate(HISTOGRAMA_VALID_006).inherits(HISTOGRAMA_VALID_001,
        new Rule() {{
          add("prehist", BigDecimalCustomizado.getDoubleValueBigDecimalHalfUpArredondado4Casas(11.2));
        }})
        .addTemplate(HISTOGRAMA_VALID_007).inherits(HISTOGRAMA_VALID_001,
        new Rule() {{
          add("prehist", BigDecimalCustomizado.getDoubleValueBigDecimalHalfUpArredondado4Casas(11.3));
        }})
        .addTemplate(HISTOGRAMA_VALID_007).inherits(HISTOGRAMA_VALID_001,
        new Rule() {{
          add("prehist", BigDecimalCustomizado.getDoubleValueBigDecimalHalfUpArredondado4Casas(11.1));
        }})
        .addTemplate(HISTOGRAMA_VALID_008).inherits(HISTOGRAMA_VALID_001,
        new Rule() {{
          add("prehist", BigDecimalCustomizado.getDoubleValueBigDecimalHalfUpArredondado4Casas(10.4));
        }})
        .addTemplate(HISTOGRAMA_VALID_009).inherits(HISTOGRAMA_VALID_001,
        new Rule() {{
          add("prehist", BigDecimalCustomizado.getDoubleValueBigDecimalHalfUpArredondado4Casas(10.37));
        }})
        .addTemplate(HISTOGRAMA_VALID_010).inherits(HISTOGRAMA_VALID_001,
        new Rule() {{
          add("prehist", BigDecimalCustomizado.getDoubleValueBigDecimalHalfUpArredondado4Casas(10.56));
        }})
        .addTemplate(HISTOGRAMA_VALID_011).inherits(HISTOGRAMA_VALID_001,
        new Rule() {{
          add("prehist", BigDecimalCustomizado.getDoubleValueBigDecimalHalfUpArredondado4Casas(10.76));
        }});
  }
}