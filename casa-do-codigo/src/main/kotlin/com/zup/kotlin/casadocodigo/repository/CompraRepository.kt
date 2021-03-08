package com.zup.kotlin.casadocodigo.repository

import com.zup.kotlin.casadocodigo.model.Compra
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface CompraRepository : JpaRepository<Compra, String>