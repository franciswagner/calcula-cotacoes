package com.ricardococati.repository.dao.impl;

import com.ricardococati.repository.dao.BaseJdbcTest;
import com.ricardococati.repository.dao.mapper.RecomendacaoDiarioMapper;
import com.ricardococati.repository.dao.sqlutil.RecomendacaoDiarioBuscarSQLUtil;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class RecomendacaoDiarioBuscarDAOImplTest extends BaseJdbcTest {

  @InjectMocks
  private RecomendacaoDiarioBuscarDAOImpl target;
  @Mock
  private RecomendacaoDiarioBuscarSQLUtil sqlUtil;
  @Mock
  private RecomendacaoDiarioMapper mapper;

  @Before
  public void setUp() throws Exception {
  }

  @Test
  public void getListRecomendacaoByDtPregECodNeg() {
  }

}
