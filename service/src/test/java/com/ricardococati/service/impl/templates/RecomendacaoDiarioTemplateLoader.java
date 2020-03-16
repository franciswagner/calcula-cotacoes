package com.ricardococati.service.impl.templates;

import static com.ricardococati.service.impl.templates.RecomendacaoTemplateLoader.RECOMENDACAO_VALID_001;
import static com.ricardococati.service.impl.templates.RecomendacaoTemplateLoader.RECOMENDACAO_VALID_002;
import static com.ricardococati.service.impl.templates.RecomendacaoTemplateLoader.RECOMENDACAO_VALID_003;
import static com.ricardococati.service.impl.templates.RecomendacaoTemplateLoader.RECOMENDACAO_VALID_004;
import static com.ricardococati.service.impl.templates.RecomendacaoTemplateLoader.RECOMENDACAO_VALID_005;
import static com.ricardococati.service.impl.templates.RecomendacaoTemplateLoader.RECOMENDACAO_VALID_006;
import static com.ricardococati.service.impl.templates.RecomendacaoTemplateLoader.RECOMENDACAO_VALID_007;
import static com.ricardococati.service.impl.templates.RecomendacaoTemplateLoader.RECOMENDACAO_VALID_008;
import static com.ricardococati.service.impl.templates.RecomendacaoTemplateLoader.RECOMENDACAO_VALID_009;
import static com.ricardococati.service.impl.templates.RecomendacaoTemplateLoader.RECOMENDACAO_VALID_010;
import static com.ricardococati.service.impl.templates.RecomendacaoTemplateLoader.RECOMENDACAO_VALID_011;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;
import com.ricardococati.model.entities.Recomendacao;
import com.ricardococati.model.entities.RecomendacaoDiario;
import java.time.LocalDate;

public class RecomendacaoDiarioTemplateLoader implements TemplateLoader {

  public static final String RECOMENDACAO_DIARIO_VALID_001 = "RECOMENDACAO_DIARIO_VALID_001";
  public static final String RECOMENDACAO_DIARIO_VALID_002 = "RECOMENDACAO_DIARIO_VALID_002";
  public static final String RECOMENDACAO_DIARIO_VALID_003 = "RECOMENDACAO_DIARIO_VALID_003";
  public static final String RECOMENDACAO_DIARIO_VALID_004 = "RECOMENDACAO_DIARIO_VALID_004";
  public static final String RECOMENDACAO_DIARIO_VALID_005 = "RECOMENDACAO_DIARIO_VALID_005";
  public static final String RECOMENDACAO_DIARIO_VALID_006 = "RECOMENDACAO_DIARIO_VALID_006";
  public static final String RECOMENDACAO_DIARIO_VALID_007 = "RECOMENDACAO_DIARIO_VALID_007";
  public static final String RECOMENDACAO_DIARIO_VALID_008 = "RECOMENDACAO_DIARIO_VALID_008";
  public static final String RECOMENDACAO_DIARIO_VALID_009 = "RECOMENDACAO_DIARIO_VALID_009";
  public static final String RECOMENDACAO_DIARIO_VALID_010 = "RECOMENDACAO_DIARIO_VALID_010";
  public static final String RECOMENDACAO_DIARIO_VALID_011 = "RECOMENDACAO_DIARIO_VALID_011";

  @Override
  public void load() {
    Fixture.of(RecomendacaoDiario.class)
        .addTemplate(RECOMENDACAO_DIARIO_VALID_001,
            new Rule() {{
              add("idRecomendacaoDiario", random(Long.class, range(1L, 200L)));
              add("dtpreg", LocalDate.of(1978, 2, 16));
              add("recomendacao", one(Recomendacao.class, RECOMENDACAO_VALID_001));
            }})
        .addTemplate(RECOMENDACAO_DIARIO_VALID_002, new Rule() {{
          add("idRecomendacaoDiario", random(Long.class, range(1L, 200L)));
          add("dtpreg", LocalDate.of(1978, 2, 17));
          add("recomendacao", one(Recomendacao.class, RECOMENDACAO_VALID_002));
        }})
        .addTemplate(RECOMENDACAO_DIARIO_VALID_003, new Rule() {{
          add("idRecomendacaoDiario", random(Long.class, range(1L, 200L)));
          add("dtpreg", LocalDate.of(1978, 2, 18));
          add("recomendacao", one(Recomendacao.class, RECOMENDACAO_VALID_003));
        }})
        .addTemplate(RECOMENDACAO_DIARIO_VALID_004, new Rule() {{
          add("idRecomendacaoDiario", random(Long.class, range(1L, 200L)));
          add("dtpreg", LocalDate.of(1978, 2, 19));
          add("recomendacao", one(Recomendacao.class, RECOMENDACAO_VALID_004));
        }})
        .addTemplate(RECOMENDACAO_DIARIO_VALID_005, new Rule() {{
          add("idRecomendacaoDiario", random(Long.class, range(1L, 200L)));
          add("dtpreg", LocalDate.of(1978, 2, 20));
          add("recomendacao", one(Recomendacao.class, RECOMENDACAO_VALID_005));
        }})
        .addTemplate(RECOMENDACAO_DIARIO_VALID_006, new Rule() {{
          add("idRecomendacaoDiario", random(Long.class, range(1L, 200L)));
          add("dtpreg", LocalDate.of(1978, 2, 21));
          add("recomendacao", one(Recomendacao.class, RECOMENDACAO_VALID_006));
        }})
        .addTemplate(RECOMENDACAO_DIARIO_VALID_007, new Rule() {{
          add("idRecomendacaoDiario", random(Long.class, range(1L, 200L)));
          add("dtpreg", LocalDate.of(1978, 2, 22));
          add("recomendacao", one(Recomendacao.class, RECOMENDACAO_VALID_007));
        }})
        .addTemplate(RECOMENDACAO_DIARIO_VALID_008, new Rule() {{
          add("idRecomendacaoDiario", random(Long.class, range(1L, 200L)));
          add("dtpreg", LocalDate.of(1978, 2, 23));
          add("recomendacao", one(Recomendacao.class, RECOMENDACAO_VALID_008));
        }})
        .addTemplate(RECOMENDACAO_DIARIO_VALID_009, new Rule() {{
          add("idRecomendacaoDiario", random(Long.class, range(1L, 200L)));
          add("dtpreg", LocalDate.of(1978, 2, 24));
          add("recomendacao", one(Recomendacao.class, RECOMENDACAO_VALID_009));
        }})
        .addTemplate(RECOMENDACAO_DIARIO_VALID_010, new Rule() {{
          add("idRecomendacaoDiario", random(Long.class, range(1L, 200L)));
          add("dtpreg", LocalDate.of(1978, 2, 25));
          add("recomendacao", one(Recomendacao.class, RECOMENDACAO_VALID_010));
        }})
        .addTemplate(RECOMENDACAO_DIARIO_VALID_011, new Rule() {{
          add("idRecomendacaoDiario", random(Long.class, range(1L, 200L)));
          add("dtpreg", LocalDate.of(1978, 2, 26));
          add("recomendacao", one(Recomendacao.class, RECOMENDACAO_VALID_011));
        }});
  }
}
