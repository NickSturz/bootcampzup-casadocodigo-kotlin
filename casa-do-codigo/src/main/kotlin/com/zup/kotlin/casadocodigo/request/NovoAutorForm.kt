package com.zup.kotlin.casadocodigo.request

import com.zup.kotlin.casadocodigo.model.Autor
import com.zup.kotlin.casadocodigo.validators.ValorUnico
import javax.persistence.Column
import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank

class NovoAutorForm(var nome: @NotBlank String,

                    @ValorUnico(className = "Autor", fieldName = "email")
                    var email: @NotBlank @Email String,


                    var descricao: @NotBlank String
) {
    fun toAutor(): Autor{
        return Autor(nome=nome, email=email, descricao=descricao)
    }


}
