package com.cadastroseriestv.cadastro_de_series_tv.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cadastroseriestv.cadastro_de_series_tv.Service.SerieService;
import com.cadastroseriestv.cadastro_de_series_tv.model.Serie; // Import correto do modelo

@RestController
@RequestMapping("/api/series")
public class SerieController {

    @Autowired
    private SerieService serieService; // Correto: injetando o serviço

    // Listar todas as séries com paginação
    @GetMapping
    public ResponseEntity<Page<Serie>> listarSeries(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        Page<Serie> series = serieService.listarSeries(page, size);
        return ResponseEntity.ok(series);
    }

    // Consultar uma série por ID
    @GetMapping("/{id}")
    public ResponseEntity<Serie> consultarSerie(@PathVariable Long id) {
        return serieService.consultarSeriePorId(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Adicionar uma nova série
    @PostMapping
    public ResponseEntity<Serie> adicionarSerie(@Validated @RequestBody Serie serie) {
        Serie novaSerie = serieService.adicionarSerie(serie);
        return new ResponseEntity<>(novaSerie, HttpStatus.CREATED);
    }

    // Atualizar uma série existente
    @PutMapping("/{id}")
    public ResponseEntity<Serie> atualizarSerie(@PathVariable Long id, @Validated @RequestBody Serie serie) {
        Serie updatedSerie = serieService.atualizarSerie(id, serie);
        return updatedSerie != null ? ResponseEntity.ok(updatedSerie) : ResponseEntity.notFound().build();
    }

    // Remover uma série
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removerSerie(@PathVariable Long id) {
        boolean removed = serieService.removerSerie(id);
        return removed ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
