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
import com.ricardococati.model.dto.MacdDiario;
import java.time.LocalDate;

public class MacdDiarioTemplateLoader implements TemplateLoader {

  public static final String MACD_DIARIO_VALID_001 = "MACD_DIARIO_VALID_001";
  public static final String MACD_DIARIO_VALID_002 = "MACD_DIARIO_VALID_002";
  public static final String MACD_DIARIO_VALID_003 = "MACD_DIARIO_VALID_003";
  public static final String MACD_DIARIO_VALID_004 = "MACD_DIARIO_VALID_004";
  public static final String MACD_DIARIO_VALID_005 = "MACD_DIARIO_VALID_005";
  public static final String MACD_DIARIO_VALID_006 = "MACD_DIARIO_VALID_006";
  public static final String MACD_DIARIO_VALID_007 = "MACD_DIARIO_VALID_007";
  public static final String MACD_DIARIO_VALID_008 = "MACD_DIARIO_VALID_008";
  public static final String MACD_DIARIO_VALID_009 = "MACD_DIARIO_VALID_009";
  public static final String MACD_DIARIO_VALID_010 = "MACD_DIARIO_VALID_010";
  public static final String MACD_DIARIO_VALID_011 = "MACD_DIARIO_VALID_011";

  @Override
  public void load() {
    Fixture.of(MacdDiario.class)
        .addTemplate(MACD_DIARIO_VALID_001,
            new Rule() {{
              add("idMacdDiario", random(Long.class, range(1L, 200L)));
              add("dtpreg", LocalDate.of(1978, 2, 16));
              add("macd", one(Macd.class, MACD_VALID_001));
            }})
        .addTemplate(MACD_DIARIO_VALID_002, new Rule() {{
          add("idMacdDiario", random(Long.class, range(1L, 200L)));
          add("dtpreg", LocalDate.of(1978, 2, 17));
          add("macd", one(Macd.class, MACD_VALID_002));
        }})
        .addTemplate(MACD_DIARIO_VALID_003, new Rule() {{
          add("idMacdDiario", random(Long.class, range(1L, 200L)));
          add("dtpreg", LocalDate.of(1978, 2, 18));
          add("macd", one(Macd.class, MACD_VALID_003));
        }})
        .addTemplate(MACD_DIARIO_VALID_004, new Rule() {{
          add("idMacdDiario", random(Long.class, range(1L, 200L)));
          add("dtpreg", LocalDate.of(1978, 2, 19));
          add("macd", one(Macd.class, MACD_VALID_004));
        }})
        .addTemplate(MACD_DIARIO_VALID_005, new Rule() {{
          add("idMacdDiario", random(Long.class, range(1L, 200L)));
          add("dtpreg", LocalDate.of(1978, 2, 20));
          add("macd", one(Macd.class, MACD_VALID_005));
        }})
        .addTemplate(MACD_DIARIO_VALID_006, new Rule() {{
          add("idMacdDiario", random(Long.class, range(1L, 200L)));
          add("dtpreg", LocalDate.of(1978, 2, 21));
          add("macd", one(Macd.class, MACD_VALID_006));
        }})
        .addTemplate(MACD_DIARIO_VALID_007, new Rule() {{
          add("idMacdDiario", random(Long.class, range(1L, 200L)));
          add("dtpreg", LocalDate.of(1978, 2, 22));
          add("macd", one(Macd.class, MACD_VALID_007));
        }})
        .addTemplate(MACD_DIARIO_VALID_008, new Rule() {{
          add("idMacdDiario", random(Long.class, range(1L, 200L)));
          add("dtpreg", LocalDate.of(1978, 2, 23));
          add("macd", one(Macd.class, MACD_VALID_008));
        }})
        .addTemplate(MACD_DIARIO_VALID_009, new Rule() {{
          add("idMacdDiario", random(Long.class, range(1L, 200L)));
          add("dtpreg", LocalDate.of(1978, 2, 24));
          add("macd", one(Macd.class, MACD_VALID_009));
        }})
        .addTemplate(MACD_DIARIO_VALID_010, new Rule() {{
          add("idMacdDiario", random(Long.class, range(1L, 200L)));
          add("dtpreg", LocalDate.of(1978, 2, 25));
          add("macd", one(Macd.class, MACD_VALID_010));
        }})
        .addTemplate(MACD_DIARIO_VALID_011, new Rule() {{
          add("idMacdDiario", random(Long.class, range(1L, 200L)));
          add("dtpreg", LocalDate.of(1978, 2, 26));
          add("macd", one(Macd.class, MACD_VALID_011));
        }});
  }
}
