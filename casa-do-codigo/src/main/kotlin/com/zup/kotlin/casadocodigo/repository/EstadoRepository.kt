package com.zup.kotlin.casadocodigo.repository

import com.zup.kotlin.casadocodigo.model.Estado
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface EstadoRepository : JpaRepository<Estado, String> {
    fun findByEstado(estado: Estado?): Estado
    fun findByPaisId(paisNome: String): Estado
}