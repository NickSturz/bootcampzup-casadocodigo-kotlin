package com.zup.kotlin.casadocodigo.response

import com.zup.kotlin.casadocodigo.model.Autor
import com.zup.kotlin.casadocodigo.model.Livro

class LivroListarSimples(
        var titulo: String,
        var nomeAutor: Autor
) {

    constructor(livro: Livro): this(
            titulo = livro.titulo,
            nomeAutor = livro.autor

    )
}