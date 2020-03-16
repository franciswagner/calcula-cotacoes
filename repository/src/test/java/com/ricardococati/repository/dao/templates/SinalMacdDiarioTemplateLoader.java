package com.ricardococati.repository.dao.templates;

import static com.ricardococati.repository.dao.templates.SinalMacdTemplateLoader.SINAL_MACD_VALID_001;
import static com.ricardococati.repository.dao.templates.SinalMacdTemplateLoader.SINAL_MACD_VALID_002;
import static com.ricardococati.repository.dao.templates.SinalMacdTemplateLoader.SINAL_MACD_VALID_003;
import static com.ricardococati.repository.dao.templates.SinalMacdTemplateLoader.SINAL_MACD_VALID_004;
import static com.ricardococati.repository.dao.templates.SinalMacdTemplateLoader.SINAL_MACD_VALID_005;
import static com.ricardococati.repository.dao.templates.SinalMacdTemplateLoader.SINAL_MACD_VALID_006;
import static com.ricardococati.repository.dao.templates.SinalMacdTemplateLoader.SINAL_MACD_VALID_007;
import static com.ricardococati.repository.dao.templates.SinalMacdTemplateLoader.SINAL_MACD_VALID_008;
import static com.ricardococati.repository.dao.templates.SinalMacdTemplateLoader.SINAL_MACD_VALID_009;
import static com.ricardococati.repository.dao.templates.SinalMacdTemplateLoader.SINAL_MACD_VALID_010;
import static com.ricardococati.repository.dao.templates.SinalMacdTemplateLoader.SINAL_MACD_VALID_011;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;
import com.ricardococati.model.entities.SinalMacd;
import com.ricardococati.model.entities.SinalMacdDiario;
import java.time.LocalDate;

public class SinalMacdDiarioTemplateLoader implements TemplateLoader {

  public static final String SINAL_MACD_DIARIO_VALID_001 = "SINAL_MACD_DIARIO_VALID_001";
  public static final String SINAL_MACD_DIARIO_VALID_002 = "SINAL_MACD_DIARIO_VALID_002";
  public static final String SINAL_MACD_DIARIO_VALID_003 = "SINAL_MACD_DIARIO_VALID_003";
  public static final String SINAL_MACD_DIARIO_VALID_004 = "SINAL_MACD_DIARIO_VALID_004";
  public static final String SINAL_MACD_DIARIO_VALID_005 = "SINAL_MACD_DIARIO_VALID_005";
  public static final String SINAL_MACD_DIARIO_VALID_006 = "SINAL_MACD_DIARIO_VALID_006";
  public static final String SINAL_MACD_DIARIO_VALID_007 = "SINAL_MACD_DIARIO_VALID_007";
  public static final String SINAL_MACD_DIARIO_VALID_008 = "SINAL_MACD_DIARIO_VALID_008";
  public static final String SINAL_MACD_DIARIO_VALID_009 = "SINAL_MACD_DIARIO_VALID_009";
  public static final String SINAL_MACD_DIARIO_VALID_010 = "SINAL_MACD_DIARIO_VALID_010";
  public static final String SINAL_MACD_DIARIO_VALID_011 = "SINAL_MACD_DIARIO_VALID_011";

  @Override
  public void load() {
    Fixture.of(SinalMacdDiario.class)
        .addTemplate(SINAL_MACD_DIARIO_VALID_001,
            new Rule() {{
              add("idSinalMacdDiario", random(Long.class, range(1L, 200L)));
              add("dtpreg", LocalDate.of(1978, 2, 16));
              add("sinalMacd", one(SinalMacd.class, SINAL_MACD_VALID_001));
            }})
        .addTemplate(SINAL_MACD_DIARIO_VALID_002, new Rule() {{
          add("idSinalMacdDiario", random(Long.class, range(1L, 200L)));
          add("dtpreg", LocalDate.of(1978, 2, 17));
          add("sinalMacd", one(SinalMacd.class, SINAL_MACD_VALID_002));
        }})
        .addTemplate(SINAL_MACD_DIARIO_VALID_003, new Rule() {{
          add("idSinalMacdDiario", random(Long.class, range(1L, 200L)));
          add("dtpreg", LocalDate.of(1978, 2, 18));
          add("sinalMacd", one(SinalMacd.class, SINAL_MACD_VALID_003));
        }})
        .addTemplate(SINAL_MACD_DIARIO_VALID_004, new Rule() {{
          add("idSinalMacdDiario", random(Long.class, range(1L, 200L)));
          add("dtpreg", LocalDate.of(1978, 2, 19));
          add("sinalMacd", one(SinalMacd.class, SINAL_MACD_VALID_004));
        }})
        .addTemplate(SINAL_MACD_DIARIO_VALID_005, new Rule() {{
          add("idSinalMacdDiario", random(Long.class, range(1L, 200L)));
          add("dtpreg", LocalDate.of(1978, 2, 20));
          add("sinalMacd", one(SinalMacd.class, SINAL_MACD_VALID_005));
        }})
        .addTemplate(SINAL_MACD_DIARIO_VALID_006, new Rule() {{
          add("idSinalMacdDiario", random(Long.class, range(1L, 200L)));
          add("dtpreg", LocalDate.of(1978, 2, 21));
          add("sinalMacd", one(SinalMacd.class, SINAL_MACD_VALID_006));
        }})
        .addTemplate(SINAL_MACD_DIARIO_VALID_007, new Rule() {{
          add("idSinalMacdDiario", random(Long.class, range(1L, 200L)));
          add("dtpreg", LocalDate.of(1978, 2, 22));
          add("sinalMacd", one(SinalMacd.class, SINAL_MACD_VALID_007));
        }})
        .addTemplate(SINAL_MACD_DIARIO_VALID_008, new Rule() {{
          add("idSinalMacdDiario", random(Long.class, range(1L, 200L)));
          add("dtpreg", LocalDate.of(1978, 2, 23));
          add("sinalMacd", one(SinalMacd.class, SINAL_MACD_VALID_008));
        }})
        .addTemplate(SINAL_MACD_DIARIO_VALID_009, new Rule() {{
          add("idSinalMacdDiario", random(Long.class, range(1L, 200L)));
          add("dtpreg", LocalDate.of(1978, 2, 24));
          add("sinalMacd", one(SinalMacd.class, SINAL_MACD_VALID_009));
        }})
        .addTemplate(SINAL_MACD_DIARIO_VALID_010, new Rule() {{
          add("idSinalMacdDiario", random(Long.class, range(1L, 200L)));
          add("dtpreg", LocalDate.of(1978, 2, 25));
          add("sinalMacd", one(SinalMacd.class, SINAL_MACD_VALID_010));
        }})
        .addTemplate(SINAL_MACD_DIARIO_VALID_011, new Rule() {{
          add("idSinalMacdDiario", random(Long.class, range(1L, 200L)));
          add("dtpreg", LocalDate.of(1978, 2, 26));
          add("sinalMacd", one(SinalMacd.class, SINAL_MACD_VALID_011));
        }});
  }
}
