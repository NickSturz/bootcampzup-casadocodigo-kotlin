package com.zup.kotlin.casadocodigo.model

import org.hibernate.annotations.GenericGenerator
import java.math.BigDecimal
import java.time.LocalDateTime
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.validation.constraints.*

@Entity
data class Cupom (
              var codigo: @NotBlank String,
              var validade: @Future @NotNull LocalDateTime,
              var desconto: @Positive @DecimalMin("0.01") BigDecimal
) {


    @Id @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    var id: String = ""

    val valido: Boolean
    get() = LocalDateTime.now() <= validade


}
