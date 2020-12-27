package com.ricardococati.calculacotacoes.adapters.repositories.templates;

import static com.ricardococati.calculacotacoes.adapters.repositories.templates.HistogramaTemplateLoader.HISTOGRAMA_VALID_001;
import static com.ricardococati.calculacotacoes.adapters.repositories.templates.HistogramaTemplateLoader.HISTOGRAMA_VALID_002;
import static com.ricardococati.calculacotacoes.adapters.repositories.templates.HistogramaTemplateLoader.HISTOGRAMA_VALID_003;
import static com.ricardococati.calculacotacoes.adapters.repositories.templates.HistogramaTemplateLoader.HISTOGRAMA_VALID_004;
import static com.ricardococati.calculacotacoes.adapters.repositories.templates.HistogramaTemplateLoader.HISTOGRAMA_VALID_005;
import static com.ricardococati.calculacotacoes.adapters.repositories.templates.HistogramaTemplateLoader.HISTOGRAMA_VALID_006;
import static com.ricardococati.calculacotacoes.adapters.repositories.templates.HistogramaTemplateLoader.HISTOGRAMA_VALID_007;
import static com.ricardococati.calculacotacoes.adapters.repositories.templates.HistogramaTemplateLoader.HISTOGRAMA_VALID_008;
import static com.ricardococati.calculacotacoes.adapters.repositories.templates.HistogramaTemplateLoader.HISTOGRAMA_VALID_009;
import static com.ricardococati.calculacotacoes.adapters.repositories.templates.HistogramaTemplateLoader.HISTOGRAMA_VALID_010;
import static com.ricardococati.calculacotacoes.adapters.repositories.templates.HistogramaTemplateLoader.HISTOGRAMA_VALID_011;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;
import com.ricardococati.calculacotacoes.entities.domains.histograma.Histograma;
import com.ricardococati.calculacotacoes.entities.domains.histograma.HistogramaSemanal;
import java.time.LocalDate;

public class HistogramaSemanalTemplateLoader implements TemplateLoader {

  public static final String HISTOGRAMA_SEMANAL_VALID_001 = "HISTOGRAMA_SEMANAL_VALID_001";
  public static final String HISTOGRAMA_SEMANAL_VALID_002 = "HISTOGRAMA_SEMANAL_VALID_002";
  public static final String HISTOGRAMA_SEMANAL_VALID_003 = "HISTOGRAMA_SEMANAL_VALID_003";
  public static final String HISTOGRAMA_SEMANAL_VALID_004 = "HISTOGRAMA_SEMANAL_VALID_004";
  public static final String HISTOGRAMA_SEMANAL_VALID_005 = "HISTOGRAMA_SEMANAL_VALID_005";
  public static final String HISTOGRAMA_SEMANAL_VALID_006 = "HISTOGRAMA_SEMANAL_VALID_006";
  public static final String HISTOGRAMA_SEMANAL_VALID_007 = "HISTOGRAMA_SEMANAL_VALID_007";
  public static final String HISTOGRAMA_SEMANAL_VALID_008 = "HISTOGRAMA_SEMANAL_VALID_008";
  public static final String HISTOGRAMA_SEMANAL_VALID_009 = "HISTOGRAMA_SEMANAL_VALID_009";
  public static final String HISTOGRAMA_SEMANAL_VALID_010 = "HISTOGRAMA_SEMANAL_VALID_010";
  public static final String HISTOGRAMA_SEMANAL_VALID_011 = "HISTOGRAMA_SEMANAL_VALID_011";
  private LocalDate localDate = LocalDate.of(1978, 2, 16);

