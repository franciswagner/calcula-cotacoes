package com.ricardococati.repository.dao.templates;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;
import com.ricardococati.model.dto.MediaMovelExponencial;
import java.math.BigDecimal;

public class MediaMovelExponencial12PeriodosTemplateLoader implements TemplateLoader {

  public static final String MEDIA_MOVEL_EXPONENCIAL_12PERIODOS_VALID_001 = "MEDIA_MOVEL_EXPONENCIAL_12PERIODOS_VALID_001";
  public static final String MEDIA_MOVEL_EXPONENCIAL_12PERIODOS_VALID_002 = "MEDIA_MOVEL_EXPONENCIAL_12PERIODOS_VALID_002";
  public static final String MEDIA_MOVEL_EXPONENCIAL_12PERIODOS_VALID_003 = "MEDIA_MOVEL_EXPONENCIAL_12PERIODOS_VALID_003";
  public static final String MEDIA_MOVEL_EXPONENCIAL_12PERIODOS_VALID_004 = "MEDIA_MOVEL_EXPONENCIAL_12PERIODOS_VALID_004";
  public static final String MEDIA_MOVEL_EXPONENCIAL_12PERIODOS_VALID_005 = "MEDIA_MOVEL_EXPONENCIAL_12PERIODOS_VALID_005";
  public static final String MEDIA_MOVEL_EXPONENCIAL_12PERIODOS_VALID_006 = "MEDIA_MOVEL_EXPONENCIAL_12PERIODOS_VALID_006";
  public static final String MEDIA_MOVEL_EXPONENCIAL_12PERIODOS_VALID_007 = "MEDIA_MOVEL_EXPONENCIAL_12PERIODOS_VALID_007";
  public static final String MEDIA_MOVEL_EXPONENCIAL_12PERIODOS_VALID_008 = "MEDIA_MOVEL_EXPONENCIAL_12PERIODOS_VALID_008";
  public static final String MEDIA_MOVEL_EXPONENCIAL_12PERIODOS_VALID_009 = "MEDIA_MOVEL_EXPONENCIAL_12PERIODOS_VALID_009";
  public static final String MEDIA_MOVEL_EXPONENCIAL_12PERIODOS_VALID_010 = "MEDIA_MOVEL_EXPONENCIAL_12PERIODOS_VALID_010";
  public static final String MEDIA_MOVEL_EXPONENCIAL_12PERIODOS_VALID_011 = "MEDIA_MOVEL_EXPONENCIAL_12PERIODOS_VALID_011";
  public static final String MEDIA_MOVEL_EXPONENCIAL_12PERIODOS_VALID_012 = "MEDIA_MOVEL_EXPONENCIAL_12PERIODOS_VALID_012";
  public static final String MEDIA_MOVEL_EXPONENCIAL_12PERIODOS_VALID_013 = "MEDIA_MOVEL_EXPONENCIAL_12PERIODOS_VALID_013";
  public static final String MEDIA_MOVEL_EXPONENCIAL_12PERIODOS_VALID_014 = "MEDIA_MOVEL_EXPONENCIAL_12PERIODOS_VALID_014";
  public static final String MEDIA_MOVEL_EXPONENCIAL_12PERIODOS_VALID_015 = "MEDIA_MOVEL_EXPONENCIAL_12PERIODOS_VALID_015";
  public static final String MEDIA_MOVEL_EXPONENCIAL_12PERIODOS_VALID_016 = "MEDIA_MOVEL_EXPONENCIAL_12PERIODOS_VALID_016";
  public static final String MEDIA_MOVEL_EXPONENCIAL_12PERIODOS_VALID_017 = "MEDIA_MOVEL_EXPONENCIAL_12PERIODOS_VALID_017";
  public static final String MEDIA_MOVEL_EXPONENCIAL_12PERIODOS_VALID_018 = "MEDIA_MOVEL_EXPONENCIAL_12PERIODOS_VALID_018";
  public static final String MEDIA_MOVEL_EXPONENCIAL_12PERIODOS_VALID_019 = "MEDIA_MOVEL_EXPONENCIAL_12PERIODOS_VALID_019";
  public static final String MEDIA_MOVEL_EXPONENCIAL_12PERIODOS_VALID_020 = "MEDIA_MOVEL_EXPONENCIAL_12PERIODOS_VALID_020";
  public static final String MEDIA_MOVEL_EXPONENCIAL_12PERIODOS_VALID_021 = "MEDIA_MOVEL_EXPONENCIAL_12PERIODOS_VALID_021";
  public static final String MEDIA_MOVEL_EXPONENCIAL_12PERIODOS_VALID_022 = "MEDIA_MOVEL_EXPONENCIAL_12PERIODOS_VALID_022";
  public static final String MEDIA_MOVEL_EXPONENCIAL_12PERIODOS_VALID_023 = "MEDIA_MOVEL_EXPONENCIAL_12PERIODOS_VALID_023";
  public static final String MEDIA_MOVEL_EXPONENCIAL_12PERIODOS_VALID_024 = "MEDIA_MOVEL_EXPONENCIAL_12PERIODOS_VALID_024";
  public static final String MEDIA_MOVEL_EXPONENCIAL_12PERIODOS_VALID_025 = "MEDIA_MOVEL_EXPONENCIAL_12PERIODOS_VALID_025";
  public static final String MEDIA_MOVEL_EXPONENCIAL_12PERIODOS_VALID_026 = "MEDIA_MOVEL_EXPONENCIAL_12PERIODOS_VALID_026";
  public static final String MEDIA_MOVEL_EXPONENCIAL_12PERIODOS_VALID_027 = "MEDIA_MOVEL_EXPONENCIAL_12PERIODOS_VALID_027";
  public static final String MEDIA_MOVEL_EXPONENCIAL_12PERIODOS_VALID_028 = "MEDIA_MOVEL_EXPONENCIAL_12PERIODOS_VALID_028";
  public static final String MEDIA_MOVEL_EXPONENCIAL_12PERIODOS_VALID_029 = "MEDIA_MOVEL_EXPONENCIAL_12PERIODOS_VALID_029";
  public static final String MEDIA_MOVEL_EXPONENCIAL_12PERIODOS_VALID_030 = "MEDIA_MOVEL_EXPONENCIAL_12PERIODOS_VALID_030";

