package com.zup.kotlin.casadocodigo.controller

import com.zup.kotlin.casadocodigo.model.Compra
import com.zup.kotlin.casadocodigo.model.Cupom
import com.zup.kotlin.casadocodigo.repository.*
import com.zup.kotlin.casadocodigo.request.ClienteForm
import com.zup.kotlin.casadocodigo.request.NovaCompraForm
import org.springframework.http.ResponseEntity
import org.springframework.util.Assert
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder
import javax.validation.Valid
import javax.validation.constraints.AssertTrue

@RestController
@RequestMapping("/casa/carrinho/comprar")
class CompraController(private var livroRepository: LivroRepository, private var cupomRepository: CupomRepository,
                       private var compraRepository: CompraRepository, private var estadoRepository: EstadoRepository,
                       private var paisRepository: PaisRepository) {


    @PostMapping
    fun novaCompra(@Valid @RequestBody novaCompraForm: NovaCompraForm, uriComponentsBuilder: UriComponentsBuilder): ResponseEntity<Compra> {
        System.out.println("início do controller de compra")
        val novaCompra = novaCompraForm.toCompra(cupomRepository)
        System.out.println("chegou no final da compra form no controller")

        val compraSalva = compraRepository.save(novaCompra)

        return ResponseEntity.created(uriComponentsBuilder.path("/compras/${compraSalva.id}").build().toUri())
                .build();
    }

    @GetMapping("/{id}")
    fun Buscar(@PathVariable id: String): ResponseEntity<Compra> {
        return compraRepository.findById(id)
            .map { record -> ResponseEntity.ok().body(record) }
            .orElse(ResponseEntity.notFound().build())
    }
}
