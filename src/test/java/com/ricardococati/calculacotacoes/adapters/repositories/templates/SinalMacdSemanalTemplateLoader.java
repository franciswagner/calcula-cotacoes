package com.ricardococati.calculacotacoes.adapters.repositories.templates;

import static com.ricardococati.calculacotacoes.adapters.repositories.templates.SinalMacdTemplateLoader.SINAL_MACD_VALID_001;
import static com.ricardococati.calculacotacoes.adapters.repositories.templates.SinalMacdTemplateLoader.SINAL_MACD_VALID_002;
import static com.ricardococati.calculacotacoes.adapters.repositories.templates.SinalMacdTemplateLoader.SINAL_MACD_VALID_003;
import static com.ricardococati.calculacotacoes.adapters.repositories.templates.SinalMacdTemplateLoader.SINAL_MACD_VALID_004;
import static com.ricardococati.calculacotacoes.adapters.repositories.templates.SinalMacdTemplateLoader.SINAL_MACD_VALID_005;
import static com.ricardococati.calculacotacoes.adapters.repositories.templates.SinalMacdTemplateLoader.SINAL_MACD_VALID_006;
import static com.ricardococati.calculacotacoes.adapters.repositories.templates.SinalMacdTemplateLoader.SINAL_MACD_VALID_007;
import static com.ricardococati.calculacotacoes.adapters.repositories.templates.SinalMacdTemplateLoader.SINAL_MACD_VALID_008;
import static com.ricardococati.calculacotacoes.adapters.repositories.templates.SinalMacdTemplateLoader.SINAL_MACD_VALID_009;
import static com.ricardococati.calculacotacoes.adapters.repositories.templates.SinalMacdTemplateLoader.SINAL_MACD_VALID_010;
import static com.ricardococati.calculacotacoes.adapters.repositories.templates.SinalMacdTemplateLoader.SINAL_MACD_VALID_011;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;
import com.ricardococati.calculacotacoes.entities.domains.sinalmacd.SinalMacd;
import com.ricardococati.calculacotacoes.entities.domains.sinalmacd.SinalMacdSemanal;
import java.time.LocalDate;

public class SinalMacdSemanalTemplateLoader implements TemplateLoader {

  public static final String SINAL_MACD_SEMANAL_VALID_001 = "SINAL_MACD_SEMANAL_VALID_001";
  public static final String SINAL_MACD_SEMANAL_VALID_002 = "SINAL_MACD_SEMANAL_VALID_002";
  public static final String SINAL_MACD_SEMANAL_VALID_003 = "SINAL_MACD_SEMANAL_VALID_003";
  public static final String SINAL_MACD_SEMANAL_VALID_004 = "SINAL_MACD_SEMANAL_VALID_004";
  public static final String SINAL_MACD_SEMANAL_VALID_005 = "SINAL_MACD_SEMANAL_VALID_005";
  public static final String SINAL_MACD_SEMANAL_VALID_006 = "SINAL_MACD_SEMANAL_VALID_006";
  public static final String SINAL_MACD_SEMANAL_VALID_007 = "SINAL_MACD_SEMANAL_VALID_007";
  public static final String SINAL_MACD_SEMANAL_VALID_008 = "SINAL_MACD_SEMANAL_VALID_008";
  public static final String SINAL_MACD_SEMANAL_VALID_009 = "SINAL_MACD_SEMANAL_VALID_009";
  public static final String SINAL_MACD_SEMANAL_VALID_010 = "SINAL_MACD_SEMANAL_VALID_010";
  public static final String SINAL_MACD_SEMANAL_VALID_011 = "SINAL_MACD_SEMANAL_VALID_011";
  private LocalDate localDate = LocalDate.of(1978, 2, 16);

