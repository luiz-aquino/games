package br.com.luizaquino.games.service

import br.com.luizaquino.games.model.Game
import br.com.luizaquino.games.repository.GameRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service


@Service
class GameService {

    @Autowired
    lateinit var gameRepository: GameRepository

    fun buscarTodos(): List<Game> {
        return gameRepository.findAll()
    }

    fun salver(game: Game) {
        gameRepository.save(game)
    }

    fun buscarPorNome(nome: String) : List<Game> {
        return gameRepository.findByNomeIgnoreCaseContaining(nome);
    }

    fun apagar(id: String) {
        return gameRepository.deleteById(id)
    }
}