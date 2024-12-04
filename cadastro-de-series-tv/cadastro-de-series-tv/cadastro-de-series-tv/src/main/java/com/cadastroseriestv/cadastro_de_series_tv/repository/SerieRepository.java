package com.cadastroseriestv.cadastro_de_series_tv.repository; // Corrigido para o pacote correto

import java.util.List; // Certifique-se de importar o List

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cadastroseriestv.cadastro_de_series_tv.model.Serie;

@Repository
public interface SerieRepository extends JpaRepository<Serie, Long> {

    // Encontrar séries pelo nome
    List<Serie> findByNome(String nome);

    // Encontrar séries pelo gênero
    List<Serie> findByGenero(String genero);

    // Encontrar séries por ano de lançamento
    List<Serie> findByAnoLancamento(Integer anoLancamento);

    // Encontrar séries com base no nome e gênero
    List<Serie> findByNomeAndGenero(String nome, String genero);

    // Encontrar séries com quantidade de temporadas maior que um valor
    List<Serie> findByQtdTemporadasGreaterThan(Integer qtdTemporadas);

    // Encontrar séries por classificação indicativa
    List<Serie> findByClassificacao(String classificacao);

    // Método de pesquisa que pode ser mais flexível com base em parâmetros
    List<Serie> findByNomeContainingIgnoreCase(String nome);
}
