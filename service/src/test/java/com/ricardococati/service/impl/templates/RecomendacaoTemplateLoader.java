package com.ricardococati.service.impl.templates;

import static com.ricardococati.service.util.BigDecimalCustomizado.getDoubleValueBigDecimalHalfUpArredondado4Casas;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;
import com.ricardococati.model.dto.Recomendacao;
import com.ricardococati.service.util.BigDecimalCustomizado;

public class RecomendacaoTemplateLoader implements TemplateLoader {

  public static final String RECOMENDACAO_VALID_001 = "RECOMENDACAO_VALID_001";
  public static final String RECOMENDACAO_VALID_002 = "RECOMENDACAO_VALID_002";
  public static final String RECOMENDACAO_VALID_003 = "RECOMENDACAO_VALID_003";
  public static final String RECOMENDACAO_VALID_004 = "RECOMENDACAO_VALID_004";
  public static final String RECOMENDACAO_VALID_005 = "RECOMENDACAO_VALID_005";
  public static final String RECOMENDACAO_VALID_006 = "RECOMENDACAO_VALID_006";
  public static final String RECOMENDACAO_VALID_007 = "RECOMENDACAO_VALID_007";
  public static final String RECOMENDACAO_VALID_008 = "RECOMENDACAO_VALID_008";
  public static final String RECOMENDACAO_VALID_009 = "RECOMENDACAO_VALID_009";
  public static final String RECOMENDACAO_VALID_010 = "RECOMENDACAO_VALID_010";
  public static final String RECOMENDACAO_VALID_011 = "RECOMENDACAO_VALID_011";

