package com.zup.kotlin.casadocodigo.request

import java.math.BigDecimal
import javax.persistence.*

@Embeddable
data class CarrinhoForm (
     var totalCompra: BigDecimal,
     var totalItens: Int
){

}