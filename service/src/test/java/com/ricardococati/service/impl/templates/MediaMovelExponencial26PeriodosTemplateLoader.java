package com.ricardococati.service.impl.templates;

import static com.ricardococati.service.util.BigDecimalCustomizado.getDoubleValueBigDecimalHalfUpArredondado4Casas;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;
import com.ricardococati.model.dto.MediaMovelExponencial;
import com.ricardococati.service.util.BigDecimalCustomizado;

public class MediaMovelExponencial26PeriodosTemplateLoader implements TemplateLoader {

  public static final String MEDIA_MOVEL_EXPONENCIAL_26PERIODOS_VALID_001 = "MEDIA_MOVEL_EXPONENCIAL_26PERIODOS_VALID_001";
  public static final String MEDIA_MOVEL_EXPONENCIAL_26PERIODOS_VALID_002 = "MEDIA_MOVEL_EXPONENCIAL_26PERIODOS_VALID_002";
  public static final String MEDIA_MOVEL_EXPONENCIAL_26PERIODOS_VALID_003 = "MEDIA_MOVEL_EXPONENCIAL_26PERIODOS_VALID_003";
  public static final String MEDIA_MOVEL_EXPONENCIAL_26PERIODOS_VALID_004 = "MEDIA_MOVEL_EXPONENCIAL_26PERIODOS_VALID_004";
  public static final String MEDIA_MOVEL_EXPONENCIAL_26PERIODOS_VALID_005 = "MEDIA_MOVEL_EXPONENCIAL_26PERIODOS_VALID_005";
  public static final String MEDIA_MOVEL_EXPONENCIAL_26PERIODOS_VALID_006 = "MEDIA_MOVEL_EXPONENCIAL_26PERIODOS_VALID_006";
  public static final String MEDIA_MOVEL_EXPONENCIAL_26PERIODOS_VALID_007 = "MEDIA_MOVEL_EXPONENCIAL_26PERIODOS_VALID_007";
  public static final String MEDIA_MOVEL_EXPONENCIAL_26PERIODOS_VALID_008 = "MEDIA_MOVEL_EXPONENCIAL_26PERIODOS_VALID_008";
  public static final String MEDIA_MOVEL_EXPONENCIAL_26PERIODOS_VALID_009 = "MEDIA_MOVEL_EXPONENCIAL_26PERIODOS_VALID_009";
  public static final String MEDIA_MOVEL_EXPONENCIAL_26PERIODOS_VALID_010 = "MEDIA_MOVEL_EXPONENCIAL_26PERIODOS_VALID_010";
  public static final String MEDIA_MOVEL_EXPONENCIAL_26PERIODOS_VALID_011 = "MEDIA_MOVEL_EXPONENCIAL_26PERIODOS_VALID_011";
  public static final String MEDIA_MOVEL_EXPONENCIAL_26PERIODOS_VALID_012 = "MEDIA_MOVEL_EXPONENCIAL_26PERIODOS_VALID_012";
  public static final String MEDIA_MOVEL_EXPONENCIAL_26PERIODOS_VALID_013 = "MEDIA_MOVEL_EXPONENCIAL_26PERIODOS_VALID_013";
  public static final String MEDIA_MOVEL_EXPONENCIAL_26PERIODOS_VALID_014 = "MEDIA_MOVEL_EXPONENCIAL_26PERIODOS_VALID_014";
  public static final String MEDIA_MOVEL_EXPONENCIAL_26PERIODOS_VALID_015 = "MEDIA_MOVEL_EXPONENCIAL_26PERIODOS_VALID_015";
  public static final String MEDIA_MOVEL_EXPONENCIAL_26PERIODOS_VALID_016 = "MEDIA_MOVEL_EXPONENCIAL_26PERIODOS_VALID_016";
  public static final String MEDIA_MOVEL_EXPONENCIAL_26PERIODOS_VALID_017 = "MEDIA_MOVEL_EXPONENCIAL_26PERIODOS_VALID_017";
  public static final String MEDIA_MOVEL_EXPONENCIAL_26PERIODOS_VALID_018 = "MEDIA_MOVEL_EXPONENCIAL_26PERIODOS_VALID_018";
  public static final String MEDIA_MOVEL_EXPONENCIAL_26PERIODOS_VALID_019 = "MEDIA_MOVEL_EXPONENCIAL_26PERIODOS_VALID_019";
  public static final String MEDIA_MOVEL_EXPONENCIAL_26PERIODOS_VALID_020 = "MEDIA_MOVEL_EXPONENCIAL_26PERIODOS_VALID_020";
  public static final String MEDIA_MOVEL_EXPONENCIAL_26PERIODOS_VALID_021 = "MEDIA_MOVEL_EXPONENCIAL_26PERIODOS_VALID_021";
  public static final String MEDIA_MOVEL_EXPONENCIAL_26PERIODOS_VALID_022 = "MEDIA_MOVEL_EXPONENCIAL_26PERIODOS_VALID_022";
  public static final String MEDIA_MOVEL_EXPONENCIAL_26PERIODOS_VALID_023 = "MEDIA_MOVEL_EXPONENCIAL_26PERIODOS_VALID_023";
  public static final String MEDIA_MOVEL_EXPONENCIAL_26PERIODOS_VALID_024 = "MEDIA_MOVEL_EXPONENCIAL_26PERIODOS_VALID_024";
  public static final String MEDIA_MOVEL_EXPONENCIAL_26PERIODOS_VALID_025 = "MEDIA_MOVEL_EXPONENCIAL_26PERIODOS_VALID_025";
  public static final String MEDIA_MOVEL_EXPONENCIAL_26PERIODOS_VALID_026 = "MEDIA_MOVEL_EXPONENCIAL_26PERIODOS_VALID_026";
  public static final String MEDIA_MOVEL_EXPONENCIAL_26PERIODOS_VALID_027 = "MEDIA_MOVEL_EXPONENCIAL_26PERIODOS_VALID_027";
  public static final String MEDIA_MOVEL_EXPONENCIAL_26PERIODOS_VALID_028 = "MEDIA_MOVEL_EXPONENCIAL_26PERIODOS_VALID_028";
  public static final String MEDIA_MOVEL_EXPONENCIAL_26PERIODOS_VALID_029 = "MEDIA_MOVEL_EXPONENCIAL_26PERIODOS_VALID_029";
  public static final String MEDIA_MOVEL_EXPONENCIAL_26PERIODOS_VALID_030 = "MEDIA_MOVEL_EXPONENCIAL_26PERIODOS_VALID_030";

