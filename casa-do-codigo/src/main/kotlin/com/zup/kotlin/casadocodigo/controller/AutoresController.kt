package com.zup.kotlin.casadocodigo.controller

import com.zup.kotlin.casadocodigo.model.Autor
import com.zup.kotlin.casadocodigo.repository.AutorRepository
import com.zup.kotlin.casadocodigo.request.NovoAutorForm
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder
import org.springframework.web.util.UriComponentsBuilder
import javax.transaction.Transactional
import javax.validation.Valid
import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank


@RestController
@RequestMapping("/casa/autor")
class AutoresController(private var autorRepository: AutorRepository) {

    @PostMapping
    fun novoAutor(@Valid @RequestBody novoAutorForm: NovoAutorForm, uriComponentsBuilder: UriComponentsBuilder):ResponseEntity<Autor> {


        val autor = novoAutorForm.toAutor()

        val autorSalvo = autorRepository.save(autor)


        return ResponseEntity
                .created(uriComponentsBuilder.path("/autores/${autorSalvo.id}").build().toUri())
                .build();
    }

}
