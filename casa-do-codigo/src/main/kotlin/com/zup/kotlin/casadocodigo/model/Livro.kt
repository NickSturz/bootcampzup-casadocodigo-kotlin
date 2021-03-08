package com.zup.kotlin.casadocodigo.model

import com.fasterxml.jackson.annotation.JsonFormat
import org.hibernate.annotations.GenericGenerator

import java.math.BigDecimal
import java.time.LocalDate
import javax.persistence.*
import javax.validation.constraints.*

@Entity
data class Livro(
        var titulo: @NotBlank @Size(max = 100) String,
        var resumo: @NotBlank @Size(max = 500) String,
        var preco: @NotNull @Min(20) BigDecimal,
        var sumario: @NotBlank String,
        var numeroPaginas: @Min(100) Int,
        var isbn: @NotBlank String,
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
        var dataPublicacao: @NotNull @Future LocalDate,
        @ManyToOne
        var autor: @NotNull Autor,
        @ManyToOne
        var categoria: @NotNull Categoria)
{

    @Id @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    var id: String = ""

}
