package com.ricardococati.controller;

import com.ricardococati.service.ICalculaMediaMovelExponencialDiarioService;
import com.ricardococati.service.ICalculaMediaMovelSimplesDiarioService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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

  private final ICalculaMediaMovelSimplesDiarioService serviceMS;
  private final ICalculaMediaMovelExponencialDiarioService serviceME;

  @ApiOperation(value = "Calcula a média móvel simples para um codigo de negócio")
  @ApiResponses(
      value = {
          @ApiResponse(code = 200, message = "OK"),
          @ApiResponse(code = 400, message = "Bad Request"),
          @ApiResponse(code = 409, message = "Conflict Request"),
          @ApiResponse(code = 500, message = "Internal Server Error")
      }
  )
  @ResponseStatus(HttpStatus.OK)
  @PostMapping(value = "/media-simples")
  public ResponseEntity<?> calculaMMS(
      @RequestParam(required = false) String codneg
  ) {
    log.info("Excutando cálculo ");
    serviceMS.executeByCodNeg(codneg);
    log.info("Cálculo executado com sucesso!! ");
    return ResponseEntity.ok().build();
  }

  @ApiOperation(value = "Calcula a média móvel exponencial para um codigo de negócio")
  @ApiResponses(
      value = {
          @ApiResponse(code = 200, message = "OK"),
          @ApiResponse(code = 400, message = "Bad Request"),
          @ApiResponse(code = 409, message = "Conflict Request"),
          @ApiResponse(code = 500, message = "Internal Server Error")
      }
  )
  @ResponseStatus(HttpStatus.OK)
  @PostMapping(value = "/media-exponencial")
  public ResponseEntity<?> calculaMME(
      @RequestParam String codneg
  ) {
    log.info("Excutando cálculo ");
    serviceME.executeByCodNeg(codneg);
    log.info("Cálculo executado com sucesso!! ");
    return ResponseEntity.ok().build();
  }

}
