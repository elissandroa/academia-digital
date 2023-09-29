package me.dio.academia.academiadigital.dto;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;
import me.dio.academia.academiadigital.entities.Aluno;
import me.dio.academia.academiadigital.entities.AvaliacaoFisica;

public class AvaliacaoFisicaDTO {
	private Long id;
	private Aluno aluno;
	private LocalDateTime dataDaAvaliacao;
	@NotBlank
	private double peso;
	@NotBlank
	private double altura;
	
	public AvaliacaoFisicaDTO() {
	}

	public AvaliacaoFisicaDTO(Long id, Aluno aluno, LocalDateTime dataDaAvaliacao, double peso, double altura) {
		this.id = id;
		this.aluno = aluno;
		this.dataDaAvaliacao = dataDaAvaliacao;
		this.peso = peso;
		this.altura = altura;
	}
	
	public AvaliacaoFisicaDTO(AvaliacaoFisica entity) {
		this.id = entity.getId();
		this.aluno = entity.getAluno();
		this.dataDaAvaliacao = entity.getDataDaAvaliacao();
		this.peso = entity.getPeso();
		this.altura = entity.getAltura();
	}
		

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public LocalDateTime getDataDaAvaliacao() {
		return dataDaAvaliacao;
	}

	public void setDataDaAvaliacao(LocalDateTime dataDaAvaliacao) {
		this.dataDaAvaliacao = dataDaAvaliacao;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}

}
