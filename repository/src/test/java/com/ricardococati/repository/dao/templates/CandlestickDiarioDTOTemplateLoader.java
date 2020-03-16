package com.ricardococati.repository.dao.templates;

import static com.ricardococati.repository.dao.templates.CandlestickDTOTemplateLoader.CANDLESTICK_VALID_001;
import static com.ricardococati.repository.dao.templates.CandlestickDTOTemplateLoader.CANDLESTICK_VALID_002;
import static com.ricardococati.repository.dao.templates.CandlestickDTOTemplateLoader.CANDLESTICK_VALID_003;
import static com.ricardococati.repository.dao.templates.CandlestickDTOTemplateLoader.CANDLESTICK_VALID_004;
import static com.ricardococati.repository.dao.templates.CandlestickDTOTemplateLoader.CANDLESTICK_VALID_005;
import static com.ricardococati.repository.dao.templates.CandlestickDTOTemplateLoader.CANDLESTICK_VALID_006;
import static com.ricardococati.repository.dao.templates.CandlestickDTOTemplateLoader.CANDLESTICK_VALID_007;
import static com.ricardococati.repository.dao.templates.CandlestickDTOTemplateLoader.CANDLESTICK_VALID_008;
import static com.ricardococati.repository.dao.templates.CandlestickDTOTemplateLoader.CANDLESTICK_VALID_009;
import static com.ricardococati.repository.dao.templates.CandlestickDTOTemplateLoader.CANDLESTICK_VALID_010;
import static com.ricardococati.repository.dao.templates.CandlestickDTOTemplateLoader.CANDLESTICK_VALID_011;
import static com.ricardococati.repository.dao.templates.CandlestickDTOTemplateLoader.CANDLESTICK_VALID_012;
import static com.ricardococati.repository.dao.templates.CandlestickDTOTemplateLoader.CANDLESTICK_VALID_013;
import static com.ricardococati.repository.dao.templates.CandlestickDTOTemplateLoader.CANDLESTICK_VALID_014;
import static com.ricardococati.repository.dao.templates.CandlestickDTOTemplateLoader.CANDLESTICK_VALID_015;
import static com.ricardococati.repository.dao.templates.CandlestickDTOTemplateLoader.CANDLESTICK_VALID_016;
import static com.ricardococati.repository.dao.templates.CandlestickDTOTemplateLoader.CANDLESTICK_VALID_017;
import static com.ricardococati.repository.dao.templates.CandlestickDTOTemplateLoader.CANDLESTICK_VALID_018;
import static com.ricardococati.repository.dao.templates.CandlestickDTOTemplateLoader.CANDLESTICK_VALID_019;
import static com.ricardococati.repository.dao.templates.CandlestickDTOTemplateLoader.CANDLESTICK_VALID_020;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;
import com.ricardococati.model.entities.Candlestick;
import com.ricardococati.model.entities.CandlestickDiario;
import java.time.LocalDate;

public class CandlestickDiarioDTOTemplateLoader implements TemplateLoader {

