package com.zup.kotlin.casadocodigo.request

import com.fasterxml.jackson.annotation.JsonFormat
import com.zup.kotlin.casadocodigo.model.Cupom
import com.zup.kotlin.casadocodigo.validators.ValorUnico
import java.math.BigDecimal
import java.time.LocalDateTime
import javax.validation.constraints.*

class NovoCupomform(
        @ValorUnico(className = "Cupom", fieldName = "codigo")
        var codigo: @NotBlank String,

        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy kk:mm")
        var validade: @Future @NotNull LocalDateTime,
        var desconto: @Positive @DecimalMin("0.01") BigDecimal

) {


    fun novoCupom(): Cupom {
        return Cupom(codigo=codigo, validade=validade, desconto=desconto)
    }
}
