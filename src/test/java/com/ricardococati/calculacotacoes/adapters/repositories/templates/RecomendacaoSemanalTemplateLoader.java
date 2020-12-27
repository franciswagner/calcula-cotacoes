package com.ricardococati.calculacotacoes.adapters.repositories.templates;

import static com.ricardococati.calculacotacoes.adapters.repositories.templates.RecomendacaoTemplateLoader.RECOMENDACAO_VALID_001;
import static com.ricardococati.calculacotacoes.adapters.repositories.templates.RecomendacaoTemplateLoader.RECOMENDACAO_VALID_002;
import static com.ricardococati.calculacotacoes.adapters.repositories.templates.RecomendacaoTemplateLoader.RECOMENDACAO_VALID_003;
import static com.ricardococati.calculacotacoes.adapters.repositories.templates.RecomendacaoTemplateLoader.RECOMENDACAO_VALID_004;
import static com.ricardococati.calculacotacoes.adapters.repositories.templates.RecomendacaoTemplateLoader.RECOMENDACAO_VALID_005;
import static com.ricardococati.calculacotacoes.adapters.repositories.templates.RecomendacaoTemplateLoader.RECOMENDACAO_VALID_006;
import static com.ricardococati.calculacotacoes.adapters.repositories.templates.RecomendacaoTemplateLoader.RECOMENDACAO_VALID_007;
import static com.ricardococati.calculacotacoes.adapters.repositories.templates.RecomendacaoTemplateLoader.RECOMENDACAO_VALID_008;
import static com.ricardococati.calculacotacoes.adapters.repositories.templates.RecomendacaoTemplateLoader.RECOMENDACAO_VALID_009;
import static com.ricardococati.calculacotacoes.adapters.repositories.templates.RecomendacaoTemplateLoader.RECOMENDACAO_VALID_010;
import static com.ricardococati.calculacotacoes.adapters.repositories.templates.RecomendacaoTemplateLoader.RECOMENDACAO_VALID_011;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;
import com.ricardococati.calculacotacoes.entities.domains.recomendacao.Recomendacao;
import com.ricardococati.calculacotacoes.entities.domains.recomendacao.RecomendacaoSemanal;
import java.time.LocalDate;

public class RecomendacaoSemanalTemplateLoader implements TemplateLoader {

  public static final String RECOMENDACAO_SEMANAL_VALID_001 = "RECOMENDACAO_SEMANAL_VALID_001";
  public static final String RECOMENDACAO_SEMANAL_VALID_002 = "RECOMENDACAO_SEMANAL_VALID_002";
  public static final String RECOMENDACAO_SEMANAL_VALID_003 = "RECOMENDACAO_SEMANAL_VALID_003";
  public static final String RECOMENDACAO_SEMANAL_VALID_004 = "RECOMENDACAO_SEMANAL_VALID_004";
  public static final String RECOMENDACAO_SEMANAL_VALID_005 = "RECOMENDACAO_SEMANAL_VALID_005";
  public static final String RECOMENDACAO_SEMANAL_VALID_006 = "RECOMENDACAO_SEMANAL_VALID_006";
  public static final String RECOMENDACAO_SEMANAL_VALID_007 = "RECOMENDACAO_SEMANAL_VALID_007";
  public static final String RECOMENDACAO_SEMANAL_VALID_008 = "RECOMENDACAO_SEMANAL_VALID_008";
  public static final String RECOMENDACAO_SEMANAL_VALID_009 = "RECOMENDACAO_SEMANAL_VALID_009";
  public static final String RECOMENDACAO_SEMANAL_VALID_010 = "RECOMENDACAO_SEMANAL_VALID_010";
  public static final String RECOMENDACAO_SEMANAL_VALID_011 = "RECOMENDACAO_SEMANAL_VALID_011";
  private LocalDate localDate = LocalDate.of(1978, 2, 16);

