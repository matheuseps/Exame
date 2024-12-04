package com.cadastroseriestv.cadastro_de_series_tv.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Serie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome da série não pode estar vazio.")
    private String nome;

    @NotBlank(message = "O gênero não pode estar vazio.")
    private String genero;

    @NotBlank(message = "O ano de lançamento deve ser informado.")
    private Integer anoLancamento;

    @Min(value = 1, message = "A quantidade de temporadas deve ser um número positivo.")
    private Integer qtdTemporadas;

    @NotBlank(message = "A classificação indicativa não pode estar vazia.")
    private String classificacao;

    // Getters e Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Integer getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(Integer anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

    public Integer getQtdTemporadas() {
        return qtdTemporadas;
    }

    public void setQtdTemporadas(Integer qtdTemporadas) {
        this.qtdTemporadas = qtdTemporadas;
    }

    public String getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(String classificacao) {
        this.classificacao = classificacao;
    }
}
