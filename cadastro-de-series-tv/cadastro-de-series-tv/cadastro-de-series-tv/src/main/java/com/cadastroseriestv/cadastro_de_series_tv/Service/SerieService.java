package com.cadastroseriestv.cadastro_de_series_tv.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.cadastroseriestv.cadastro_de_series_tv.model.Serie;
import com.cadastroseriestv.cadastro_de_series_tv.repository.SerieRepository;

@Service
public class SerieService {

    @Autowired
    private SerieRepository serieRepository; // Correto: injetando o repositório

    // Listar todas as séries com paginação
    public Page<Serie> listarSeries(int page, int size) {
        return serieRepository.findAll(PageRequest.of(page, size)); // Corrigido: busca com paginação
    }

    // Consultar uma série por ID
    public Optional<Serie> consultarSeriePorId(Long id) {
        return serieRepository.findById(id); // Correto
    }

    // Adicionar uma nova série
    public Serie adicionarSerie(@Validated Serie serie) {
        return serieRepository.save(serie); // Correto: salva a série no repositório
    }

    // Atualizar uma série existente
    public Serie atualizarSerie(Long id, @Validated Serie serie) {
        if (serieRepository.existsById(id)) {
            serie.setId(id); // Atualiza o ID da série
            return serieRepository.save(serie); // Salva as mudanças
        }
        return null; // ou lançar exceção CustomException
    }

    // Remover uma série
    public boolean removerSerie(Long id) {
        if (serieRepository.existsById(id)) {
            serieRepository.deleteById(id); // Deleta a série
            return true;
        }
        return false; // Caso não exista
    }
}