  @Override
  public void load() {
    Fixture.of(Recomendacao.class)
        .addTemplate(RECOMENDACAO_VALID_001,
            new Rule() {{
              add("codneg", "MGLU3");
              add("precoFechamento", BigDecimalCustomizado
                  .getDoubleValueBigDecimalHalfUpArredondado4Casas(11.11));
              add("precoMME12p", BigDecimalCustomizado
                  .getDoubleValueBigDecimalHalfUpArredondado4Casas(11.75));
              add("precoMME26p", BigDecimalCustomizado
                  .getDoubleValueBigDecimalHalfUpArredondado4Casas(12.36));
              add("precoMacd", BigDecimalCustomizado
                  .getDoubleValueBigDecimalHalfUpArredondado4Casas(-0.61));
              add("precoSinalMacd", BigDecimalCustomizado
                  .getDoubleValueBigDecimalHalfUpArredondado4Casas(-0.48));
              add("precoHistograma", BigDecimalCustomizado
                  .getDoubleValueBigDecimalHalfUpArredondado4Casas(-0.13));
              add("decisao", "VENDE");
            }})
        .addTemplate(RECOMENDACAO_VALID_002).inherits(RECOMENDACAO_VALID_001,
        new Rule() {{
          add("precoFechamento", BigDecimalCustomizado
              .getDoubleValueBigDecimalHalfUpArredondado4Casas(11.05));
          add("precoMME12p", BigDecimalCustomizado.getDoubleValueBigDecimalHalfUpArredondado4Casas(11.64));
          add("precoMME26p", BigDecimalCustomizado.getDoubleValueBigDecimalHalfUpArredondado4Casas(12.27));
          add("precoMacd", BigDecimalCustomizado.getDoubleValueBigDecimalHalfUpArredondado4Casas(-0.63));
          add("precoSinalMacd", BigDecimalCustomizado
              .getDoubleValueBigDecimalHalfUpArredondado4Casas(-0.51));
          add("precoHistograma", BigDecimalCustomizado
              .getDoubleValueBigDecimalHalfUpArredondado4Casas(-0.12));
        }})
        .addTemplate(RECOMENDACAO_VALID_003).inherits(RECOMENDACAO_VALID_001,
        new Rule() {{
          add("precoFechamento", BigDecimalCustomizado
              .getDoubleValueBigDecimalHalfUpArredondado4Casas(11.05));
          add("precoMME12p", BigDecimalCustomizado.getDoubleValueBigDecimalHalfUpArredondado4Casas(11.64));
          add("precoMME26p", BigDecimalCustomizado.getDoubleValueBigDecimalHalfUpArredondado4Casas(12.27));
          add("precoMacd", BigDecimalCustomizado.getDoubleValueBigDecimalHalfUpArredondado4Casas(-0.63));
          add("precoSinalMacd", BigDecimalCustomizado
              .getDoubleValueBigDecimalHalfUpArredondado4Casas(-0.51));
          add("precoHistograma", BigDecimalCustomizado
              .getDoubleValueBigDecimalHalfUpArredondado4Casas(-0.12));
        }})
        .addTemplate(RECOMENDACAO_VALID_004).inherits(RECOMENDACAO_VALID_001,
        new Rule() {{
          add("precoFechamento", BigDecimalCustomizado
              .getDoubleValueBigDecimalHalfUpArredondado4Casas(11.05));
          add("precoMME12p", BigDecimalCustomizado.getDoubleValueBigDecimalHalfUpArredondado4Casas(11.64));
          add("precoMME26p", BigDecimalCustomizado.getDoubleValueBigDecimalHalfUpArredondado4Casas(12.27));
          add("precoMacd", BigDecimalCustomizado.getDoubleValueBigDecimalHalfUpArredondado4Casas(-0.63));
          add("precoSinalMacd", BigDecimalCustomizado
              .getDoubleValueBigDecimalHalfUpArredondado4Casas(-0.51));
          add("precoHistograma", BigDecimalCustomizado
              .getDoubleValueBigDecimalHalfUpArredondado4Casas(-0.12));
        }})
        .addTemplate(RECOMENDACAO_VALID_005).inherits(RECOMENDACAO_VALID_001,
        new Rule() {{
          add("precoFechamento", BigDecimalCustomizado
              .getDoubleValueBigDecimalHalfUpArredondado4Casas(11.05));
          add("precoMME12p", BigDecimalCustomizado.getDoubleValueBigDecimalHalfUpArredondado4Casas(11.64));
          add("precoMME26p", BigDecimalCustomizado.getDoubleValueBigDecimalHalfUpArredondado4Casas(12.27));
          add("precoMacd", BigDecimalCustomizado.getDoubleValueBigDecimalHalfUpArredondado4Casas(-0.63));
          add("precoSinalMacd", BigDecimalCustomizado
              .getDoubleValueBigDecimalHalfUpArredondado4Casas(-0.51));
          add("precoHistograma", BigDecimalCustomizado
              .getDoubleValueBigDecimalHalfUpArredondado4Casas(-0.12));
        }})
        .addTemplate(RECOMENDACAO_VALID_006).inherits(RECOMENDACAO_VALID_001,
        new Rule() {{
          add("precoFechamento", BigDecimalCustomizado
              .getDoubleValueBigDecimalHalfUpArredondado4Casas(11.05));
          add("precoMME12p", BigDecimalCustomizado.getDoubleValueBigDecimalHalfUpArredondado4Casas(11.64));
          add("precoMME26p", BigDecimalCustomizado.getDoubleValueBigDecimalHalfUpArredondado4Casas(12.27));
          add("precoMacd", BigDecimalCustomizado.getDoubleValueBigDecimalHalfUpArredondado4Casas(-0.63));
          add("precoSinalMacd", BigDecimalCustomizado
              .getDoubleValueBigDecimalHalfUpArredondado4Casas(-0.51));
          add("precoHistograma", BigDecimalCustomizado
              .getDoubleValueBigDecimalHalfUpArredondado4Casas(-0.12));
        }})
        .addTemplate(RECOMENDACAO_VALID_007).inherits(RECOMENDACAO_VALID_001,
        new Rule() {{
          add("precoFechamento", BigDecimalCustomizado
              .getDoubleValueBigDecimalHalfUpArredondado4Casas(11.05));
          add("precoMME12p", BigDecimalCustomizado.getDoubleValueBigDecimalHalfUpArredondado4Casas(11.64));
          add("precoMME26p", BigDecimalCustomizado.getDoubleValueBigDecimalHalfUpArredondado4Casas(12.27));
          add("precoMacd", BigDecimalCustomizado.getDoubleValueBigDecimalHalfUpArredondado4Casas(-0.63));
          add("precoSinalMacd", BigDecimalCustomizado
              .getDoubleValueBigDecimalHalfUpArredondado4Casas(-0.51));
          add("precoHistograma", BigDecimalCustomizado
              .getDoubleValueBigDecimalHalfUpArredondado4Casas(-0.12));
        }})
        .addTemplate(RECOMENDACAO_VALID_007).inherits(RECOMENDACAO_VALID_001,
        new Rule() {{
          add("precoFechamento", BigDecimalCustomizado
              .getDoubleValueBigDecimalHalfUpArredondado4Casas(11.05));
          add("precoMME12p", BigDecimalCustomizado.getDoubleValueBigDecimalHalfUpArredondado4Casas(11.64));
          add("precoMME26p", BigDecimalCustomizado.getDoubleValueBigDecimalHalfUpArredondado4Casas(12.27));
          add("precoMacd", BigDecimalCustomizado.getDoubleValueBigDecimalHalfUpArredondado4Casas(-0.63));
          add("precoSinalMacd", BigDecimalCustomizado
              .getDoubleValueBigDecimalHalfUpArredondado4Casas(-0.51));
          add("precoHistograma", BigDecimalCustomizado
              .getDoubleValueBigDecimalHalfUpArredondado4Casas(-0.12));
        }})
        .addTemplate(RECOMENDACAO_VALID_008).inherits(RECOMENDACAO_VALID_001,
        new Rule() {{
          add("precoFechamento", BigDecimalCustomizado
              .getDoubleValueBigDecimalHalfUpArredondado4Casas(11.05));
          add("precoMME12p", BigDecimalCustomizado.getDoubleValueBigDecimalHalfUpArredondado4Casas(11.64));
          add("precoMME26p", BigDecimalCustomizado.getDoubleValueBigDecimalHalfUpArredondado4Casas(12.27));
          add("precoMacd", BigDecimalCustomizado.getDoubleValueBigDecimalHalfUpArredondado4Casas(-0.63));
          add("precoSinalMacd", BigDecimalCustomizado
              .getDoubleValueBigDecimalHalfUpArredondado4Casas(-0.51));
          add("precoHistograma", BigDecimalCustomizado
              .getDoubleValueBigDecimalHalfUpArredondado4Casas(-0.12));
        }})
        .addTemplate(RECOMENDACAO_VALID_009).inherits(RECOMENDACAO_VALID_001,
        new Rule() {{
          add("precoFechamento", BigDecimalCustomizado
              .getDoubleValueBigDecimalHalfUpArredondado4Casas(11.05));
          add("precoMME12p", BigDecimalCustomizado.getDoubleValueBigDecimalHalfUpArredondado4Casas(11.64));
          add("precoMME26p", BigDecimalCustomizado.getDoubleValueBigDecimalHalfUpArredondado4Casas(12.27));
          add("precoMacd", BigDecimalCustomizado.getDoubleValueBigDecimalHalfUpArredondado4Casas(-0.63));
          add("precoSinalMacd", BigDecimalCustomizado
              .getDoubleValueBigDecimalHalfUpArredondado4Casas(-0.51));
          add("precoHistograma", BigDecimalCustomizado
              .getDoubleValueBigDecimalHalfUpArredondado4Casas(-0.12));
        }})
        .addTemplate(RECOMENDACAO_VALID_010).inherits(RECOMENDACAO_VALID_001,
        new Rule() {{
          add("precoFechamento", BigDecimalCustomizado
              .getDoubleValueBigDecimalHalfUpArredondado4Casas(11.05));
          add("precoMME12p", BigDecimalCustomizado.getDoubleValueBigDecimalHalfUpArredondado4Casas(11.64));
          add("precoMME26p", BigDecimalCustomizado.getDoubleValueBigDecimalHalfUpArredondado4Casas(12.27));
          add("precoMacd", BigDecimalCustomizado.getDoubleValueBigDecimalHalfUpArredondado4Casas(-0.63));
          add("precoSinalMacd", BigDecimalCustomizado
              .getDoubleValueBigDecimalHalfUpArredondado4Casas(-0.51));
          add("precoHistograma", BigDecimalCustomizado
              .getDoubleValueBigDecimalHalfUpArredondado4Casas(-0.12));
        }})
        .addTemplate(RECOMENDACAO_VALID_011).inherits(RECOMENDACAO_VALID_001,
        new Rule() {{
          add("precoFechamento", BigDecimalCustomizado
              .getDoubleValueBigDecimalHalfUpArredondado4Casas(11.05));
          add("precoMME12p", BigDecimalCustomizado.getDoubleValueBigDecimalHalfUpArredondado4Casas(11.64));
          add("precoMME26p", BigDecimalCustomizado.getDoubleValueBigDecimalHalfUpArredondado4Casas(12.27));
          add("precoMacd", BigDecimalCustomizado.getDoubleValueBigDecimalHalfUpArredondado4Casas(-0.63));
          add("precoSinalMacd", BigDecimalCustomizado
              .getDoubleValueBigDecimalHalfUpArredondado4Casas(-0.51));
          add("precoHistograma", BigDecimalCustomizado
              .getDoubleValueBigDecimalHalfUpArredondado4Casas(-0.12));
        }});
  }
}