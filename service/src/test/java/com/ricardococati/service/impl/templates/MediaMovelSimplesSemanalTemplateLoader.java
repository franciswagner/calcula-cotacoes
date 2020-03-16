package com.ricardococati.service.impl.templates;

import static com.ricardococati.service.impl.templates.MediaMovelSimplesTemplateLoader.MEDIA_MOVEL_SIMPLES_VALID_001;
import static com.ricardococati.service.impl.templates.MediaMovelSimplesTemplateLoader.MEDIA_MOVEL_SIMPLES_VALID_002;
import static com.ricardococati.service.impl.templates.MediaMovelSimplesTemplateLoader.MEDIA_MOVEL_SIMPLES_VALID_003;
import static com.ricardococati.service.impl.templates.MediaMovelSimplesTemplateLoader.MEDIA_MOVEL_SIMPLES_VALID_004;
import static com.ricardococati.service.impl.templates.MediaMovelSimplesTemplateLoader.MEDIA_MOVEL_SIMPLES_VALID_005;
import static com.ricardococati.service.impl.templates.MediaMovelSimplesTemplateLoader.MEDIA_MOVEL_SIMPLES_VALID_006;
import static com.ricardococati.service.impl.templates.MediaMovelSimplesTemplateLoader.MEDIA_MOVEL_SIMPLES_VALID_007;
import static com.ricardococati.service.impl.templates.MediaMovelSimplesTemplateLoader.MEDIA_MOVEL_SIMPLES_VALID_008;
import static com.ricardococati.service.impl.templates.MediaMovelSimplesTemplateLoader.MEDIA_MOVEL_SIMPLES_VALID_009;
import static com.ricardococati.service.impl.templates.MediaMovelSimplesTemplateLoader.MEDIA_MOVEL_SIMPLES_VALID_010;
import static com.ricardococati.service.impl.templates.MediaMovelSimplesTemplateLoader.MEDIA_MOVEL_SIMPLES_VALID_011;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;
import com.ricardococati.model.entities.MediaMovelSimples;
import com.ricardococati.model.entities.MediaMovelSimplesSemanal;
import java.time.LocalDate;

public class MediaMovelSimplesSemanalTemplateLoader implements TemplateLoader {

  public static final String MEDIA_MOVEL_SIMPLES_SEMANAL_VALID_001 = "MEDIA_MOVEL_SIMPLES_SEMANAL_VALID_001";
  public static final String MEDIA_MOVEL_SIMPLES_SEMANAL_VALID_002 = "MEDIA_MOVEL_SIMPLES_SEMANAL_VALID_002";
  public static final String MEDIA_MOVEL_SIMPLES_SEMANAL_VALID_003 = "MEDIA_MOVEL_SIMPLES_SEMANAL_VALID_003";
  public static final String MEDIA_MOVEL_SIMPLES_SEMANAL_VALID_004 = "MEDIA_MOVEL_SIMPLES_SEMANAL_VALID_004";
  public static final String MEDIA_MOVEL_SIMPLES_SEMANAL_VALID_005 = "MEDIA_MOVEL_SIMPLES_SEMANAL_VALID_005";
  public static final String MEDIA_MOVEL_SIMPLES_SEMANAL_VALID_006 = "MEDIA_MOVEL_SIMPLES_SEMANAL_VALID_006";
  public static final String MEDIA_MOVEL_SIMPLES_SEMANAL_VALID_007 = "MEDIA_MOVEL_SIMPLES_SEMANAL_VALID_007";
  public static final String MEDIA_MOVEL_SIMPLES_SEMANAL_VALID_008 = "MEDIA_MOVEL_SIMPLES_SEMANAL_VALID_008";
  public static final String MEDIA_MOVEL_SIMPLES_SEMANAL_VALID_009 = "MEDIA_MOVEL_SIMPLES_SEMANAL_VALID_009";
  public static final String MEDIA_MOVEL_SIMPLES_SEMANAL_VALID_010 = "MEDIA_MOVEL_SIMPLES_SEMANAL_VALID_010";
  public static final String MEDIA_MOVEL_SIMPLES_SEMANAL_VALID_011 = "MEDIA_MOVEL_SIMPLES_SEMANAL_VALID_011";
  private LocalDate localDate = LocalDate.of(1978, 2, 16);