  @Override
  public void load() {
    Fixture.of(MediaMovelExponencial.class)
        .addTemplate(MEDIA_MOVEL_EXPONENCIAL_12PERIODOS_VALID_001, new Rule() {{
          add("codneg", "MGLU3");
          add("premedult", new BigDecimal("13.11").setScale(4, BigDecimal.ROUND_HALF_UP));
          add("periodo", 12);
        }})
        .addTemplate(MEDIA_MOVEL_EXPONENCIAL_12PERIODOS_VALID_002)
        .inherits(MEDIA_MOVEL_EXPONENCIAL_12PERIODOS_VALID_001, new Rule() {{
          add("premedult", new BigDecimal("13.9").setScale(4, BigDecimal.ROUND_HALF_UP));
        }})
        .addTemplate(MEDIA_MOVEL_EXPONENCIAL_12PERIODOS_VALID_003)
        .inherits(MEDIA_MOVEL_EXPONENCIAL_12PERIODOS_VALID_001, new Rule() {{
          add("premedult", new BigDecimal("13.23").setScale(4, BigDecimal.ROUND_HALF_UP));
        }})
        .addTemplate(MEDIA_MOVEL_EXPONENCIAL_12PERIODOS_VALID_004)
        .inherits(MEDIA_MOVEL_EXPONENCIAL_12PERIODOS_VALID_001, new Rule() {{
          add("premedult", new BigDecimal("13.32").setScale(4, BigDecimal.ROUND_HALF_UP));
        }})
        .addTemplate(MEDIA_MOVEL_EXPONENCIAL_12PERIODOS_VALID_005)
        .inherits(MEDIA_MOVEL_EXPONENCIAL_12PERIODOS_VALID_001, new Rule() {{
          add("premedult", new BigDecimal("13.54").setScale(4, BigDecimal.ROUND_HALF_UP));
        }})
        .addTemplate(MEDIA_MOVEL_EXPONENCIAL_12PERIODOS_VALID_006)
        .inherits(MEDIA_MOVEL_EXPONENCIAL_12PERIODOS_VALID_001, new Rule() {{
          add("premedult", new BigDecimal("13.2").setScale(4, BigDecimal.ROUND_HALF_UP));
        }})
        .addTemplate(MEDIA_MOVEL_EXPONENCIAL_12PERIODOS_VALID_007)
        .inherits(MEDIA_MOVEL_EXPONENCIAL_12PERIODOS_VALID_001, new Rule() {{
          add("premedult", new BigDecimal("13.3").setScale(4, BigDecimal.ROUND_HALF_UP));
        }})
        .addTemplate(MEDIA_MOVEL_EXPONENCIAL_12PERIODOS_VALID_007)
        .inherits(MEDIA_MOVEL_EXPONENCIAL_12PERIODOS_VALID_001, new Rule() {{
          add("premedult", new BigDecimal("13.1").setScale(4, BigDecimal.ROUND_HALF_UP));
        }})
        .addTemplate(MEDIA_MOVEL_EXPONENCIAL_12PERIODOS_VALID_008)
        .inherits(MEDIA_MOVEL_EXPONENCIAL_12PERIODOS_VALID_001, new Rule() {{
          add("premedult", new BigDecimal("13.4").setScale(4, BigDecimal.ROUND_HALF_UP));
        }})
        .addTemplate(MEDIA_MOVEL_EXPONENCIAL_12PERIODOS_VALID_009)
        .inherits(MEDIA_MOVEL_EXPONENCIAL_12PERIODOS_VALID_001, new Rule() {{
          add("premedult", new BigDecimal("13.37").setScale(4, BigDecimal.ROUND_HALF_UP));
        }})
        .addTemplate(MEDIA_MOVEL_EXPONENCIAL_12PERIODOS_VALID_010)
        .inherits(MEDIA_MOVEL_EXPONENCIAL_12PERIODOS_VALID_001, new Rule() {{
          add("premedult", new BigDecimal("13.56").setScale(4, BigDecimal.ROUND_HALF_UP));
        }})
        .addTemplate(MEDIA_MOVEL_EXPONENCIAL_12PERIODOS_VALID_011)
        .inherits(MEDIA_MOVEL_EXPONENCIAL_12PERIODOS_VALID_001, new Rule() {{
          add("premedult", new BigDecimal("13.76").setScale(4, BigDecimal.ROUND_HALF_UP));
        }})
        .addTemplate(MEDIA_MOVEL_EXPONENCIAL_12PERIODOS_VALID_012)
        .inherits(MEDIA_MOVEL_EXPONENCIAL_12PERIODOS_VALID_001, new Rule() {{
          add("premedult", new BigDecimal("13.12").setScale(4, BigDecimal.ROUND_HALF_UP));
        }})
        .addTemplate(MEDIA_MOVEL_EXPONENCIAL_12PERIODOS_VALID_013)
        .inherits(MEDIA_MOVEL_EXPONENCIAL_12PERIODOS_VALID_001, new Rule() {{
          add("premedult", new BigDecimal("13.13").setScale(4, BigDecimal.ROUND_HALF_UP));
        }})
        .addTemplate(MEDIA_MOVEL_EXPONENCIAL_12PERIODOS_VALID_014)
        .inherits(MEDIA_MOVEL_EXPONENCIAL_12PERIODOS_VALID_001, new Rule() {{
          add("premedult", new BigDecimal("13.14").setScale(4, BigDecimal.ROUND_HALF_UP));
        }})
        .addTemplate(MEDIA_MOVEL_EXPONENCIAL_12PERIODOS_VALID_015)
        .inherits(MEDIA_MOVEL_EXPONENCIAL_12PERIODOS_VALID_001, new Rule() {{
          add("premedult", new BigDecimal("13.15").setScale(4, BigDecimal.ROUND_HALF_UP));
        }})
        .addTemplate(MEDIA_MOVEL_EXPONENCIAL_12PERIODOS_VALID_016)
        .inherits(MEDIA_MOVEL_EXPONENCIAL_12PERIODOS_VALID_001, new Rule() {{
          add("premedult", new BigDecimal("13.16").setScale(4, BigDecimal.ROUND_HALF_UP));
        }})
        .addTemplate(MEDIA_MOVEL_EXPONENCIAL_12PERIODOS_VALID_017)
        .inherits(MEDIA_MOVEL_EXPONENCIAL_12PERIODOS_VALID_001, new Rule() {{
          add("premedult", new BigDecimal("13.17").setScale(4, BigDecimal.ROUND_HALF_UP));
        }})
        .addTemplate(MEDIA_MOVEL_EXPONENCIAL_12PERIODOS_VALID_018)
        .inherits(MEDIA_MOVEL_EXPONENCIAL_12PERIODOS_VALID_001, new Rule() {{
          add("premedult", new BigDecimal("13.18").setScale(4, BigDecimal.ROUND_HALF_UP));
        }})
        .addTemplate(MEDIA_MOVEL_EXPONENCIAL_12PERIODOS_VALID_018)
        .inherits(MEDIA_MOVEL_EXPONENCIAL_12PERIODOS_VALID_001, new Rule() {{
          add("premedult", new BigDecimal("13.18").setScale(4, BigDecimal.ROUND_HALF_UP));
        }})
        .addTemplate(MEDIA_MOVEL_EXPONENCIAL_12PERIODOS_VALID_019)
        .inherits(MEDIA_MOVEL_EXPONENCIAL_12PERIODOS_VALID_001, new Rule() {{
          add("premedult", new BigDecimal("13.19").setScale(4, BigDecimal.ROUND_HALF_UP));
        }})
        .addTemplate(MEDIA_MOVEL_EXPONENCIAL_12PERIODOS_VALID_020)
        .inherits(MEDIA_MOVEL_EXPONENCIAL_12PERIODOS_VALID_001, new Rule() {{
          add("premedult", new BigDecimal("13.20").setScale(4, BigDecimal.ROUND_HALF_UP));
        }})
        .addTemplate(MEDIA_MOVEL_EXPONENCIAL_12PERIODOS_VALID_021)
        .inherits(MEDIA_MOVEL_EXPONENCIAL_12PERIODOS_VALID_001, new Rule() {{
          add("premedult", new BigDecimal("13.21").setScale(4, BigDecimal.ROUND_HALF_UP));
        }})
        .addTemplate(MEDIA_MOVEL_EXPONENCIAL_12PERIODOS_VALID_022)
        .inherits(MEDIA_MOVEL_EXPONENCIAL_12PERIODOS_VALID_001, new Rule() {{
          add("premedult", new BigDecimal("13.22").setScale(4, BigDecimal.ROUND_HALF_UP));
        }})
        .addTemplate(MEDIA_MOVEL_EXPONENCIAL_12PERIODOS_VALID_023)
        .inherits(MEDIA_MOVEL_EXPONENCIAL_12PERIODOS_VALID_001, new Rule() {{
          add("premedult", new BigDecimal("13.23").setScale(4, BigDecimal.ROUND_HALF_UP));
        }})
        .addTemplate(MEDIA_MOVEL_EXPONENCIAL_12PERIODOS_VALID_024)
        .inherits(MEDIA_MOVEL_EXPONENCIAL_12PERIODOS_VALID_001, new Rule() {{
          add("premedult", new BigDecimal("13.24").setScale(4, BigDecimal.ROUND_HALF_UP));
        }})
        .addTemplate(MEDIA_MOVEL_EXPONENCIAL_12PERIODOS_VALID_025)
        .inherits(MEDIA_MOVEL_EXPONENCIAL_12PERIODOS_VALID_001, new Rule() {{
          add("premedult", new BigDecimal("13.25").setScale(4, BigDecimal.ROUND_HALF_UP));
        }})
        .addTemplate(MEDIA_MOVEL_EXPONENCIAL_12PERIODOS_VALID_026)
        .inherits(MEDIA_MOVEL_EXPONENCIAL_12PERIODOS_VALID_001, new Rule() {{
          add("premedult", new BigDecimal("13.26").setScale(4, BigDecimal.ROUND_HALF_UP));
        }})
        .addTemplate(MEDIA_MOVEL_EXPONENCIAL_12PERIODOS_VALID_027)
        .inherits(MEDIA_MOVEL_EXPONENCIAL_12PERIODOS_VALID_001, new Rule() {{
          add("premedult", new BigDecimal("13.27").setScale(4, BigDecimal.ROUND_HALF_UP));
        }})
        .addTemplate(MEDIA_MOVEL_EXPONENCIAL_12PERIODOS_VALID_028)
        .inherits(MEDIA_MOVEL_EXPONENCIAL_12PERIODOS_VALID_001, new Rule() {{
          add("premedult", new BigDecimal("13.28").setScale(4, BigDecimal.ROUND_HALF_UP));
        }})
        .addTemplate(MEDIA_MOVEL_EXPONENCIAL_12PERIODOS_VALID_029)
        .inherits(MEDIA_MOVEL_EXPONENCIAL_12PERIODOS_VALID_001, new Rule() {{
          add("premedult", new BigDecimal("13.29").setScale(4, BigDecimal.ROUND_HALF_UP));
        }})
        .addTemplate(MEDIA_MOVEL_EXPONENCIAL_12PERIODOS_VALID_030)
        .inherits(MEDIA_MOVEL_EXPONENCIAL_12PERIODOS_VALID_001, new Rule() {{
          add("premedult", new BigDecimal("13.30").setScale(4, BigDecimal.ROUND_HALF_UP));
        }});
  }
}