  @Override
  public void load() {
    Fixture.of(MediaMovelExponencial.class)
        .addTemplate(MEDIA_MOVEL_EXPONENCIAL_26PERIODOS_VALID_001, new Rule() {{
          add("codneg", "MGLU3");
          add("premedult", BigDecimalCustomizado.getDoubleValueBigDecimalHalfUpArredondado4Casas(12.11));
          add("periodo", 26);
        }})
        .addTemplate(MEDIA_MOVEL_EXPONENCIAL_26PERIODOS_VALID_002)
        .inherits(MEDIA_MOVEL_EXPONENCIAL_26PERIODOS_VALID_001, new Rule() {{
          add("premedult", BigDecimalCustomizado.getDoubleValueBigDecimalHalfUpArredondado4Casas(12.9));
        }})
        .addTemplate(MEDIA_MOVEL_EXPONENCIAL_26PERIODOS_VALID_003)
        .inherits(MEDIA_MOVEL_EXPONENCIAL_26PERIODOS_VALID_001, new Rule() {{
          add("premedult", BigDecimalCustomizado.getDoubleValueBigDecimalHalfUpArredondado4Casas(12.23));
        }})
        .addTemplate(MEDIA_MOVEL_EXPONENCIAL_26PERIODOS_VALID_004)
        .inherits(MEDIA_MOVEL_EXPONENCIAL_26PERIODOS_VALID_001, new Rule() {{
          add("premedult", BigDecimalCustomizado.getDoubleValueBigDecimalHalfUpArredondado4Casas(12.32));
        }})
        .addTemplate(MEDIA_MOVEL_EXPONENCIAL_26PERIODOS_VALID_005)
        .inherits(MEDIA_MOVEL_EXPONENCIAL_26PERIODOS_VALID_001, new Rule() {{
          add("premedult", BigDecimalCustomizado.getDoubleValueBigDecimalHalfUpArredondado4Casas(12.54));
        }})
        .addTemplate(MEDIA_MOVEL_EXPONENCIAL_26PERIODOS_VALID_006)
        .inherits(MEDIA_MOVEL_EXPONENCIAL_26PERIODOS_VALID_001, new Rule() {{
          add("premedult", BigDecimalCustomizado.getDoubleValueBigDecimalHalfUpArredondado4Casas(12.2));
        }})
        .addTemplate(MEDIA_MOVEL_EXPONENCIAL_26PERIODOS_VALID_007)
        .inherits(MEDIA_MOVEL_EXPONENCIAL_26PERIODOS_VALID_001, new Rule() {{
          add("premedult", BigDecimalCustomizado.getDoubleValueBigDecimalHalfUpArredondado4Casas(12.3));
        }})
        .addTemplate(MEDIA_MOVEL_EXPONENCIAL_26PERIODOS_VALID_007)
        .inherits(MEDIA_MOVEL_EXPONENCIAL_26PERIODOS_VALID_001, new Rule() {{
          add("premedult", BigDecimalCustomizado.getDoubleValueBigDecimalHalfUpArredondado4Casas(12.1));
        }})
        .addTemplate(MEDIA_MOVEL_EXPONENCIAL_26PERIODOS_VALID_008)
        .inherits(MEDIA_MOVEL_EXPONENCIAL_26PERIODOS_VALID_001, new Rule() {{
          add("premedult", BigDecimalCustomizado.getDoubleValueBigDecimalHalfUpArredondado4Casas(12.4));
        }})
        .addTemplate(MEDIA_MOVEL_EXPONENCIAL_26PERIODOS_VALID_009)
        .inherits(MEDIA_MOVEL_EXPONENCIAL_26PERIODOS_VALID_001, new Rule() {{
          add("premedult", BigDecimalCustomizado.getDoubleValueBigDecimalHalfUpArredondado4Casas(12.37));
        }})
        .addTemplate(MEDIA_MOVEL_EXPONENCIAL_26PERIODOS_VALID_010)
        .inherits(MEDIA_MOVEL_EXPONENCIAL_26PERIODOS_VALID_001, new Rule() {{
          add("premedult", BigDecimalCustomizado.getDoubleValueBigDecimalHalfUpArredondado4Casas(12.56));
        }})
        .addTemplate(MEDIA_MOVEL_EXPONENCIAL_26PERIODOS_VALID_011)
        .inherits(MEDIA_MOVEL_EXPONENCIAL_26PERIODOS_VALID_001, new Rule() {{
          add("premedult", BigDecimalCustomizado.getDoubleValueBigDecimalHalfUpArredondado4Casas(12.76));
        }})
        .addTemplate(MEDIA_MOVEL_EXPONENCIAL_26PERIODOS_VALID_012)
        .inherits(MEDIA_MOVEL_EXPONENCIAL_26PERIODOS_VALID_001, new Rule() {{
          add("premedult", BigDecimalCustomizado.getDoubleValueBigDecimalHalfUpArredondado4Casas(12.12));
        }})
        .addTemplate(MEDIA_MOVEL_EXPONENCIAL_26PERIODOS_VALID_013)
        .inherits(MEDIA_MOVEL_EXPONENCIAL_26PERIODOS_VALID_001, new Rule() {{
          add("premedult", BigDecimalCustomizado.getDoubleValueBigDecimalHalfUpArredondado4Casas(12.13));
        }})
        .addTemplate(MEDIA_MOVEL_EXPONENCIAL_26PERIODOS_VALID_014)
        .inherits(MEDIA_MOVEL_EXPONENCIAL_26PERIODOS_VALID_001, new Rule() {{
          add("premedult", BigDecimalCustomizado.getDoubleValueBigDecimalHalfUpArredondado4Casas(12.14));
        }})
        .addTemplate(MEDIA_MOVEL_EXPONENCIAL_26PERIODOS_VALID_015)
        .inherits(MEDIA_MOVEL_EXPONENCIAL_26PERIODOS_VALID_001, new Rule() {{
          add("premedult", BigDecimalCustomizado.getDoubleValueBigDecimalHalfUpArredondado4Casas(12.15));
        }})
        .addTemplate(MEDIA_MOVEL_EXPONENCIAL_26PERIODOS_VALID_016)
        .inherits(MEDIA_MOVEL_EXPONENCIAL_26PERIODOS_VALID_001, new Rule() {{
          add("premedult", BigDecimalCustomizado.getDoubleValueBigDecimalHalfUpArredondado4Casas(12.16));
        }})
        .addTemplate(MEDIA_MOVEL_EXPONENCIAL_26PERIODOS_VALID_017)
        .inherits(MEDIA_MOVEL_EXPONENCIAL_26PERIODOS_VALID_001, new Rule() {{
          add("premedult", BigDecimalCustomizado.getDoubleValueBigDecimalHalfUpArredondado4Casas(12.17));
        }})
        .addTemplate(MEDIA_MOVEL_EXPONENCIAL_26PERIODOS_VALID_018)
        .inherits(MEDIA_MOVEL_EXPONENCIAL_26PERIODOS_VALID_001, new Rule() {{
          add("premedult", BigDecimalCustomizado.getDoubleValueBigDecimalHalfUpArredondado4Casas(12.18));
        }})
        .addTemplate(MEDIA_MOVEL_EXPONENCIAL_26PERIODOS_VALID_018)
        .inherits(MEDIA_MOVEL_EXPONENCIAL_26PERIODOS_VALID_001, new Rule() {{
          add("premedult", BigDecimalCustomizado.getDoubleValueBigDecimalHalfUpArredondado4Casas(12.18));
        }})
        .addTemplate(MEDIA_MOVEL_EXPONENCIAL_26PERIODOS_VALID_019)
        .inherits(MEDIA_MOVEL_EXPONENCIAL_26PERIODOS_VALID_001, new Rule() {{
          add("premedult", BigDecimalCustomizado.getDoubleValueBigDecimalHalfUpArredondado4Casas(12.19));
        }})
        .addTemplate(MEDIA_MOVEL_EXPONENCIAL_26PERIODOS_VALID_020)
        .inherits(MEDIA_MOVEL_EXPONENCIAL_26PERIODOS_VALID_001, new Rule() {{
          add("premedult", BigDecimalCustomizado.getDoubleValueBigDecimalHalfUpArredondado4Casas(12.20));
        }})
        .addTemplate(MEDIA_MOVEL_EXPONENCIAL_26PERIODOS_VALID_021)
        .inherits(MEDIA_MOVEL_EXPONENCIAL_26PERIODOS_VALID_001, new Rule() {{
          add("premedult", BigDecimalCustomizado.getDoubleValueBigDecimalHalfUpArredondado4Casas(12.21));
        }})
        .addTemplate(MEDIA_MOVEL_EXPONENCIAL_26PERIODOS_VALID_022)
        .inherits(MEDIA_MOVEL_EXPONENCIAL_26PERIODOS_VALID_001, new Rule() {{
          add("premedult", BigDecimalCustomizado.getDoubleValueBigDecimalHalfUpArredondado4Casas(12.22));
        }})
        .addTemplate(MEDIA_MOVEL_EXPONENCIAL_26PERIODOS_VALID_023)
        .inherits(MEDIA_MOVEL_EXPONENCIAL_26PERIODOS_VALID_001, new Rule() {{
          add("premedult", BigDecimalCustomizado.getDoubleValueBigDecimalHalfUpArredondado4Casas(12.23));
        }})
        .addTemplate(MEDIA_MOVEL_EXPONENCIAL_26PERIODOS_VALID_024)
        .inherits(MEDIA_MOVEL_EXPONENCIAL_26PERIODOS_VALID_001, new Rule() {{
          add("premedult", BigDecimalCustomizado.getDoubleValueBigDecimalHalfUpArredondado4Casas(12.24));
        }})
        .addTemplate(MEDIA_MOVEL_EXPONENCIAL_26PERIODOS_VALID_025)
        .inherits(MEDIA_MOVEL_EXPONENCIAL_26PERIODOS_VALID_001, new Rule() {{
          add("premedult", BigDecimalCustomizado.getDoubleValueBigDecimalHalfUpArredondado4Casas(12.25));
        }})
        .addTemplate(MEDIA_MOVEL_EXPONENCIAL_26PERIODOS_VALID_026)
        .inherits(MEDIA_MOVEL_EXPONENCIAL_26PERIODOS_VALID_001, new Rule() {{
          add("premedult", BigDecimalCustomizado.getDoubleValueBigDecimalHalfUpArredondado4Casas(12.26));
        }})
        .addTemplate(MEDIA_MOVEL_EXPONENCIAL_26PERIODOS_VALID_027)
        .inherits(MEDIA_MOVEL_EXPONENCIAL_26PERIODOS_VALID_001, new Rule() {{
          add("premedult", BigDecimalCustomizado.getDoubleValueBigDecimalHalfUpArredondado4Casas(12.27));
        }})
        .addTemplate(MEDIA_MOVEL_EXPONENCIAL_26PERIODOS_VALID_028)
        .inherits(MEDIA_MOVEL_EXPONENCIAL_26PERIODOS_VALID_001, new Rule() {{
          add("premedult", BigDecimalCustomizado.getDoubleValueBigDecimalHalfUpArredondado4Casas(12.28));
        }})
        .addTemplate(MEDIA_MOVEL_EXPONENCIAL_26PERIODOS_VALID_029)
        .inherits(MEDIA_MOVEL_EXPONENCIAL_26PERIODOS_VALID_001, new Rule() {{
          add("premedult", BigDecimalCustomizado.getDoubleValueBigDecimalHalfUpArredondado4Casas(12.29));
        }})
        .addTemplate(MEDIA_MOVEL_EXPONENCIAL_26PERIODOS_VALID_030)
        .inherits(MEDIA_MOVEL_EXPONENCIAL_26PERIODOS_VALID_001, new Rule() {{
          add("premedult", BigDecimalCustomizado.getDoubleValueBigDecimalHalfUpArredondado4Casas(12.30));
        }});
  }
}
