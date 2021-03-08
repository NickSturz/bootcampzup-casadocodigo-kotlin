package com.zup.kotlin.casadocodigo.request

import com.zup.kotlin.casadocodigo.model.Compra
import com.zup.kotlin.casadocodigo.repository.CupomRepository
import com.zup.kotlin.casadocodigo.repository.EstadoRepository
import com.zup.kotlin.casadocodigo.repository.PaisRepository
import org.springframework.util.Assert
import javax.validation.Valid

class NovaCompraForm(
        val dadosCliente: @Valid ClienteForm,


        val carrinhoCompra: @Valid CarrinhoForm,

        val cupomDesconto: String? = null
) {
    fun toCompra(cupomRepository: CupomRepository): Compra{



        val novaCompra = Compra(
                dadosCliente = dadosCliente,
                carrinhoCompra = carrinhoCompra,


        )

        if (cupomDesconto != null){
            System.out.println("Aqui puxa cupomDesconto $cupomDesconto")
            val cupomBuscadoPeloCodigo = cupomRepository.findByCodigo(cupomDesconto)
            Assert.notNull(cupomBuscadoPeloCodigo, "Cupom com código : $cupomDesconto, não encontrado")
            Assert.isTrue(cupomBuscadoPeloCodigo?.valido!!, "Cupom de Desconto expirado")
            System.out.println("Aqui puxa cupom busca pelo codifo $cupomBuscadoPeloCodigo")
            novaCompra.cupom = cupomBuscadoPeloCodigo

        }
        System.out.println("Aqui puxa cupom da compra do form ${novaCompra.cupom}")


        return novaCompra
    }

}
