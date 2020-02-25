package com.ricardococati.template;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;
import com.ricardococati.model.dto.Recomendacao;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class RecomendacaoAppTemplateLoader implements TemplateLoader {

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
              add("precoFechamento", new BigDecimal(11.11).setScale(4, RoundingMode.HALF_UP));
              add("precoMME12p", new BigDecimal(11.75).setScale(4, RoundingMode.HALF_UP));
              add("precoMME26p", new BigDecimal(12.36).setScale(4, RoundingMode.HALF_UP));
              add("precoMacd", new BigDecimal(-0.61).setScale(4, RoundingMode.HALF_UP));
              add("precoSinalMacd", new BigDecimal(-0.48).setScale(4, RoundingMode.HALF_UP));
              add("precoHistograma", new BigDecimal(-0.13).setScale(4, RoundingMode.HALF_UP));
              add("decisao", "VENDE");
            }})
        .addTemplate(RECOMENDACAO_VALID_002).inherits(RECOMENDACAO_VALID_001,
        new Rule() {{
          add("precoFechamento", new BigDecimal(11.05).setScale(4, RoundingMode.HALF_UP));
          add("precoMME12p", new BigDecimal(11.64).setScale(4, RoundingMode.HALF_UP));
          add("precoMME26p", new BigDecimal(12.27).setScale(4, RoundingMode.HALF_UP));
          add("precoMacd", new BigDecimal(-0.63).setScale(4, RoundingMode.HALF_UP));
          add("precoSinalMacd", new BigDecimal(-0.51).setScale(4, RoundingMode.HALF_UP));
          add("precoHistograma", new BigDecimal(-0.12).setScale(4, RoundingMode.HALF_UP));
        }})
        .addTemplate(RECOMENDACAO_VALID_003).inherits(RECOMENDACAO_VALID_001,
        new Rule() {{
          add("precoFechamento", new BigDecimal(11.05).setScale(4, RoundingMode.HALF_UP));
          add("precoMME12p", new BigDecimal(11.64).setScale(4, RoundingMode.HALF_UP));
          add("precoMME26p", new BigDecimal(12.27).setScale(4, RoundingMode.HALF_UP));
          add("precoMacd", new BigDecimal(-0.63).setScale(4, RoundingMode.HALF_UP));
          add("precoSinalMacd", new BigDecimal(-0.51).setScale(4, RoundingMode.HALF_UP));
          add("precoHistograma", new BigDecimal(-0.12).setScale(4, RoundingMode.HALF_UP));
        }})
        .addTemplate(RECOMENDACAO_VALID_004).inherits(RECOMENDACAO_VALID_001,
        new Rule() {{
          add("precoFechamento", new BigDecimal(11.05).setScale(4, RoundingMode.HALF_UP));
          add("precoMME12p", new BigDecimal(11.64).setScale(4, RoundingMode.HALF_UP));
          add("precoMME26p", new BigDecimal(12.27).setScale(4, RoundingMode.HALF_UP));
          add("precoMacd", new BigDecimal(-0.63).setScale(4, RoundingMode.HALF_UP));
          add("precoSinalMacd", new BigDecimal(-0.51).setScale(4, RoundingMode.HALF_UP));
          add("precoHistograma", new BigDecimal(-0.12).setScale(4, RoundingMode.HALF_UP));
        }})
        .addTemplate(RECOMENDACAO_VALID_005).inherits(RECOMENDACAO_VALID_001,
        new Rule() {{
          add("precoFechamento", new BigDecimal(11.05).setScale(4, RoundingMode.HALF_UP));
          add("precoMME12p", new BigDecimal(11.64).setScale(4, RoundingMode.HALF_UP));
          add("precoMME26p", new BigDecimal(12.27).setScale(4, RoundingMode.HALF_UP));
          add("precoMacd", new BigDecimal(-0.63).setScale(4, RoundingMode.HALF_UP));
          add("precoSinalMacd", new BigDecimal(-0.51).setScale(4, RoundingMode.HALF_UP));
          add("precoHistograma", new BigDecimal(-0.12).setScale(4, RoundingMode.HALF_UP));
        }})
        .addTemplate(RECOMENDACAO_VALID_006).inherits(RECOMENDACAO_VALID_001,
        new Rule() {{
          add("precoFechamento", new BigDecimal(11.05).setScale(4, RoundingMode.HALF_UP));
          add("precoMME12p", new BigDecimal(11.64).setScale(4, RoundingMode.HALF_UP));
          add("precoMME26p", new BigDecimal(12.27).setScale(4, RoundingMode.HALF_UP));
          add("precoMacd", new BigDecimal(-0.63).setScale(4, RoundingMode.HALF_UP));
          add("precoSinalMacd", new BigDecimal(-0.51).setScale(4, RoundingMode.HALF_UP));
          add("precoHistograma", new BigDecimal(-0.12).setScale(4, RoundingMode.HALF_UP));
        }})
        .addTemplate(RECOMENDACAO_VALID_007).inherits(RECOMENDACAO_VALID_001,
        new Rule() {{
          add("precoFechamento", new BigDecimal(11.05).setScale(4, RoundingMode.HALF_UP));
          add("precoMME12p", new BigDecimal(11.64).setScale(4, RoundingMode.HALF_UP));
          add("precoMME26p", new BigDecimal(12.27).setScale(4, RoundingMode.HALF_UP));
          add("precoMacd", new BigDecimal(-0.63).setScale(4, RoundingMode.HALF_UP));
          add("precoSinalMacd", new BigDecimal(-0.51).setScale(4, RoundingMode.HALF_UP));
          add("precoHistograma", new BigDecimal(-0.12).setScale(4, RoundingMode.HALF_UP));
        }})
        .addTemplate(RECOMENDACAO_VALID_007).inherits(RECOMENDACAO_VALID_001,
        new Rule() {{
          add("precoFechamento", new BigDecimal(11.05).setScale(4, RoundingMode.HALF_UP));
          add("precoMME12p", new BigDecimal(11.64).setScale(4, RoundingMode.HALF_UP));
          add("precoMME26p", new BigDecimal(12.27).setScale(4, RoundingMode.HALF_UP));
          add("precoMacd", new BigDecimal(-0.63).setScale(4, RoundingMode.HALF_UP));
          add("precoSinalMacd", new BigDecimal(-0.51).setScale(4, RoundingMode.HALF_UP));
          add("precoHistograma", new BigDecimal(-0.12).setScale(4, RoundingMode.HALF_UP));
        }})
        .addTemplate(RECOMENDACAO_VALID_008).inherits(RECOMENDACAO_VALID_001,
        new Rule() {{
          add("precoFechamento", new BigDecimal(11.05).setScale(4, RoundingMode.HALF_UP));
          add("precoMME12p", new BigDecimal(11.64).setScale(4, RoundingMode.HALF_UP));
          add("precoMME26p", new BigDecimal(12.27).setScale(4, RoundingMode.HALF_UP));
          add("precoMacd", new BigDecimal(-0.63).setScale(4, RoundingMode.HALF_UP));
          add("precoSinalMacd", new BigDecimal(-0.51).setScale(4, RoundingMode.HALF_UP));
          add("precoHistograma", new BigDecimal(-0.12).setScale(4, RoundingMode.HALF_UP));
        }})
        .addTemplate(RECOMENDACAO_VALID_009).inherits(RECOMENDACAO_VALID_001,
        new Rule() {{
          add("precoFechamento", new BigDecimal(11.05).setScale(4, RoundingMode.HALF_UP));
          add("precoMME12p", new BigDecimal(11.64).setScale(4, RoundingMode.HALF_UP));
          add("precoMME26p", new BigDecimal(12.27).setScale(4, RoundingMode.HALF_UP));
          add("precoMacd", new BigDecimal(-0.63).setScale(4, RoundingMode.HALF_UP));
          add("precoSinalMacd", new BigDecimal(-0.51).setScale(4, RoundingMode.HALF_UP));
          add("precoHistograma", new BigDecimal(-0.12).setScale(4, RoundingMode.HALF_UP));
        }})
        .addTemplate(RECOMENDACAO_VALID_010).inherits(RECOMENDACAO_VALID_001,
        new Rule() {{
          add("precoFechamento", new BigDecimal(11.05).setScale(4, RoundingMode.HALF_UP));
          add("precoMME12p", new BigDecimal(11.64).setScale(4, RoundingMode.HALF_UP));
          add("precoMME26p", new BigDecimal(12.27).setScale(4, RoundingMode.HALF_UP));
          add("precoMacd", new BigDecimal(-0.63).setScale(4, RoundingMode.HALF_UP));
          add("precoSinalMacd", new BigDecimal(-0.51).setScale(4, RoundingMode.HALF_UP));
          add("precoHistograma", new BigDecimal(-0.12).setScale(4, RoundingMode.HALF_UP));
        }})
        .addTemplate(RECOMENDACAO_VALID_011).inherits(RECOMENDACAO_VALID_001,
        new Rule() {{
          add("precoFechamento", new BigDecimal(11.05).setScale(4, RoundingMode.HALF_UP));
          add("precoMME12p", new BigDecimal(11.64).setScale(4, RoundingMode.HALF_UP));
          add("precoMME26p", new BigDecimal(12.27).setScale(4, RoundingMode.HALF_UP));
          add("precoMacd", new BigDecimal(-0.63).setScale(4, RoundingMode.HALF_UP));
          add("precoSinalMacd", new BigDecimal(-0.51).setScale(4, RoundingMode.HALF_UP));
          add("precoHistograma", new BigDecimal(-0.12).setScale(4, RoundingMode.HALF_UP));
        }});
  }
}