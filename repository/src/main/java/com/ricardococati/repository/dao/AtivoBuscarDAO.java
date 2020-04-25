package com.ricardococati.repository.dao;

import com.ricardococati.model.entities.Ativo;
import java.util.List;

public interface AtivoBuscarDAO {

  List<Ativo> buscaAtivoByUsuario(final Long idUsuario);

}