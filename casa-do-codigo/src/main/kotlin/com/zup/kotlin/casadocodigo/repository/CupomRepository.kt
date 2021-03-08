package com.zup.kotlin.casadocodigo.repository

import com.zup.kotlin.casadocodigo.model.Cupom
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface CupomRepository : CrudRepository<Cupom, String> {
    fun findByCodigo(codigoCupom: String): Cupom
}