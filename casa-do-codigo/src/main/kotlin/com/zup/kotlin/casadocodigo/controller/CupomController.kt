package com.zup.kotlin.casadocodigo.controller

import com.zup.kotlin.casadocodigo.model.Cupom
import com.zup.kotlin.casadocodigo.repository.CupomRepository
import com.zup.kotlin.casadocodigo.request.NovoCupomform
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder
import javax.transaction.Transactional
import javax.validation.Valid

@RestController
@RequestMapping("/casa/cupom")
public class CupomController(private var cupomRepository: CupomRepository) {

    @PostMapping
    @Transactional
    fun novoCupom(@Valid @RequestBody form: NovoCupomform, uriComponentsBuilder: UriComponentsBuilder):ResponseEntity<Cupom> {
        val novoCupom: Cupom = form.novoCupom()
        val cupomSalvo = cupomRepository.save(novoCupom)

        return ResponseEntity.created(uriComponentsBuilder.path("/cupons/${cupomSalvo.id}").build().toUri())
                .build();
    }

    @PutMapping("/{id}")
    @Transactional
    fun updateCupom(@PathVariable("id") id: String, @RequestBody form: NovoCupomform) {

        val cupomRefatorado = cupomRepository.findById(id).map { save ->
            form.codigo
            form.validade
            form.desconto
            val update: Cupom = cupomRepository.save(save)
            ResponseEntity.ok().body(update)

        }.orElse(ResponseEntity.notFound().build())

    }


}