package com.zup.kotlin.casadocodigo.request

import com.zup.kotlin.casadocodigo.model.Estado
import com.zup.kotlin.casadocodigo.repository.PaisRepository
import com.zup.kotlin.casadocodigo.validators.ValorUnico
import org.springframework.util.Assert
import javax.validation.constraints.NotBlank

class NovoEstadoForm(
        @ValorUnico(className = "Estado", fieldName = "estado")
        var estado: @NotBlank String,
        var paisNome: @NotBlank String
) {



    fun novoEstado(paisRepository: PaisRepository): Estado {
        val paisEncontrado = paisRepository.findByPais(paisNome)
        Assert.notNull(paisEncontrado, "Pais não encontrado para o nome: $paisNome")
        return Estado(estado=estado, pais=paisEncontrado)
    }
}
