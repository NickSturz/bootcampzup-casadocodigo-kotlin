package com.zup.kotlin.casadocodigo.response

import com.zup.kotlin.casadocodigo.model.Autor
import com.zup.kotlin.casadocodigo.model.Categoria
import com.zup.kotlin.casadocodigo.model.Livro
import java.math.BigDecimal
import java.time.LocalDate

public class LivroListar(
        var id: String,
        var titulo: String,
        var resumo: String,
        var preco: BigDecimal,
        var sumario: String,
        var numeroPaginas: Int,
        var isbn: String,
        var dataPublicacao: LocalDate,
        var nomeAutor: Autor,
        var nomeCategoria: Categoria

) {
    constructor(livro: Livro): this(
            id = livro.id,
            titulo = livro.titulo,
            resumo = livro.resumo,
            sumario = livro.sumario,
            preco = livro.preco,
            numeroPaginas = livro.numeroPaginas,
            isbn = livro.isbn,
            dataPublicacao = livro.dataPublicacao,
            nomeAutor = livro.autor,
            nomeCategoria = livro.categoria
    )
}
