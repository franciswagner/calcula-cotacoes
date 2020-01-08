package com.ricardococati.service.impl.templates;

import static com.ricardococati.service.impl.templates.MediaMovelExponencialTemplateLoader.MEDIA_MOVEL_EXPONENCIAL_VALID_001;
import static com.ricardococati.service.impl.templates.MediaMovelExponencialTemplateLoader.MEDIA_MOVEL_EXPONENCIAL_VALID_002;
import static com.ricardococati.service.impl.templates.MediaMovelExponencialTemplateLoader.MEDIA_MOVEL_EXPONENCIAL_VALID_003;
import static com.ricardococati.service.impl.templates.MediaMovelExponencialTemplateLoader.MEDIA_MOVEL_EXPONENCIAL_VALID_004;
import static com.ricardococati.service.impl.templates.MediaMovelExponencialTemplateLoader.MEDIA_MOVEL_EXPONENCIAL_VALID_005;
import static com.ricardococati.service.impl.templates.MediaMovelExponencialTemplateLoader.MEDIA_MOVEL_EXPONENCIAL_VALID_006;
import static com.ricardococati.service.impl.templates.MediaMovelExponencialTemplateLoader.MEDIA_MOVEL_EXPONENCIAL_VALID_007;
import static com.ricardococati.service.impl.templates.MediaMovelExponencialTemplateLoader.MEDIA_MOVEL_EXPONENCIAL_VALID_008;
import static com.ricardococati.service.impl.templates.MediaMovelExponencialTemplateLoader.MEDIA_MOVEL_EXPONENCIAL_VALID_009;
import static com.ricardococati.service.impl.templates.MediaMovelExponencialTemplateLoader.MEDIA_MOVEL_EXPONENCIAL_VALID_010;
import static com.ricardococati.service.impl.templates.MediaMovelExponencialTemplateLoader.MEDIA_MOVEL_EXPONENCIAL_VALID_011;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;
import com.ricardococati.model.dto.MediaMovelExponencial;
import com.ricardococati.model.dto.MediaMovelExponencialDiario;
import java.time.LocalDate;

public class MediaMovelExponencialDiarioTemplateLoader implements TemplateLoader {

  public static final String MEDIA_MOVEL_EXPONENCIAL_DIARIO_VALID_001 = "MEDIA_MOVEL_EXPONENCIAL_DIARIO_VALID_001";
  public static final String MEDIA_MOVEL_EXPONENCIAL_DIARIO_VALID_002 = "MEDIA_MOVEL_EXPONENCIAL_DIARIO_VALID_002";
  public static final String MEDIA_MOVEL_EXPONENCIAL_DIARIO_VALID_003 = "MEDIA_MOVEL_EXPONENCIAL_DIARIO_VALID_003";
  public static final String MEDIA_MOVEL_EXPONENCIAL_DIARIO_VALID_004 = "MEDIA_MOVEL_EXPONENCIAL_DIARIO_VALID_004";
  public static final String MEDIA_MOVEL_EXPONENCIAL_DIARIO_VALID_005 = "MEDIA_MOVEL_EXPONENCIAL_DIARIO_VALID_005";
  public static final String MEDIA_MOVEL_EXPONENCIAL_DIARIO_VALID_006 = "MEDIA_MOVEL_EXPONENCIAL_DIARIO_VALID_006";
  public static final String MEDIA_MOVEL_EXPONENCIAL_DIARIO_VALID_007 = "MEDIA_MOVEL_EXPONENCIAL_DIARIO_VALID_007";
  public static final String MEDIA_MOVEL_EXPONENCIAL_DIARIO_VALID_008 = "MEDIA_MOVEL_EXPONENCIAL_DIARIO_VALID_008";
  public static final String MEDIA_MOVEL_EXPONENCIAL_DIARIO_VALID_009 = "MEDIA_MOVEL_EXPONENCIAL_DIARIO_VALID_009";
  public static final String MEDIA_MOVEL_EXPONENCIAL_DIARIO_VALID_010 = "MEDIA_MOVEL_EXPONENCIAL_DIARIO_VALID_010";
  public static final String MEDIA_MOVEL_EXPONENCIAL_DIARIO_VALID_011 = "MEDIA_MOVEL_EXPONENCIAL_DIARIO_VALID_011";

