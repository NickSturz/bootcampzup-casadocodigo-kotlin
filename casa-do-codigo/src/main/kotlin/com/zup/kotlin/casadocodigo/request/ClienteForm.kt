package com.zup.kotlin.casadocodigo.request

import com.zup.cartaobrancokotlin.validators.DocumentoValido
import com.zup.kotlin.casadocodigo.model.Estado
import com.zup.kotlin.casadocodigo.model.Pais
import com.zup.kotlin.casadocodigo.repository.EstadoRepository
import com.zup.kotlin.casadocodigo.repository.PaisRepository
import org.springframework.util.Assert
import javax.persistence.Embeddable
import javax.persistence.OneToOne
import javax.validation.constraints.*

@Embeddable
data class ClienteForm (
        var email: @NotBlank @Email String,
        var nome: @NotBlank String,
        var sobrenome: @NotBlank String,
        @DocumentoValido
        var documento: @NotBlank String,
        var endereco: @NotBlank @Size(max = 400) String,
        var complemento: @NotBlank @Size(max = 350) String,
        var cidade: @NotBlank String,
        var paisNome: @NotNull String,
        var estadoNome: String? = null,
        var telefone: @NotBlank String,
        var cep: @Size(min = 8, max = 50) @NotBlank String,

) {

}
