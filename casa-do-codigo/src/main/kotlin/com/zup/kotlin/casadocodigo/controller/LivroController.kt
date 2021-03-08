package com.zup.kotlin.casadocodigo.controller

import com.zup.kotlin.casadocodigo.model.Livro
import com.zup.kotlin.casadocodigo.repository.AutorRepository
import com.zup.kotlin.casadocodigo.repository.CategoriaRepository
import com.zup.kotlin.casadocodigo.repository.LivroRepository
import com.zup.kotlin.casadocodigo.request.NovoLivroForm
import com.zup.kotlin.casadocodigo.response.LivroListar
import com.zup.kotlin.casadocodigo.response.LivroListarSimples
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder
import javax.validation.Valid

@RestController
@RequestMapping("/casa/livro")
class LivroController(private val livroRepository: LivroRepository, private val autorRepository: AutorRepository,  private val categoriaRepository: CategoriaRepository) {

    //adicionar livros e detalhes
    @PostMapping
    fun novoLivro(@Valid @RequestBody form: NovoLivroForm, uriComponentsBuilder: UriComponentsBuilder): ResponseEntity<Livro> {
        val novoLivro = form.novoLivro(autorRepository, categoriaRepository)
        val livroSalvo = livroRepository.save(novoLivro)

        return ResponseEntity.created(uriComponentsBuilder.path("/livros/${livroSalvo.id}").build().toUri())
                .build();
    }

    //Achar todos livros e detalhes
    @GetMapping("/todosLivros")
    fun listaLivros(): ResponseEntity<List<LivroListar>> {
        val todosOsLivros = livroRepository.findAll() as List<LivroListar>


        return ResponseEntity.ok().body(todosOsLivros)
    }

    //Achar apenas nome do livro e autor
    @GetMapping("/todosLivrosSimples")
    fun listarLivrosSimples(): ResponseEntity<List<LivroListarSimples>> {
        val todosOsLivrosSimples = livroRepository.findAll() as List<LivroListarSimples>


        return ResponseEntity.ok().body(todosOsLivrosSimples)
    }

    @GetMapping("/listarSimples")
    fun toList(livro: List<Livro>): List<LivroListarSimples>{

        val listarSimples = livroRepository.findAll() as List<LivroListarSimples>

       return listarSimples
    }
}
