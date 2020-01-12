package com.ricardococati.repository.dao;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

public interface GenericDAO {

  Number getSequence(String sequenceName, NamedParameterJdbcTemplate template);

}
