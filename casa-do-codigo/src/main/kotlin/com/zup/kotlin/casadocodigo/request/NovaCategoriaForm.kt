package com.zup.kotlin.casadocodigo.request

import com.zup.kotlin.casadocodigo.model.Autor
import com.zup.kotlin.casadocodigo.model.Categoria
import com.zup.kotlin.casadocodigo.validators.ValorUnico
import javax.persistence.Column
import javax.validation.constraints.NotBlank

class NovaCategoriaForm(
        @ValorUnico(className = "Categoria", fieldName = "categoria")
        var categoria: @NotBlank String
) {

    fun toCategoria(): Categoria {
        return Categoria(categoria=categoria)
    }
}