  public static final String CANDLESTICK_DIARIO_VALID_001 = "CANDLESTICK_DIARIO_VALID_001";
  public static final String CANDLESTICK_DIARIO_VALID_002 = "CANDLESTICK_DIARIO_VALID_002";
  public static final String CANDLESTICK_DIARIO_VALID_003 = "CANDLESTICK_DIARIO_VALID_003";
  public static final String CANDLESTICK_DIARIO_VALID_004 = "CANDLESTICK_DIARIO_VALID_004";
  public static final String CANDLESTICK_DIARIO_VALID_005 = "CANDLESTICK_DIARIO_VALID_005";
  public static final String CANDLESTICK_DIARIO_VALID_006 = "CANDLESTICK_DIARIO_VALID_006";
  public static final String CANDLESTICK_DIARIO_VALID_007 = "CANDLESTICK_DIARIO_VALID_007";
  public static final String CANDLESTICK_DIARIO_VALID_008 = "CANDLESTICK_DIARIO_VALID_008";
  public static final String CANDLESTICK_DIARIO_VALID_009 = "CANDLESTICK_DIARIO_VALID_009";
  public static final String CANDLESTICK_DIARIO_VALID_010 = "CANDLESTICK_DIARIO_VALID_010";
  public static final String CANDLESTICK_DIARIO_VALID_011 = "CANDLESTICK_DIARIO_VALID_011";
  public static final String CANDLESTICK_DIARIO_VALID_012 = "CANDLESTICK_DIARIO_VALID_012";
  public static final String CANDLESTICK_DIARIO_VALID_013 = "CANDLESTICK_DIARIO_VALID_013";
  public static final String CANDLESTICK_DIARIO_VALID_014 = "CANDLESTICK_DIARIO_VALID_014";
  public static final String CANDLESTICK_DIARIO_VALID_015 = "CANDLESTICK_DIARIO_VALID_015";
  public static final String CANDLESTICK_DIARIO_VALID_016 = "CANDLESTICK_DIARIO_VALID_016";
  public static final String CANDLESTICK_DIARIO_VALID_017 = "CANDLESTICK_DIARIO_VALID_017";
  public static final String CANDLESTICK_DIARIO_VALID_018 = "CANDLESTICK_DIARIO_VALID_018";
  public static final String CANDLESTICK_DIARIO_VALID_019 = "CANDLESTICK_DIARIO_VALID_019";
  public static final String CANDLESTICK_DIARIO_VALID_020 = "CANDLESTICK_DIARIO_VALID_020";
  private LocalDate localDate = LocalDate.of(1978, 2, 16);

