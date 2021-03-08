package com.zup.kotlin.casadocodigo.controller

import com.zup.kotlin.casadocodigo.model.Pais
import com.zup.kotlin.casadocodigo.repository.PaisRepository
import com.zup.kotlin.casadocodigo.request.NovoPaisForm
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder
import javax.validation.Valid

@RestController
@RequestMapping("/casa/pais")
class PaisController(private val paisRepository: PaisRepository) {

    @PostMapping
    fun novoPais(@Valid @RequestBody form: NovoPaisForm, uriComponentsBuilder: UriComponentsBuilder): ResponseEntity<Pais> {
        val novoPais: Pais = form.novoPais()

        val paisSalvo = paisRepository.save(novoPais)

        return ResponseEntity.created(uriComponentsBuilder.path("/paises/${paisSalvo.id.toString()}").build().toUri())
        .build();

    }
}
