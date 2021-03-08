package com.zup.kotlin.casadocodigo.request

import com.zup.kotlin.casadocodigo.model.Pais
import com.zup.kotlin.casadocodigo.validators.ValorUnico
import javax.validation.constraints.NotBlank

class NovoPaisForm (
        @ValorUnico(className = "Pais", fieldName = "pais")
        var pais: @NotBlank String

        ){


    fun novoPais(): Pais {
        return Pais(pais=pais)
    }
}