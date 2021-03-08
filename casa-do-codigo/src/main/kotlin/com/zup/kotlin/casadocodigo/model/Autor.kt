package com.zup.kotlin.casadocodigo.model

import java.time.LocalDateTime
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank

@Entity
data class Autor(
                 var nome: @NotBlank String,
                 var email: @NotBlank @Email String,
                 var descricao: @NotBlank String,

) {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: String = ""

    var createdAt: LocalDateTime = LocalDateTime.now()
}
