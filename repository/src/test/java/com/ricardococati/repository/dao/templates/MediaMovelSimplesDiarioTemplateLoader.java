package com.ricardococati.repository.dao.templates;

import static com.ricardococati.repository.dao.templates.MediaMovelSimplesTemplateLoader.MEDIA_MOVEL_SIMPLES_VALID_001;
import static com.ricardococati.repository.dao.templates.MediaMovelSimplesTemplateLoader.MEDIA_MOVEL_SIMPLES_VALID_002;
import static com.ricardococati.repository.dao.templates.MediaMovelSimplesTemplateLoader.MEDIA_MOVEL_SIMPLES_VALID_003;
import static com.ricardococati.repository.dao.templates.MediaMovelSimplesTemplateLoader.MEDIA_MOVEL_SIMPLES_VALID_004;
import static com.ricardococati.repository.dao.templates.MediaMovelSimplesTemplateLoader.MEDIA_MOVEL_SIMPLES_VALID_005;
import static com.ricardococati.repository.dao.templates.MediaMovelSimplesTemplateLoader.MEDIA_MOVEL_SIMPLES_VALID_006;
import static com.ricardococati.repository.dao.templates.MediaMovelSimplesTemplateLoader.MEDIA_MOVEL_SIMPLES_VALID_007;
import static com.ricardococati.repository.dao.templates.MediaMovelSimplesTemplateLoader.MEDIA_MOVEL_SIMPLES_VALID_008;
import static com.ricardococati.repository.dao.templates.MediaMovelSimplesTemplateLoader.MEDIA_MOVEL_SIMPLES_VALID_009;
import static com.ricardococati.repository.dao.templates.MediaMovelSimplesTemplateLoader.MEDIA_MOVEL_SIMPLES_VALID_010;
import static com.ricardococati.repository.dao.templates.MediaMovelSimplesTemplateLoader.MEDIA_MOVEL_SIMPLES_VALID_011;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;
import com.ricardococati.model.entities.MediaMovelSimples;
import com.ricardococati.model.entities.MediaMovelSimplesDiario;
import java.time.LocalDate;

public class MediaMovelSimplesDiarioTemplateLoader implements TemplateLoader {

  public static final String MEDIA_MOVEL_SIMPLES_DIARIO_VALID_001 = "MEDIA_MOVEL_SIMPLES_DIARIO_VALID_001";
  public static final String MEDIA_MOVEL_SIMPLES_DIARIO_VALID_002 = "MEDIA_MOVEL_SIMPLES_DIARIO_VALID_002";
  public static final String MEDIA_MOVEL_SIMPLES_DIARIO_VALID_003 = "MEDIA_MOVEL_SIMPLES_DIARIO_VALID_003";
  public static final String MEDIA_MOVEL_SIMPLES_DIARIO_VALID_004 = "MEDIA_MOVEL_SIMPLES_DIARIO_VALID_004";
  public static final String MEDIA_MOVEL_SIMPLES_DIARIO_VALID_005 = "MEDIA_MOVEL_SIMPLES_DIARIO_VALID_005";
  public static final String MEDIA_MOVEL_SIMPLES_DIARIO_VALID_006 = "MEDIA_MOVEL_SIMPLES_DIARIO_VALID_006";
  public static final String MEDIA_MOVEL_SIMPLES_DIARIO_VALID_007 = "MEDIA_MOVEL_SIMPLES_DIARIO_VALID_007";
  public static final String MEDIA_MOVEL_SIMPLES_DIARIO_VALID_008 = "MEDIA_MOVEL_SIMPLES_DIARIO_VALID_008";
  public static final String MEDIA_MOVEL_SIMPLES_DIARIO_VALID_009 = "MEDIA_MOVEL_SIMPLES_DIARIO_VALID_009";
  public static final String MEDIA_MOVEL_SIMPLES_DIARIO_VALID_010 = "MEDIA_MOVEL_SIMPLES_DIARIO_VALID_010";
  public static final String MEDIA_MOVEL_SIMPLES_DIARIO_VALID_011 = "MEDIA_MOVEL_SIMPLES_DIARIO_VALID_011";