  @Override
  public void load() {
    Fixture.of(HistogramaSemanal.class)
        .addTemplate(HISTOGRAMA_SEMANAL_VALID_001,
            new Rule() {{
              add("idHistogramaSemanal", random(Long.class, range(1L, 200L)));
              add("dtpregini", localDate);
              add("dtpregfim", localDate.plusDays(2));
              add("histograma", one(Histograma.class, HISTOGRAMA_VALID_001));
            }})
        .addTemplate(HISTOGRAMA_SEMANAL_VALID_002, new Rule() {{
          add("idHistogramaSemanal", random(Long.class, range(1L, 200L)));
          add("dtpregini", localDate.plusDays(2));
          add("dtpregfim", localDate.plusDays(3));
          add("histograma", one(Histograma.class, HISTOGRAMA_VALID_002));
        }})
        .addTemplate(HISTOGRAMA_SEMANAL_VALID_003, new Rule() {{
          add("idHistogramaSemanal", random(Long.class, range(1L, 200L)));
          add("dtpregini", localDate.plusDays(4));
          add("dtpregfim", localDate.plusDays(5));
          add("histograma", one(Histograma.class, HISTOGRAMA_VALID_003));
        }})
        .addTemplate(HISTOGRAMA_SEMANAL_VALID_004, new Rule() {{
          add("idHistogramaSemanal", random(Long.class, range(1L, 200L)));
          add("dtpregini", localDate.plusDays(6));
          add("dtpregfim", localDate.plusDays(7));
          add("histograma", one(Histograma.class, HISTOGRAMA_VALID_004));
        }})
        .addTemplate(HISTOGRAMA_SEMANAL_VALID_005, new Rule() {{
          add("idHistogramaSemanal", random(Long.class, range(1L, 200L)));
          add("dtpregini", localDate.plusDays(8));
          add("dtpregfim", localDate.plusDays(9));
          add("histograma", one(Histograma.class, HISTOGRAMA_VALID_005));
        }})
        .addTemplate(HISTOGRAMA_SEMANAL_VALID_006, new Rule() {{
          add("idHistogramaSemanal", random(Long.class, range(1L, 200L)));
          add("dtpregini", localDate.plusDays(10));
          add("dtpregfim", localDate.plusDays(11));
          add("histograma", one(Histograma.class, HISTOGRAMA_VALID_006));
        }})
        .addTemplate(HISTOGRAMA_SEMANAL_VALID_007, new Rule() {{
          add("idHistogramaSemanal", random(Long.class, range(1L, 200L)));
          add("dtpregini", localDate.plusDays(12));
          add("dtpregfim", localDate.plusDays(13));
          add("histograma", one(Histograma.class, HISTOGRAMA_VALID_007));
        }})
        .addTemplate(HISTOGRAMA_SEMANAL_VALID_008, new Rule() {{
          add("idHistogramaSemanal", random(Long.class, range(1L, 200L)));
          add("dtpregini", localDate.plusDays(14));
          add("dtpregfim", localDate.plusDays(15));
          add("histograma", one(Histograma.class, HISTOGRAMA_VALID_008));
        }})
        .addTemplate(HISTOGRAMA_SEMANAL_VALID_009, new Rule() {{
          add("idHistogramaSemanal", random(Long.class, range(1L, 200L)));
          add("dtpregini", localDate.plusDays(16));
          add("dtpregfim", localDate.plusDays(17));
          add("histograma", one(Histograma.class, HISTOGRAMA_VALID_009));
        }})
        .addTemplate(HISTOGRAMA_SEMANAL_VALID_010, new Rule() {{
          add("idHistogramaSemanal", random(Long.class, range(1L, 200L)));
          add("dtpregini", localDate.plusDays(18));
          add("dtpregfim", localDate.plusDays(19));
          add("histograma", one(Histograma.class, HISTOGRAMA_VALID_010));
        }})
        .addTemplate(HISTOGRAMA_SEMANAL_VALID_011, new Rule() {{
          add("idHistogramaSemanal", random(Long.class, range(1L, 200L)));
          add("dtpregini", localDate.plusDays(20));
          add("dtpregfim", localDate.plusDays(21));
          add("histograma", one(Histograma.class, HISTOGRAMA_VALID_011));
        }});
  }
}
