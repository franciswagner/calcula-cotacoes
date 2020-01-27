package com.ricardococati.repository.dao.templates;

import static com.ricardococati.repository.dao.templates.HistogramaTemplateLoader.HISTOGRAMA_VALID_001;
import static com.ricardococati.repository.dao.templates.HistogramaTemplateLoader.HISTOGRAMA_VALID_002;
import static com.ricardococati.repository.dao.templates.HistogramaTemplateLoader.HISTOGRAMA_VALID_003;
import static com.ricardococati.repository.dao.templates.HistogramaTemplateLoader.HISTOGRAMA_VALID_004;
import static com.ricardococati.repository.dao.templates.HistogramaTemplateLoader.HISTOGRAMA_VALID_005;
import static com.ricardococati.repository.dao.templates.HistogramaTemplateLoader.HISTOGRAMA_VALID_006;
import static com.ricardococati.repository.dao.templates.HistogramaTemplateLoader.HISTOGRAMA_VALID_007;
import static com.ricardococati.repository.dao.templates.HistogramaTemplateLoader.HISTOGRAMA_VALID_008;
import static com.ricardococati.repository.dao.templates.HistogramaTemplateLoader.HISTOGRAMA_VALID_009;
import static com.ricardococati.repository.dao.templates.HistogramaTemplateLoader.HISTOGRAMA_VALID_010;
import static com.ricardococati.repository.dao.templates.HistogramaTemplateLoader.HISTOGRAMA_VALID_011;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;
import com.ricardococati.model.dto.Histograma;
import com.ricardococati.model.dto.HistogramaDiario;
import java.time.LocalDate;

public class HistogramaDiarioTemplateLoader implements TemplateLoader {

  public static final String HISTOGRAMA_DIARIO_VALID_001 = "HISTOGRAMA_DIARIO_VALID_001";
  public static final String HISTOGRAMA_DIARIO_VALID_002 = "HISTOGRAMA_DIARIO_VALID_002";
  public static final String HISTOGRAMA_DIARIO_VALID_003 = "HISTOGRAMA_DIARIO_VALID_003";
  public static final String HISTOGRAMA_DIARIO_VALID_004 = "HISTOGRAMA_DIARIO_VALID_004";
  public static final String HISTOGRAMA_DIARIO_VALID_005 = "HISTOGRAMA_DIARIO_VALID_005";
  public static final String HISTOGRAMA_DIARIO_VALID_006 = "HISTOGRAMA_DIARIO_VALID_006";
  public static final String HISTOGRAMA_DIARIO_VALID_007 = "HISTOGRAMA_DIARIO_VALID_007";
  public static final String HISTOGRAMA_DIARIO_VALID_008 = "HISTOGRAMA_DIARIO_VALID_008";
  public static final String HISTOGRAMA_DIARIO_VALID_009 = "HISTOGRAMA_DIARIO_VALID_009";
  public static final String HISTOGRAMA_DIARIO_VALID_010 = "HISTOGRAMA_DIARIO_VALID_010";
  public static final String HISTOGRAMA_DIARIO_VALID_011 = "HISTOGRAMA_DIARIO_VALID_011";

  @Override
  public void load() {
    Fixture.of(HistogramaDiario.class)
        .addTemplate(HISTOGRAMA_DIARIO_VALID_001,
            new Rule() {{
              add("idHistogramaDiario", random(Long.class, range(1L, 200L)));
              add("dtpreg", LocalDate.of(1978, 2, 16));
              add("histograma", one(Histograma.class, HISTOGRAMA_VALID_001));
            }})
        .addTemplate(HISTOGRAMA_DIARIO_VALID_002, new Rule() {{
          add("idHistogramaDiario", random(Long.class, range(1L, 200L)));
          add("dtpreg", LocalDate.of(1978, 2, 17));
          add("histograma", one(Histograma.class, HISTOGRAMA_VALID_002));
        }})
        .addTemplate(HISTOGRAMA_DIARIO_VALID_003, new Rule() {{
          add("idHistogramaDiario", random(Long.class, range(1L, 200L)));
          add("dtpreg", LocalDate.of(1978, 2, 18));
          add("histograma", one(Histograma.class, HISTOGRAMA_VALID_003));
        }})
        .addTemplate(HISTOGRAMA_DIARIO_VALID_004, new Rule() {{
          add("idHistogramaDiario", random(Long.class, range(1L, 200L)));
          add("dtpreg", LocalDate.of(1978, 2, 19));
          add("histograma", one(Histograma.class, HISTOGRAMA_VALID_004));
        }})
        .addTemplate(HISTOGRAMA_DIARIO_VALID_005, new Rule() {{
          add("idHistogramaDiario", random(Long.class, range(1L, 200L)));
          add("dtpreg", LocalDate.of(1978, 2, 20));
          add("histograma", one(Histograma.class, HISTOGRAMA_VALID_005));
        }})
        .addTemplate(HISTOGRAMA_DIARIO_VALID_006, new Rule() {{
          add("idHistogramaDiario", random(Long.class, range(1L, 200L)));
          add("dtpreg", LocalDate.of(1978, 2, 21));
          add("histograma", one(Histograma.class, HISTOGRAMA_VALID_006));
        }})
        .addTemplate(HISTOGRAMA_DIARIO_VALID_007, new Rule() {{
          add("idHistogramaDiario", random(Long.class, range(1L, 200L)));
          add("dtpreg", LocalDate.of(1978, 2, 22));
          add("histograma", one(Histograma.class, HISTOGRAMA_VALID_007));
        }})
        .addTemplate(HISTOGRAMA_DIARIO_VALID_008, new Rule() {{
          add("idHistogramaDiario", random(Long.class, range(1L, 200L)));
          add("dtpreg", LocalDate.of(1978, 2, 23));
          add("histograma", one(Histograma.class, HISTOGRAMA_VALID_008));
        }})
        .addTemplate(HISTOGRAMA_DIARIO_VALID_009, new Rule() {{
          add("idHistogramaDiario", random(Long.class, range(1L, 200L)));
          add("dtpreg", LocalDate.of(1978, 2, 24));
          add("histograma", one(Histograma.class, HISTOGRAMA_VALID_009));
        }})
        .addTemplate(HISTOGRAMA_DIARIO_VALID_010, new Rule() {{
          add("idHistogramaDiario", random(Long.class, range(1L, 200L)));
          add("dtpreg", LocalDate.of(1978, 2, 25));
          add("histograma", one(Histograma.class, HISTOGRAMA_VALID_010));
        }})
        .addTemplate(HISTOGRAMA_DIARIO_VALID_011, new Rule() {{
          add("idHistogramaDiario", random(Long.class, range(1L, 200L)));
          add("dtpreg", LocalDate.of(1978, 2, 26));
          add("histograma", one(Histograma.class, HISTOGRAMA_VALID_011));
        }});
  }
}