  @Override
  public void load() {
    Fixture.of(MediaMovelSimplesDiario.class)
        .addTemplate(MEDIA_MOVEL_SIMPLES_DIARIO_VALID_001,
            new Rule() {{
              add("idMediaMovelSimplesDiario", random(Long.class, range(1L, 200L)));
              add("dtpreg", LocalDate.of(1978, 2, 16));
              add("mediaMovelSimples", one(MediaMovelSimples.class, MEDIA_MOVEL_SIMPLES_VALID_001));
            }})
        .addTemplate(MEDIA_MOVEL_SIMPLES_DIARIO_VALID_002, new Rule() {{
          add("idMediaMovelSimplesDiario", random(Long.class, range(1L, 200L)));
          add("dtpreg", LocalDate.of(1978, 2, 17));
          add("mediaMovelSimples", one(MediaMovelSimples.class, MEDIA_MOVEL_SIMPLES_VALID_002));
        }})
        .addTemplate(MEDIA_MOVEL_SIMPLES_DIARIO_VALID_003, new Rule() {{
          add("idMediaMovelSimplesDiario", random(Long.class, range(1L, 200L)));
          add("dtpreg", LocalDate.of(1978, 2, 18));
          add("mediaMovelSimples", one(MediaMovelSimples.class, MEDIA_MOVEL_SIMPLES_VALID_003));
        }})
        .addTemplate(MEDIA_MOVEL_SIMPLES_DIARIO_VALID_004, new Rule() {{
          add("idMediaMovelSimplesDiario", random(Long.class, range(1L, 200L)));
          add("dtpreg", LocalDate.of(1978, 2, 19));
          add("mediaMovelSimples", one(MediaMovelSimples.class, MEDIA_MOVEL_SIMPLES_VALID_004));
        }})
        .addTemplate(MEDIA_MOVEL_SIMPLES_DIARIO_VALID_005, new Rule() {{
          add("idMediaMovelSimplesDiario", random(Long.class, range(1L, 200L)));
          add("dtpreg", LocalDate.of(1978, 2, 20));
          add("mediaMovelSimples", one(MediaMovelSimples.class, MEDIA_MOVEL_SIMPLES_VALID_005));
        }})
        .addTemplate(MEDIA_MOVEL_SIMPLES_DIARIO_VALID_006, new Rule() {{
          add("idMediaMovelSimplesDiario", random(Long.class, range(1L, 200L)));
          add("dtpreg", LocalDate.of(1978, 2, 21));
          add("mediaMovelSimples", one(MediaMovelSimples.class, MEDIA_MOVEL_SIMPLES_VALID_006));
        }})
        .addTemplate(MEDIA_MOVEL_SIMPLES_DIARIO_VALID_007, new Rule() {{
          add("idMediaMovelSimplesDiario", random(Long.class, range(1L, 200L)));
          add("dtpreg", LocalDate.of(1978, 2, 22));
          add("mediaMovelSimples", one(MediaMovelSimples.class, MEDIA_MOVEL_SIMPLES_VALID_007));
        }})
        .addTemplate(MEDIA_MOVEL_SIMPLES_DIARIO_VALID_008, new Rule() {{
          add("idMediaMovelSimplesDiario", random(Long.class, range(1L, 200L)));
          add("dtpreg", LocalDate.of(1978, 2, 23));
          add("mediaMovelSimples", one(MediaMovelSimples.class, MEDIA_MOVEL_SIMPLES_VALID_008));
        }})
        .addTemplate(MEDIA_MOVEL_SIMPLES_DIARIO_VALID_009, new Rule() {{
          add("idMediaMovelSimplesDiario", random(Long.class, range(1L, 200L)));
          add("dtpreg", LocalDate.of(1978, 2, 24));
          add("mediaMovelSimples", one(MediaMovelSimples.class, MEDIA_MOVEL_SIMPLES_VALID_009));
        }})
        .addTemplate(MEDIA_MOVEL_SIMPLES_DIARIO_VALID_010, new Rule() {{
          add("idMediaMovelSimplesDiario", random(Long.class, range(1L, 200L)));
          add("dtpreg", LocalDate.of(1978, 2, 25));
          add("mediaMovelSimples", one(MediaMovelSimples.class, MEDIA_MOVEL_SIMPLES_VALID_010));
        }})
        .addTemplate(MEDIA_MOVEL_SIMPLES_DIARIO_VALID_011, new Rule() {{
          add("idMediaMovelSimplesDiario", random(Long.class, range(1L, 200L)));
          add("dtpreg", LocalDate.of(1978, 2, 26));
          add("mediaMovelSimples", one(MediaMovelSimples.class, MEDIA_MOVEL_SIMPLES_VALID_011));
        }});
  }
}