  @Override
  public void load() {
    Fixture.of(MediaMovelSimplesSemanal.class)
        .addTemplate(MEDIA_MOVEL_SIMPLES_SEMANAL_VALID_001,
            new Rule() {{
              add("idMediaMovelSimplesSemanal", random(Long.class, range(1L, 200L)));
              add("dtpregini", localDate);
              add("dtpregfim", localDate.plusDays(2));
              add("mediaMovelSimples", one(MediaMovelSimples.class, MEDIA_MOVEL_SIMPLES_VALID_001));
            }})
        .addTemplate(MEDIA_MOVEL_SIMPLES_SEMANAL_VALID_002, new Rule() {{
          add("idMediaMovelSimplesSemanal", random(Long.class, range(1L, 200L)));
          add("dtpregini", localDate.plusDays(3));
          add("dtpregfim", localDate.plusDays(4));
          add("mediaMovelSimples", one(MediaMovelSimples.class, MEDIA_MOVEL_SIMPLES_VALID_002));
        }})
        .addTemplate(MEDIA_MOVEL_SIMPLES_SEMANAL_VALID_003, new Rule() {{
          add("idMediaMovelSimplesSemanal", random(Long.class, range(1L, 200L)));
          add("dtpregini", localDate.plusDays(5));
          add("dtpregfim", localDate.plusDays(6));
          add("mediaMovelSimples", one(MediaMovelSimples.class, MEDIA_MOVEL_SIMPLES_VALID_003));
        }})
        .addTemplate(MEDIA_MOVEL_SIMPLES_SEMANAL_VALID_004, new Rule() {{
          add("idMediaMovelSimplesSemanal", random(Long.class, range(1L, 200L)));
          add("dtpregini", localDate.plusDays(7));
          add("dtpregfim", localDate.plusDays(8));
          add("mediaMovelSimples", one(MediaMovelSimples.class, MEDIA_MOVEL_SIMPLES_VALID_004));
        }})
        .addTemplate(MEDIA_MOVEL_SIMPLES_SEMANAL_VALID_005, new Rule() {{
          add("idMediaMovelSimplesSemanal", random(Long.class, range(1L, 200L)));
          add("dtpregini", localDate.plusDays(9));
          add("dtpregfim", localDate.plusDays(10));
          add("mediaMovelSimples", one(MediaMovelSimples.class, MEDIA_MOVEL_SIMPLES_VALID_005));
        }})
        .addTemplate(MEDIA_MOVEL_SIMPLES_SEMANAL_VALID_006, new Rule() {{
          add("idMediaMovelSimplesSemanal", random(Long.class, range(1L, 200L)));
          add("dtpregini", localDate.plusDays(11));
          add("dtpregfim", localDate.plusDays(12));
          add("mediaMovelSimples", one(MediaMovelSimples.class, MEDIA_MOVEL_SIMPLES_VALID_006));
        }})
        .addTemplate(MEDIA_MOVEL_SIMPLES_SEMANAL_VALID_007, new Rule() {{
          add("idMediaMovelSimplesSemanal", random(Long.class, range(1L, 200L)));
          add("dtpregini", localDate.plusDays(13));
          add("dtpregfim", localDate.plusDays(14));
          add("mediaMovelSimples", one(MediaMovelSimples.class, MEDIA_MOVEL_SIMPLES_VALID_007));
        }})
        .addTemplate(MEDIA_MOVEL_SIMPLES_SEMANAL_VALID_008, new Rule() {{
          add("idMediaMovelSimplesSemanal", random(Long.class, range(1L, 200L)));
          add("dtpregini", localDate.plusDays(15));
          add("dtpregfim", localDate.plusDays(16));
          add("mediaMovelSimples", one(MediaMovelSimples.class, MEDIA_MOVEL_SIMPLES_VALID_008));
        }})
        .addTemplate(MEDIA_MOVEL_SIMPLES_SEMANAL_VALID_009, new Rule() {{
          add("idMediaMovelSimplesSemanal", random(Long.class, range(1L, 200L)));
          add("dtpregini", localDate.plusDays(17));
          add("dtpregfim", localDate.plusDays(18));
          add("mediaMovelSimples", one(MediaMovelSimples.class, MEDIA_MOVEL_SIMPLES_VALID_009));
        }})
        .addTemplate(MEDIA_MOVEL_SIMPLES_SEMANAL_VALID_010, new Rule() {{
          add("idMediaMovelSimplesSemanal", random(Long.class, range(1L, 200L)));
          add("dtpregini", localDate.plusDays(19));
          add("dtpregfim", localDate.plusDays(20));
          add("mediaMovelSimples", one(MediaMovelSimples.class, MEDIA_MOVEL_SIMPLES_VALID_010));
        }})
        .addTemplate(MEDIA_MOVEL_SIMPLES_SEMANAL_VALID_011, new Rule() {{
          add("idMediaMovelSimplesSemanal", random(Long.class, range(1L, 200L)));
          add("dtpregini", localDate.plusDays(21));
          add("dtpregfim", localDate.plusDays(22));
          add("mediaMovelSimples", one(MediaMovelSimples.class, MEDIA_MOVEL_SIMPLES_VALID_011));
        }});
  }
}