  @Override
  public void load() {
    Fixture.of(SinalMacdSemanal.class)
        .addTemplate(SINAL_MACD_SEMANAL_VALID_001,
            new Rule() {{
              add("idSinalMacdSemanal", random(Long.class, range(1L, 200L)));
              add("dtpregini", localDate);
              add("dtpregfim", localDate.plusDays(2));
              add("sinalMacd", one(SinalMacd.class, SINAL_MACD_VALID_001));
            }})
        .addTemplate(SINAL_MACD_SEMANAL_VALID_002, new Rule() {{
          add("idSinalMacdSemanal", random(Long.class, range(1L, 200L)));
          add("dtpregini", localDate.plusDays(3));
          add("dtpregfim", localDate.plusDays(4));
          add("sinalMacd", one(SinalMacd.class, SINAL_MACD_VALID_002));
        }})
        .addTemplate(SINAL_MACD_SEMANAL_VALID_003, new Rule() {{
          add("idSinalMacdSemanal", random(Long.class, range(1L, 200L)));
          add("dtpregini", localDate.plusDays(5));
          add("dtpregfim", localDate.plusDays(6));
          add("sinalMacd", one(SinalMacd.class, SINAL_MACD_VALID_003));
        }})
        .addTemplate(SINAL_MACD_SEMANAL_VALID_004, new Rule() {{
          add("idSinalMacdSemanal", random(Long.class, range(1L, 200L)));
          add("dtpregini", localDate.plusDays(7));
          add("dtpregfim", localDate.plusDays(8));
          add("sinalMacd", one(SinalMacd.class, SINAL_MACD_VALID_004));
        }})
        .addTemplate(SINAL_MACD_SEMANAL_VALID_005, new Rule() {{
          add("idSinalMacdSemanal", random(Long.class, range(1L, 200L)));
          add("dtpregini", localDate.plusDays(9));
          add("dtpregfim", localDate.plusDays(10));
          add("sinalMacd", one(SinalMacd.class, SINAL_MACD_VALID_005));
        }})
        .addTemplate(SINAL_MACD_SEMANAL_VALID_006, new Rule() {{
          add("idSinalMacdSemanal", random(Long.class, range(1L, 200L)));
          add("dtpregini", localDate.plusDays(11));
          add("dtpregfim", localDate.plusDays(12));
          add("sinalMacd", one(SinalMacd.class, SINAL_MACD_VALID_006));
        }})
        .addTemplate(SINAL_MACD_SEMANAL_VALID_007, new Rule() {{
          add("idSinalMacdSemanal", random(Long.class, range(1L, 200L)));
          add("dtpregini", localDate.plusDays(13));
          add("dtpregfim", localDate.plusDays(14));
          add("sinalMacd", one(SinalMacd.class, SINAL_MACD_VALID_007));
        }})
        .addTemplate(SINAL_MACD_SEMANAL_VALID_008, new Rule() {{
          add("idSinalMacdSemanal", random(Long.class, range(1L, 200L)));
          add("dtpregini", localDate.plusDays(15));
          add("dtpregfim", localDate.plusDays(16));
          add("sinalMacd", one(SinalMacd.class, SINAL_MACD_VALID_008));
        }})
        .addTemplate(SINAL_MACD_SEMANAL_VALID_009, new Rule() {{
          add("idSinalMacdSemanal", random(Long.class, range(1L, 200L)));
          add("dtpregini", localDate.plusDays(17));
          add("dtpregfim", localDate.plusDays(18));
          add("sinalMacd", one(SinalMacd.class, SINAL_MACD_VALID_009));
        }})
        .addTemplate(SINAL_MACD_SEMANAL_VALID_010, new Rule() {{
          add("idSinalMacdSemanal", random(Long.class, range(1L, 200L)));
          add("dtpregini", localDate.plusDays(19));
          add("dtpregfim", localDate.plusDays(20));
          add("sinalMacd", one(SinalMacd.class, SINAL_MACD_VALID_010));
        }})
        .addTemplate(SINAL_MACD_SEMANAL_VALID_011, new Rule() {{
          add("idSinalMacdSemanal", random(Long.class, range(1L, 200L)));
          add("dtpregini", localDate.plusDays(21));
          add("dtpregfim", localDate.plusDays(22));
          add("sinalMacd", one(SinalMacd.class, SINAL_MACD_VALID_011));
        }});
  }
}
