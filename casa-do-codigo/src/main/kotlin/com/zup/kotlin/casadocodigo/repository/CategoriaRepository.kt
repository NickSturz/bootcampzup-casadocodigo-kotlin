package com.zup.kotlin.casadocodigo.repository

import com.zup.kotlin.casadocodigo.model.Categoria
import org.springframework.data.jpa.repository.JpaRepository

interface CategoriaRepository: JpaRepository <Categoria, String> {
    fun findByCategoria(categoria: String): Categoria


}