package com.ricardococati.controller

import com.ricardococati.controller.converter.SplitInplitConverter
import com.ricardococati.service.CandlestickAtualizarService
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
@RequestMapping("api/v1/split-inplit")
@Api(value = "api/v1/split-inplit", consumes = MediaType.APPLICATION_JSON_VALUE)
class SplitInplitController(private val converter: SplitInplitConverter,
                            private val service: CandlestickAtualizarService) {

    @ApiOperation(value = "Split | Inplit na acao por: "
            + "codigo de negocio(String), "
            + "data do pregão(DD/MM/YYYY), "
            + "quantidade de divisões e(Integer) "
            + "operação(SPLIT ou INPLIT)")
    @ApiResponses(value = [
        ApiResponse(code = 200, message = "Split OK"),
        ApiResponse(code = 400, message = "Bad Request"),
        ApiResponse(code = 409, message = "Conflict Request"),
        ApiResponse(code = 500, message = "Internal Server Error")
    ])
    @ResponseStatus(HttpStatus.OK)
    @PutMapping
    fun splitInplit(
            @RequestParam @DateTimeFormat(pattern = "dd-MM-yyyy") dtPregrao: LocalDate?,
            @RequestParam codneg: String?,
            @RequestParam qtdSplitInplit: Int?,
            @RequestParam operacao: String?
    ): ResponseEntity<*> {
        log.info("Excutando Split ")
        val splitInplit = converter.convert(dtPregrao, codneg, qtdSplitInplit, operacao!!)
        log.info("Objeto convertido: {}", splitInplit)
        service.executeSplitInplit(splitInplit)
        log.info("Split executado com sucesso!! ")
        return ResponseEntity.ok().build<Any>()
    }

    companion object {
        private val log = LoggerFactory.getLogger(SplitInplitController::class.java)
    }

}