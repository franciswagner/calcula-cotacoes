package com.ricardococati.calculacotacoes.adapters.repositories.ativo;

import com.ricardococati.calculacotacoes.entities.domains.ativo.Ativo;
import java.util.List;

public interface AtivoBuscarDAO {

  List<Ativo> buscaAtivoByUsuario(final Long idUsuario);

}