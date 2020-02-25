package com.ricardococati.service.impl.templates;

import static com.ricardococati.service.util.BigDecimalCustomizado.getDoubleValueBigDecimalHalfUpArredondado4Casas;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;
import com.ricardococati.model.dto.MediaMovelSimples;
import com.ricardococati.service.util.BigDecimalCustomizado;

public class MediaMovelSimplesTemplateLoader implements TemplateLoader {

  public static final String MEDIA_MOVEL_SIMPLES_VALID_001 = "MEDIA_MOVEL_SIMPLES_VALID_001";
  public static final String MEDIA_MOVEL_SIMPLES_VALID_002 = "MEDIA_MOVEL_SIMPLES_VALID_002";
  public static final String MEDIA_MOVEL_SIMPLES_VALID_003 = "MEDIA_MOVEL_SIMPLES_VALID_003";
  public static final String MEDIA_MOVEL_SIMPLES_VALID_004 = "MEDIA_MOVEL_SIMPLES_VALID_004";
  public static final String MEDIA_MOVEL_SIMPLES_VALID_005 = "MEDIA_MOVEL_SIMPLES_VALID_005";
  public static final String MEDIA_MOVEL_SIMPLES_VALID_006 = "MEDIA_MOVEL_SIMPLES_VALID_006";
  public static final String MEDIA_MOVEL_SIMPLES_VALID_007 = "MEDIA_MOVEL_SIMPLES_VALID_007";
  public static final String MEDIA_MOVEL_SIMPLES_VALID_008 = "MEDIA_MOVEL_SIMPLES_VALID_008";
  public static final String MEDIA_MOVEL_SIMPLES_VALID_009 = "MEDIA_MOVEL_SIMPLES_VALID_009";
  public static final String MEDIA_MOVEL_SIMPLES_VALID_010 = "MEDIA_MOVEL_SIMPLES_VALID_010";
  public static final String MEDIA_MOVEL_SIMPLES_VALID_011 = "MEDIA_MOVEL_SIMPLES_VALID_011";

  @Override
  public void load() {
    Fixture.of(MediaMovelSimples.class)
        .addTemplate(MEDIA_MOVEL_SIMPLES_VALID_001,
            new Rule() {{
              add("codneg", "MGLU3");
              add("premedult", BigDecimalCustomizado
                  .getDoubleValueBigDecimalHalfUpArredondado4Casas(11.11));
              add("periodo", 9);
            }})
        .addTemplate(MEDIA_MOVEL_SIMPLES_VALID_002).inherits(MEDIA_MOVEL_SIMPLES_VALID_001,
        new Rule() {{
          add("premedult", BigDecimalCustomizado.getDoubleValueBigDecimalHalfUpArredondado4Casas(10.9));
        }})
        .addTemplate(MEDIA_MOVEL_SIMPLES_VALID_003).inherits(MEDIA_MOVEL_SIMPLES_VALID_001,
        new Rule() {{
          add("premedult", BigDecimalCustomizado.getDoubleValueBigDecimalHalfUpArredondado4Casas(10.23));
        }})
        .addTemplate(MEDIA_MOVEL_SIMPLES_VALID_004).inherits(MEDIA_MOVEL_SIMPLES_VALID_001,
        new Rule() {{
          add("premedult", BigDecimalCustomizado.getDoubleValueBigDecimalHalfUpArredondado4Casas(10.32));
        }})
        .addTemplate(MEDIA_MOVEL_SIMPLES_VALID_005).inherits(MEDIA_MOVEL_SIMPLES_VALID_001,
        new Rule() {{
          add("premedult", BigDecimalCustomizado.getDoubleValueBigDecimalHalfUpArredondado4Casas(10.54));
        }})
        .addTemplate(MEDIA_MOVEL_SIMPLES_VALID_006).inherits(MEDIA_MOVEL_SIMPLES_VALID_001,
        new Rule() {{
          add("premedult", BigDecimalCustomizado.getDoubleValueBigDecimalHalfUpArredondado4Casas(11.2));
        }})
        .addTemplate(MEDIA_MOVEL_SIMPLES_VALID_007).inherits(MEDIA_MOVEL_SIMPLES_VALID_001,
        new Rule() {{
          add("premedult", BigDecimalCustomizado.getDoubleValueBigDecimalHalfUpArredondado4Casas(11.3));
        }})
        .addTemplate(MEDIA_MOVEL_SIMPLES_VALID_007).inherits(MEDIA_MOVEL_SIMPLES_VALID_001,
        new Rule() {{
          add("premedult", BigDecimalCustomizado.getDoubleValueBigDecimalHalfUpArredondado4Casas(11.1));
        }})
        .addTemplate(MEDIA_MOVEL_SIMPLES_VALID_008).inherits(MEDIA_MOVEL_SIMPLES_VALID_001,
        new Rule() {{
          add("premedult", BigDecimalCustomizado.getDoubleValueBigDecimalHalfUpArredondado4Casas(10.4));
        }})
        .addTemplate(MEDIA_MOVEL_SIMPLES_VALID_009).inherits(MEDIA_MOVEL_SIMPLES_VALID_001,
        new Rule() {{
          add("premedult", BigDecimalCustomizado.getDoubleValueBigDecimalHalfUpArredondado4Casas(10.37));
        }})
        .addTemplate(MEDIA_MOVEL_SIMPLES_VALID_010).inherits(MEDIA_MOVEL_SIMPLES_VALID_001,
        new Rule() {{
          add("premedult", BigDecimalCustomizado.getDoubleValueBigDecimalHalfUpArredondado4Casas(10.56));
        }})
        .addTemplate(MEDIA_MOVEL_SIMPLES_VALID_011).inherits(MEDIA_MOVEL_SIMPLES_VALID_001,
        new Rule() {{
          add("premedult", BigDecimalCustomizado.getDoubleValueBigDecimalHalfUpArredondado4Casas(10.76));
        }});
  }
}