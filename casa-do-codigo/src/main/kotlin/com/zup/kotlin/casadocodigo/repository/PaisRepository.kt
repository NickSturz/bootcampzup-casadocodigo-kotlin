package com.zup.kotlin.casadocodigo.repository

import com.zup.kotlin.casadocodigo.model.Pais
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import javax.validation.constraints.NotBlank

@Repository
interface PaisRepository : JpaRepository<Pais, String> {
    fun findByPais(pais: @NotBlank String): Pais
}