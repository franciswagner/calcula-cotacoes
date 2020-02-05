package com.ricardococati.controller;

import com.ricardococati.model.dto.RecomendacaoDiario;
import com.ricardococati.model.dto.RecomendacaoSemanal;
import com.ricardococati.service.CalculaGeralDiarioService;
import com.ricardococati.service.CalculaGeralSemanalService;
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

  @ApiOperation(value = "Efetua todos os cálculos(Diário) para um codigo de negócio"
      + " e retorna as recomendações")
  @ApiResponses(
      value = {
          @ApiResponse(code = 200, message = "OK"),
          @ApiResponse(code = 400, message = "Bad Request"),
          @ApiResponse(code = 500, message = "Internal Server Error")
      }
  )
  @ResponseStatus(HttpStatus.OK)
  @PostMapping(value = "/geral-diario")
  public ResponseEntity<List<RecomendacaoDiario>> calculaGeralDiarioPorListCodNegEDtPreg(
      @RequestParam @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate dtLimitePregao,
      @RequestParam(required = false) List<String> listCodneg
  ) throws Exception {
    log.info("Excutando cálculo ");
    List<RecomendacaoDiario> listReturn =
        geralDiarioService.executeByCodNeg(listCodneg, dtLimitePregao);
    log.info("Cálculo executado com sucesso!! ");
    return ResponseEntity.ok().body(listReturn);
  }

  @ApiOperation(value = "Efetua todos os cálculos(Semanal) para um codigo de negócio"
      + " e retorna as recomendações")
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
