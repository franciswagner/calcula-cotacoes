package com.ricardococati.service.impl.templates;

import static com.ricardococati.service.impl.templates.MacdTemplateLoader.MACD_VALID_001;
import static com.ricardococati.service.impl.templates.MacdTemplateLoader.MACD_VALID_002;
import static com.ricardococati.service.impl.templates.MacdTemplateLoader.MACD_VALID_003;
import static com.ricardococati.service.impl.templates.MacdTemplateLoader.MACD_VALID_004;
import static com.ricardococati.service.impl.templates.MacdTemplateLoader.MACD_VALID_005;
import static com.ricardococati.service.impl.templates.MacdTemplateLoader.MACD_VALID_006;
import static com.ricardococati.service.impl.templates.MacdTemplateLoader.MACD_VALID_007;
import static com.ricardococati.service.impl.templates.MacdTemplateLoader.MACD_VALID_008;
import static com.ricardococati.service.impl.templates.MacdTemplateLoader.MACD_VALID_009;
import static com.ricardococati.service.impl.templates.MacdTemplateLoader.MACD_VALID_010;
import static com.ricardococati.service.impl.templates.MacdTemplateLoader.MACD_VALID_011;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;
import com.ricardococati.model.dto.Macd;
import com.ricardococati.model.dto.MacdSemanal;
import java.time.LocalDate;

public class MacdSemanalTemplateLoader implements TemplateLoader {

  public static final String MACD_SEMANAL_VALID_001 = "MACD_SEMANAL_VALID_001";
  public static final String MACD_SEMANAL_VALID_002 = "MACD_SEMANAL_VALID_002";
  public static final String MACD_SEMANAL_VALID_003 = "MACD_SEMANAL_VALID_003";
  public static final String MACD_SEMANAL_VALID_004 = "MACD_SEMANAL_VALID_004";
  public static final String MACD_SEMANAL_VALID_005 = "MACD_SEMANAL_VALID_005";
  public static final String MACD_SEMANAL_VALID_006 = "MACD_SEMANAL_VALID_006";
  public static final String MACD_SEMANAL_VALID_007 = "MACD_SEMANAL_VALID_007";
  public static final String MACD_SEMANAL_VALID_008 = "MACD_SEMANAL_VALID_008";
  public static final String MACD_SEMANAL_VALID_009 = "MACD_SEMANAL_VALID_009";
  public static final String MACD_SEMANAL_VALID_010 = "MACD_SEMANAL_VALID_010";
  public static final String MACD_SEMANAL_VALID_011 = "MACD_SEMANAL_VALID_011";
  private LocalDate localDate = LocalDate.of(1978, 2, 16);

  @Override
  public void load() {
    Fixture.of(MacdSemanal.class)
        .addTemplate(MACD_SEMANAL_VALID_001,
            new Rule() {{
              add("idMacdSemanal", random(Long.class, range(1L, 200L)));
              add("dtpregini", localDate);
              add("dtpregfim", localDate.plusDays(2));
              add("macd", one(Macd.class, MACD_VALID_001));
            }})
        .addTemplate(MACD_SEMANAL_VALID_002, new Rule() {{
          add("idMacdSemanal", random(Long.class, range(1L, 200L)));
          add("dtpregini", localDate.plusDays(3));
          add("dtpregfim", localDate.plusDays(4));
          add("macd", one(Macd.class, MACD_VALID_002));
        }})
        .addTemplate(MACD_SEMANAL_VALID_003, new Rule() {{
          add("idMacdSemanal", random(Long.class, range(1L, 200L)));
          add("dtpregini", localDate.plusDays(5));
          add("dtpregfim", localDate.plusDays(6));
          add("macd", one(Macd.class, MACD_VALID_003));
        }})
        .addTemplate(MACD_SEMANAL_VALID_004, new Rule() {{
          add("idMacdSemanal", random(Long.class, range(1L, 200L)));
          add("dtpregini", localDate.plusDays(7));
          add("dtpregfim", localDate.plusDays(8));
          add("macd", one(Macd.class, MACD_VALID_004));
        }})
        .addTemplate(MACD_SEMANAL_VALID_005, new Rule() {{
          add("idMacdSemanal", random(Long.class, range(1L, 200L)));
          add("dtpregini", localDate.plusDays(9));
          add("dtpregfim", localDate.plusDays(10));
          add("macd", one(Macd.class, MACD_VALID_005));
        }})
        .addTemplate(MACD_SEMANAL_VALID_006, new Rule() {{
          add("idMacdSemanal", random(Long.class, range(1L, 200L)));
          add("dtpregini", localDate.plusDays(11));
          add("dtpregfim", localDate.plusDays(12));
          add("macd", one(Macd.class, MACD_VALID_006));
        }})
        .addTemplate(MACD_SEMANAL_VALID_007, new Rule() {{
          add("idMacdSemanal", random(Long.class, range(1L, 200L)));
          add("dtpregini", localDate.plusDays(13));
          add("dtpregfim", localDate.plusDays(14));
          add("macd", one(Macd.class, MACD_VALID_007));
        }})
        .addTemplate(MACD_SEMANAL_VALID_008, new Rule() {{
          add("idMacdSemanal", random(Long.class, range(1L, 200L)));
          add("dtpregini", localDate.plusDays(15));
          add("dtpregfim", localDate.plusDays(16));
          add("macd", one(Macd.class, MACD_VALID_008));
        }})
        .addTemplate(MACD_SEMANAL_VALID_009, new Rule() {{
          add("idMacdSemanal", random(Long.class, range(1L, 200L)));
          add("dtpregini", localDate.plusDays(17));
          add("dtpregfim", localDate.plusDays(18));
          add("macd", one(Macd.class, MACD_VALID_009));
        }})
        .addTemplate(MACD_SEMANAL_VALID_010, new Rule() {{
          add("idMacdSemanal", random(Long.class, range(1L, 200L)));
          add("dtpregini", localDate.plusDays(19));
          add("dtpregfim", localDate.plusDays(20));
          add("macd", one(Macd.class, MACD_VALID_010));
        }})
        .addTemplate(MACD_SEMANAL_VALID_011, new Rule() {{
          add("idMacdSemanal", random(Long.class, range(1L, 200L)));
          add("dtpregini", localDate.plusDays(21));
          add("dtpregfim", localDate.plusDays(22));
          add("macd", one(Macd.class, MACD_VALID_011));
        }});
  }
}