  @Override
  public void load() {
    Fixture.of(RecomendacaoSemanal.class)
        .addTemplate(RECOMENDACAO_SEMANAL_VALID_001,
            new Rule() {{
              add("idRecomendacaoSemanal", random(Long.class, range(1L, 200L)));
              add("dtpregini", localDate);
              add("dtpregfim", localDate.plusDays(2));
              add("recomendacao", one(Recomendacao.class, RECOMENDACAO_VALID_001));
            }})
        .addTemplate(RECOMENDACAO_SEMANAL_VALID_002, new Rule() {{
          add("idRecomendacaoSemanal", random(Long.class, range(1L, 200L)));
          add("dtpregini", localDate.plusDays(3));
          add("dtpregfim", localDate.plusDays(4));
          add("recomendacao", one(Recomendacao.class, RECOMENDACAO_VALID_002));
        }})
        .addTemplate(RECOMENDACAO_SEMANAL_VALID_003, new Rule() {{
          add("idRecomendacaoSemanal", random(Long.class, range(1L, 200L)));
          add("dtpregini", localDate.plusDays(5));
          add("dtpregfim", localDate.plusDays(6));
          add("recomendacao", one(Recomendacao.class, RECOMENDACAO_VALID_003));
        }})
        .addTemplate(RECOMENDACAO_SEMANAL_VALID_004, new Rule() {{
          add("idRecomendacaoSemanal", random(Long.class, range(1L, 200L)));
          add("dtpregini", localDate.plusDays(7));
          add("dtpregfim", localDate.plusDays(8));
          add("recomendacao", one(Recomendacao.class, RECOMENDACAO_VALID_004));
        }})
        .addTemplate(RECOMENDACAO_SEMANAL_VALID_005, new Rule() {{
          add("idRecomendacaoSemanal", random(Long.class, range(1L, 200L)));
          add("dtpregini", localDate.plusDays(9));
          add("dtpregfim", localDate.plusDays(10));
          add("recomendacao", one(Recomendacao.class, RECOMENDACAO_VALID_005));
        }})
        .addTemplate(RECOMENDACAO_SEMANAL_VALID_006, new Rule() {{
          add("idRecomendacaoSemanal", random(Long.class, range(1L, 200L)));
          add("dtpregini", localDate.plusDays(11));
          add("dtpregfim", localDate.plusDays(12));
          add("recomendacao", one(Recomendacao.class, RECOMENDACAO_VALID_006));
        }})
        .addTemplate(RECOMENDACAO_SEMANAL_VALID_007, new Rule() {{
          add("idRecomendacaoSemanal", random(Long.class, range(1L, 200L)));
          add("dtpregini", localDate.plusDays(13));
          add("dtpregfim", localDate.plusDays(14));
          add("recomendacao", one(Recomendacao.class, RECOMENDACAO_VALID_007));
        }})
        .addTemplate(RECOMENDACAO_SEMANAL_VALID_008, new Rule() {{
          add("idRecomendacaoSemanal", random(Long.class, range(1L, 200L)));
          add("dtpregini", localDate.plusDays(15));
          add("dtpregfim", localDate.plusDays(16));
          add("recomendacao", one(Recomendacao.class, RECOMENDACAO_VALID_008));
        }})
        .addTemplate(RECOMENDACAO_SEMANAL_VALID_009, new Rule() {{
          add("idRecomendacaoSemanal", random(Long.class, range(1L, 200L)));
          add("dtpregini", localDate.plusDays(17));
          add("dtpregfim", localDate.plusDays(18));
          add("recomendacao", one(Recomendacao.class, RECOMENDACAO_VALID_009));
        }})
        .addTemplate(RECOMENDACAO_SEMANAL_VALID_010, new Rule() {{
          add("idRecomendacaoSemanal", random(Long.class, range(1L, 200L)));
          add("dtpregini", localDate.plusDays(19));
          add("dtpregfim", localDate.plusDays(20));
          add("recomendacao", one(Recomendacao.class, RECOMENDACAO_VALID_010));
        }})
        .addTemplate(RECOMENDACAO_SEMANAL_VALID_011, new Rule() {{
          add("idRecomendacaoSemanal", random(Long.class, range(1L, 200L)));
          add("dtpregini", localDate.plusDays(21));
          add("dtpregfim", localDate.plusDays(22));
          add("recomendacao", one(Recomendacao.class, RECOMENDACAO_VALID_011));
        }});
  }
}
