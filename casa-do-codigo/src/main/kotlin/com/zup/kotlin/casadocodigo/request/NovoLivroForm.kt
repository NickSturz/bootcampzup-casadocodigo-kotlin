package com.zup.kotlin.casadocodigo.request

import com.fasterxml.jackson.annotation.JsonFormat
import com.zup.kotlin.casadocodigo.model.Livro
import com.zup.kotlin.casadocodigo.repository.AutorRepository
import com.zup.kotlin.casadocodigo.repository.CategoriaRepository
import com.zup.kotlin.casadocodigo.validators.ValorUnico
import java.math.BigDecimal
import java.time.LocalDate
import javax.validation.constraints.*

class NovoLivroForm(
    var titulo: @NotBlank @Size(max = 100) String,
    var resumo: @NotBlank @Size(max = 500) String,
    var preco: @Min(20) BigDecimal,
    var sumario: @NotBlank String,
    var numeroPaginas: @Min(100) Int,
    @ValorUnico(className = "Livro", fieldName = "isbn")
    var isbn: @NotBlank String,
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    var dataPublicacao: @NotNull @Future LocalDate,
    var autorNome: @NotNull String,
    var categoriaNome: String
) {
    fun novoLivro(autorRepository: AutorRepository, categoriaRepository: CategoriaRepository): Livro {

        val autorEncontrado = autorRepository.findByNome(autorNome)

        val categoriaEncontrada = categoriaRepository.findByCategoria(categoriaNome)

        return Livro (titulo =titulo, resumo =resumo, preco =preco, sumario =sumario, numeroPaginas =numeroPaginas,
                isbn =isbn, dataPublicacao =dataPublicacao, autor =autorEncontrado, categoria =categoriaEncontrada)
    }

}