  @Override
  public void load() {
    Fixture.of(MediaMovelExponencialDiario.class)
        .addTemplate(MEDIA_MOVEL_EXPONENCIAL_DIARIO_VALID_001,
            new Rule() {{
              add("idMediaMovelExponencialDiario", random(Long.class, range(1L, 200L)));
              add("dtpreg", LocalDate.of(1978, 02, 16));
              add("mediaMovelExponencial", one(MediaMovelExponencial.class, MEDIA_MOVEL_EXPONENCIAL_VALID_001));
            }})
        .addTemplate(MEDIA_MOVEL_EXPONENCIAL_DIARIO_VALID_002, new Rule() {{
          add("idMediaMovelExponencialDiario", random(Long.class, range(1L, 200L)));
          add("dtpreg", LocalDate.of(1978, 02, 17));
          add("mediaMovelExponencial", one(MediaMovelExponencial.class, MEDIA_MOVEL_EXPONENCIAL_VALID_002));
        }})
        .addTemplate(MEDIA_MOVEL_EXPONENCIAL_DIARIO_VALID_003, new Rule() {{
          add("idMediaMovelExponencialDiario", random(Long.class, range(1L, 200L)));
          add("dtpreg", LocalDate.of(1978, 02, 18));
          add("mediaMovelExponencial", one(MediaMovelExponencial.class, MEDIA_MOVEL_EXPONENCIAL_VALID_003));
        }})
        .addTemplate(MEDIA_MOVEL_EXPONENCIAL_DIARIO_VALID_004, new Rule() {{
          add("idMediaMovelExponencialDiario", random(Long.class, range(1L, 200L)));
          add("dtpreg", LocalDate.of(1978, 02, 19));
          add("mediaMovelExponencial", one(MediaMovelExponencial.class, MEDIA_MOVEL_EXPONENCIAL_VALID_004));
        }})
        .addTemplate(MEDIA_MOVEL_EXPONENCIAL_DIARIO_VALID_005, new Rule() {{
          add("idMediaMovelExponencialDiario", random(Long.class, range(1L, 200L)));
          add("dtpreg", LocalDate.of(1978, 02, 20));
          add("mediaMovelExponencial", one(MediaMovelExponencial.class, MEDIA_MOVEL_EXPONENCIAL_VALID_005));
        }})
        .addTemplate(MEDIA_MOVEL_EXPONENCIAL_DIARIO_VALID_006, new Rule() {{
          add("idMediaMovelExponencialDiario", random(Long.class, range(1L, 200L)));
          add("dtpreg", LocalDate.of(1978, 02, 21));
          add("mediaMovelExponencial", one(MediaMovelExponencial.class, MEDIA_MOVEL_EXPONENCIAL_VALID_006));
        }})
        .addTemplate(MEDIA_MOVEL_EXPONENCIAL_DIARIO_VALID_007, new Rule() {{
          add("idMediaMovelExponencialDiario", random(Long.class, range(1L, 200L)));
          add("dtpreg", LocalDate.of(1978, 02, 22));
          add("mediaMovelExponencial", one(MediaMovelExponencial.class, MEDIA_MOVEL_EXPONENCIAL_VALID_007));
        }})
        .addTemplate(MEDIA_MOVEL_EXPONENCIAL_DIARIO_VALID_008, new Rule() {{
          add("idMediaMovelExponencialDiario", random(Long.class, range(1L, 200L)));
          add("dtpreg", LocalDate.of(1978, 02, 23));
          add("mediaMovelExponencial", one(MediaMovelExponencial.class, MEDIA_MOVEL_EXPONENCIAL_VALID_008));
        }})
        .addTemplate(MEDIA_MOVEL_EXPONENCIAL_DIARIO_VALID_009, new Rule() {{
          add("idMediaMovelExponencialDiario", random(Long.class, range(1L, 200L)));
          add("dtpreg", LocalDate.of(1978, 02, 24));
          add("mediaMovelExponencial", one(MediaMovelExponencial.class, MEDIA_MOVEL_EXPONENCIAL_VALID_009));
        }})
        .addTemplate(MEDIA_MOVEL_EXPONENCIAL_DIARIO_VALID_010, new Rule() {{
          add("idMediaMovelExponencialDiario", random(Long.class, range(1L, 200L)));
          add("dtpreg", LocalDate.of(1978, 02, 25));
          add("mediaMovelExponencial", one(MediaMovelExponencial.class, MEDIA_MOVEL_EXPONENCIAL_VALID_010));
        }})
        .addTemplate(MEDIA_MOVEL_EXPONENCIAL_DIARIO_VALID_011, new Rule() {{
          add("idMediaMovelExponencialDiario", random(Long.class, range(1L, 200L)));
          add("dtpreg", LocalDate.of(1978, 02, 26));
          add("mediaMovelExponencial", one(MediaMovelExponencial.class, MEDIA_MOVEL_EXPONENCIAL_VALID_011));
        }});
  }
}
