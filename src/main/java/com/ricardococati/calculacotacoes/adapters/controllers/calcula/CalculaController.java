package com.ricardococati.calculacotacoes.adapters.controllers.calcula;

import com.ricardococati.calculacotacoes.entities.domains.recomendacao.RecomendacaoDiario;
import com.ricardococati.calculacotacoes.entities.domains.recomendacao.RecomendacaoSemanal;
import com.ricardococati.calculacotacoes.usecases.calculageral.CalculaGeralDiarioService;
import com.ricardococati.calculacotacoes.usecases.calculageral.CalculaGeralSemanalService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import java.time.LocalDate;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("api/v1/calcula")
@Api(value = "api/v1/calcula", consumes = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class CalculaController {

  private final CalculaGeralDiarioService geralDiarioService;
  private final CalculaGeralSemanalService geralSemanalService;

  @ApiOperation(value = "Efetua todos os cálculos(Diário) por "
              + "codigo de negocio(String), gerando retorno até a "
              + "data do pregão(DD-MM-YYYY) ")
  @ApiResponses(
      value = {
        @ApiResponse(code = 200, message = "OK"),
        @ApiResponse(code = 400, message = "Bad Request"),
        @ApiResponse(code = 500, message = "Internal Server Error")
      })
  @ResponseStatus(HttpStatus.OK)
  @PostMapping(value = "/geral-diario")
  public ResponseEntity<List<RecomendacaoDiario>> calculaGeralDiarioPorListCodNegEDtPreg(
      @RequestParam @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate dtLimitePregao,
      @RequestParam(required = false) List<String> listCodneg)
      throws Exception {
    log.info("Excutando cálculo ");
    List<RecomendacaoDiario> listReturn =
        geralDiarioService.executeByCodNeg(listCodneg, dtLimitePregao);
    log.info("Cálculo executado com sucesso!! ");
    return ResponseEntity.ok().body(listReturn);
  }

  @ApiOperation(value = "Efetua todos os cálculos(Semanal) por "
              + "codigo de negocio(String), gerando retorno até a "
              + "data do pregão(DD-MM-YYYY) ")
  @ApiResponses(
      value = {
          @ApiResponse(code = 200, message = "OK"),
          @ApiResponse(code = 400, message = "Bad Request"),
          @ApiResponse(code = 500, message = "Internal Server Error")
      }
  )
  @ResponseStatus(HttpStatus.OK)
  @PostMapping(value = "/geral-semanal")
  public ResponseEntity<List<RecomendacaoSemanal>> calculaGeralSemanalPorListCodNegEDtPreg(
      @RequestParam @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate dtLimitePregao,
      @RequestParam(required = false) List<String> listCodneg
  ) throws Exception {
    log.info("Excutando cálculo ");
    List<RecomendacaoSemanal> listReturn =
        geralSemanalService.executeByCodNeg(listCodneg, dtLimitePregao);
    log.info("Cálculo executado com sucesso!! ");
    return ResponseEntity.ok().body(listReturn);
  }

}
