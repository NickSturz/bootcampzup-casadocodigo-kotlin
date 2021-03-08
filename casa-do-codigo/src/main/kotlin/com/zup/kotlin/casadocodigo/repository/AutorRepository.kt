package com.zup.kotlin.casadocodigo.repository

import com.zup.kotlin.casadocodigo.model.Autor
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface AutorRepository : JpaRepository<Autor, String> {
    override fun findById(Id: String): Optional<Autor>
    fun findByNome(nome: String): Autor
}
