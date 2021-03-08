package com.zup.kotlin.casadocodigo.controller

import com.zup.kotlin.casadocodigo.model.Categoria
import com.zup.kotlin.casadocodigo.repository.CategoriaRepository
import com.zup.kotlin.casadocodigo.request.NovaCategoriaForm
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder
import javax.transaction.Transactional
import javax.validation.Valid

@RestController
@RequestMapping("/casa/categoria")
class CategoriaController(private val categoriaRepository: CategoriaRepository) {

    @PostMapping
    fun novaCategoria(@Valid @RequestBody form:  NovaCategoriaForm, uriComponentsBuilder: UriComponentsBuilder): ResponseEntity<Categoria> {

        val categoria = form.toCategoria()

        val categoriaSalva = categoriaRepository.save(categoria)

        return ResponseEntity.created(uriComponentsBuilder.path("/categorias/${categoriaSalva.id}").build().toUri()).build();
    }
}