  @Override
  public void load() {
    Fixture.of(CandlestickDiario.class)
        .addTemplate(CANDLESTICK_DIARIO_VALID_001, new Rule() {{
          add("idCandleDiario", random(Long.class, range(1L, 200L)));
          add("dtpreg", localDate);
          add("candlestick", one(Candlestick.class, CANDLESTICK_VALID_001));
        }})
        .addTemplate(CANDLESTICK_DIARIO_VALID_002, new Rule() {{
          add("idCandleDiario", random(Long.class, range(1L, 200L)));
          add("dtpreg", localDate.plusDays(1));
          add("candlestick", one(Candlestick.class, CANDLESTICK_VALID_002));
        }})
        .addTemplate(CANDLESTICK_DIARIO_VALID_003, new Rule() {{
          add("idCandleDiario", random(Long.class, range(1L, 200L)));
          add("dtpreg", localDate.plusDays(2));
          add("candlestick", one(Candlestick.class, CANDLESTICK_VALID_003));
        }})
        .addTemplate(CANDLESTICK_DIARIO_VALID_004, new Rule() {{
          add("idCandleDiario", random(Long.class, range(1L, 200L)));
          add("dtpreg", localDate.plusDays(3));
          add("candlestick", one(Candlestick.class, CANDLESTICK_VALID_004));
        }})
        .addTemplate(CANDLESTICK_DIARIO_VALID_005, new Rule() {{
          add("idCandleDiario", random(Long.class, range(1L, 200L)));
          add("dtpreg", localDate.plusDays(4));
          add("candlestick", one(Candlestick.class, CANDLESTICK_VALID_005));
        }})
        .addTemplate(CANDLESTICK_DIARIO_VALID_006, new Rule() {{
          add("idCandleDiario", random(Long.class, range(1L, 200L)));
          add("dtpreg", localDate.plusDays(5));
          add("candlestick", one(Candlestick.class, CANDLESTICK_VALID_006));
        }})
        .addTemplate(CANDLESTICK_DIARIO_VALID_007, new Rule() {{
          add("idCandleDiario", random(Long.class, range(1L, 200L)));
          add("dtpreg", localDate.plusDays(6));
          add("candlestick", one(Candlestick.class, CANDLESTICK_VALID_007));
        }})
        .addTemplate(CANDLESTICK_DIARIO_VALID_008, new Rule() {{
          add("idCandleDiario", random(Long.class, range(1L, 200L)));
          add("dtpreg", localDate.plusDays(7));
          add("candlestick", one(Candlestick.class, CANDLESTICK_VALID_008));
        }})
        .addTemplate(CANDLESTICK_DIARIO_VALID_009, new Rule() {{
          add("idCandleDiario", random(Long.class, range(1L, 200L)));
          add("dtpreg", localDate.plusDays(8));
          add("candlestick", one(Candlestick.class, CANDLESTICK_VALID_009));
        }})
        .addTemplate(CANDLESTICK_DIARIO_VALID_010, new Rule() {{
          add("idCandleDiario", random(Long.class, range(1L, 200L)));
          add("dtpreg", localDate.plusDays(9));
          add("candlestick", one(Candlestick.class, CANDLESTICK_VALID_010));
        }})
        .addTemplate(CANDLESTICK_DIARIO_VALID_011, new Rule() {{
          add("idCandleDiario", random(Long.class, range(1L, 200L)));
          add("dtpreg", localDate.plusDays(10));
          add("candlestick", one(Candlestick.class, CANDLESTICK_VALID_011));
        }})
        .addTemplate(CANDLESTICK_DIARIO_VALID_012, new Rule() {{
          add("idCandleDiario", random(Long.class, range(1L, 200L)));
          add("dtpreg", localDate.plusDays(11));
          add("candlestick", one(Candlestick.class, CANDLESTICK_VALID_012));
        }})
        .addTemplate(CANDLESTICK_DIARIO_VALID_013, new Rule() {{
          add("idCandleDiario", random(Long.class, range(1L, 200L)));
          add("dtpreg", localDate.plusDays(12));
          add("candlestick", one(Candlestick.class, CANDLESTICK_VALID_013));
        }})
        .addTemplate(CANDLESTICK_DIARIO_VALID_014, new Rule() {{
          add("idCandleDiario", random(Long.class, range(1L, 200L)));
          add("dtpreg", localDate.plusDays(13));
          add("candlestick", one(Candlestick.class, CANDLESTICK_VALID_014));
        }})
        .addTemplate(CANDLESTICK_DIARIO_VALID_015, new Rule() {{
          add("idCandleDiario", random(Long.class, range(1L, 200L)));
          add("dtpreg", localDate.plusDays(14));
          add("candlestick", one(Candlestick.class, CANDLESTICK_VALID_015));
        }})
        .addTemplate(CANDLESTICK_DIARIO_VALID_016, new Rule() {{
          add("idCandleDiario", random(Long.class, range(1L, 200L)));
          add("dtpreg", localDate.plusDays(15));
          add("candlestick", one(Candlestick.class, CANDLESTICK_VALID_016));
        }})
        .addTemplate(CANDLESTICK_DIARIO_VALID_017, new Rule() {{
          add("idCandleDiario", random(Long.class, range(1L, 200L)));
          add("dtpreg", localDate.plusDays(16));
          add("candlestick", one(Candlestick.class, CANDLESTICK_VALID_017));
        }})
        .addTemplate(CANDLESTICK_DIARIO_VALID_018, new Rule() {{
          add("idCandleDiario", random(Long.class, range(1L, 200L)));
          add("dtpreg", localDate.plusDays(17));
          add("candlestick", one(Candlestick.class, CANDLESTICK_VALID_018));
        }})
        .addTemplate(CANDLESTICK_DIARIO_VALID_019, new Rule() {{
          add("idCandleDiario", random(Long.class, range(1L, 200L)));
          add("dtpreg", localDate.plusDays(18));
          add("candlestick", one(Candlestick.class, CANDLESTICK_VALID_019));
        }})
        .addTemplate(CANDLESTICK_DIARIO_VALID_020, new Rule() {{
          add("idCandleDiario", random(Long.class, range(1L, 200L)));
          add("dtpreg", localDate.plusDays(19));
          add("candlestick", one(Candlestick.class, CANDLESTICK_VALID_020));
        }})
    ;
  }
}