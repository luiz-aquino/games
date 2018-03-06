package br.com.luizaquino.games.controller

import br.com.luizaquino.games.model.Game
import br.com.luizaquino.games.service.GameService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@CrossOrigin
@RequestMapping(value = "/game")
class GameController {

    @Autowired
    lateinit var gameService: GameService

    @GetMapping
    fun buscarTodos(): List<Game> {
        return  gameService.buscarTodos()
    }

    @GetMapping(value = "/titulo/{titulo}")
    fun buscarTodos(@PathVariable(value = "titulo") titulo: String): List<Game> {
        return  gameService.buscarPorNome(titulo)
    }

    @PostMapping
    fun salvar(@RequestBody game: Game) {
        gameService.salver(game)
    }

    @DeleteMapping(value = "{id}")
    fun remover(@PathVariable(value = "id") id: String){
        gameService.apagar(id)
    }


}