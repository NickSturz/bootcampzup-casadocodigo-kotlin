package com.zup.kotlin.casadocodigo.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.validation.constraints.NotBlank

@Entity
data class Categoria (
                 var categoria: @NotBlank String
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: String = ""
}