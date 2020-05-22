package com.ricardococati.controller

import com.ricardococati.model.entities.RecomendacaoDiario
import com.ricardococati.model.entities.RecomendacaoSemanal
import com.ricardococati.service.CalculaGeralDiarioService
import com.ricardococati.service.CalculaGeralSemanalService
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import io.swagger.annotations.ApiResponse
import io.swagger.annotations.ApiResponses
import org.slf4j.LoggerFactory
import org.springframework.format.annotation.DateTimeFormat
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.time.LocalDate

@RestController
@RequestMapping("api/v1/calcula")
@Api(value = "api/v1/calcula", consumes = MediaType.APPLICATION_JSON_VALUE)
class CalculaController(private val geralDiarioService: CalculaGeralDiarioService,
                        private val geralSemanalService: CalculaGeralSemanalService) {

    @ApiOperation(value = "Efetua todos os cálculos(Diário) para um codigo de negócio"
            + " e retorna as recomendações")
    @ApiResponses(value = [
        ApiResponse(code = 200, message = "OK"),
        ApiResponse(code = 400, message = "Bad Request"),
        ApiResponse(code = 500, message = "Internal Server Error")
    ])
    @ResponseStatus(HttpStatus.OK)
    @PostMapping(value = ["/geral-diario"])
    @Throws(Exception::class)
    fun calculaGeralDiarioPorListCodNegEDtPreg(
            @RequestParam @DateTimeFormat(pattern = "dd-MM-yyyy") dtLimitePregao: LocalDate?,
            @RequestParam(required = false) listCodneg: List<String?>?
    ): ResponseEntity<List<RecomendacaoDiario>> {
        log.info("Excutando cálculo ")
        val listReturn = geralDiarioService.executeByCodNeg(listCodneg, dtLimitePregao)
        log.info("Cálculo executado com sucesso!! ")
        return ResponseEntity.ok().body(listReturn)
    }

    @ApiOperation(value = "Efetua todos os cálculos(Semanal) para um codigo de negócio"
            + " e retorna as recomendações")
    @ApiResponses(value = [
        ApiResponse(code = 200, message = "OK"),
        ApiResponse(code = 400, message = "Bad Request"),
        ApiResponse(code = 500, message = "Internal Server Error")
    ])
    @ResponseStatus(HttpStatus.OK)
    @PostMapping(value = ["/geral-semanal"])
    @Throws(Exception::class)
    fun calculaGeralSemanalPorListCodNegEDtPreg(
            @RequestParam @DateTimeFormat(pattern = "dd-MM-yyyy") dtLimitePregao: LocalDate?,
            @RequestParam(required = false) listCodneg: List<String?>?
    ): ResponseEntity<List<RecomendacaoSemanal>> {
        log.info("Excutando cálculo ")
        val listReturn = geralSemanalService.executeByCodNeg(listCodneg, dtLimitePregao)
        log.info("Cálculo executado com sucesso!! ")
        return ResponseEntity.ok().body(listReturn)
    }

    companion object {
        private val log = LoggerFactory.getLogger(CalculaController::class.java)
    }

}