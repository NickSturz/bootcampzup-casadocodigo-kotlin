package com.zup.kotlin.casadocodigo.model

import com.zup.kotlin.casadocodigo.repository.EstadoRepository
import com.zup.kotlin.casadocodigo.repository.PaisRepository
import com.zup.kotlin.casadocodigo.request.CarrinhoForm
import com.zup.kotlin.casadocodigo.request.ClienteForm
import org.hibernate.annotations.GenericGenerator
import org.springframework.util.Assert
import org.springframework.util.StringUtils
import java.math.BigDecimal
import javax.persistence.*
import javax.validation.Valid

@Entity
data class Compra(
        @Embedded
        val dadosCliente: @Valid ClienteForm,

        @Embedded
        val carrinhoCompra: @Valid CarrinhoForm,
        @ManyToOne
        var cupom: Cupom? = null

    ){

    @Id @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    var id: String = ""





    fun possuiCupom(): Boolean{
        System.out.println("chegou no boolean de cupom")
        return !StringUtils.isEmpty(cupom)
    }

    fun valorComDesconto():BigDecimal{
        System.out.println("chegou no valor com desconto")

        var totalComDesconto = carrinhoCompra.totalCompra.minus(cupom!!.desconto)

        return totalComDesconto
    }



}
