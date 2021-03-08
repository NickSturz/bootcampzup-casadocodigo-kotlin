package com.zup.kotlin.casadocodigo.repository


import com.zup.kotlin.casadocodigo.model.Categoria
import com.zup.kotlin.casadocodigo.model.Livro
import org.springframework.data.jpa.repository.JpaRepository

interface LivroRepository: JpaRepository <Livro, String> {



}