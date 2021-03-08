package com.zup.kotlin.casadocodigo.controller

import com.zup.kotlin.casadocodigo.model.Estado
import com.zup.kotlin.casadocodigo.repository.EstadoRepository
import com.zup.kotlin.casadocodigo.repository.PaisRepository
import com.zup.kotlin.casadocodigo.request.NovoEstadoForm
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder
import javax.transaction.Transactional
import javax.validation.Valid

@RestController
@RequestMapping("/casa/estado")
class EstadoController (private val estadoRepository: EstadoRepository,  private val paisRepository: PaisRepository ) {

    @PostMapping
    fun novoEstado(@Valid @RequestBody form: NovoEstadoForm, uriComponentsBuilder: UriComponentsBuilder): ResponseEntity<Estado> {

        val novoEstado = form.novoEstado(paisRepository)

        val estadoSalvo = estadoRepository.save(novoEstado)

        return ResponseEntity.created(uriComponentsBuilder.path("/estados/${estadoSalvo.id}").build().toUri())
                .build();
    }
}