package com.ricardococati.repository.dao.impl;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

import com.ricardococati.model.dto.CandlestickSemanalDTO;
import com.ricardococati.repository.dao.BaseJdbcTest;
import java.time.LocalDate;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class GenericDAOImplTest extends BaseJdbcTest {

  @InjectMocks
  private GenericDAOImpl target;

  @Before
  public void setUp() throws Exception {
    target = new GenericDAOImpl(
        getNamedParameterJdbcTemplate()
    );
  }

  @Test
  public void getSequence() {
    //given
    String sequence = "CANDLESTICK_SEQ";
    //when
    Number retorno = target.getSequence(sequence);
    //then
    Assertions.assertThat(retorno).isNotNull().isEqualTo(1L);
  }

}