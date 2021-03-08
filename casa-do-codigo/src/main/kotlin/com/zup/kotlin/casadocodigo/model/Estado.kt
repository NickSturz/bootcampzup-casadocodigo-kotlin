package com.zup.kotlin.casadocodigo.model

import org.hibernate.annotations.GenericGenerator
import javax.persistence.*
import javax.validation.constraints.NotBlank

@Entity
data class Estado (
               var estado: @NotBlank String,
               @ManyToOne
               var pais: Pais )
{

    @Id @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    val id: String = ""

}
