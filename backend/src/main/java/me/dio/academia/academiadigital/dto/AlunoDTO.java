package me.dio.academia.academiadigital.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import me.dio.academia.academiadigital.entities.Aluno;
import me.dio.academia.academiadigital.entities.AvaliacaoFisica;

public class AlunoDTO {

	private Long id;
	private String nome;
	private String cpf;
	private String bairro;
	private LocalDate dataDeNascimento;
	
	private List<AvaliacaoFisicaDTO> avaliacoes = new ArrayList<>();	
	
	public AlunoDTO() {
	}

	public AlunoDTO(Long id, String nome, String cpf, String bairro, LocalDate dataDeNascimento) {
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.bairro = bairro;
		this.dataDeNascimento = dataDeNascimento;
	}
	
	public AlunoDTO(Aluno entity) {
		this.id = entity.getId();
		this.nome = entity.getNome();
		this.cpf = entity.getCpf();
		this.bairro = entity.getBairro();
		this.dataDeNascimento = entity.getDataDeNascimento();
	}
	
	public AlunoDTO(Aluno entity, Set<AvaliacaoFisica> avaliacoes) {
		this(entity);
		avaliacoes.forEach(avaliacao -> this.avaliacoes.add(new AvaliacaoFisicaDTO(avaliacao)));
	}

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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public LocalDate getDataDeNascimento() {
		return dataDeNascimento;
	}

	public void setDataDeNascimento(LocalDate dataDeNascimento) {
		this.dataDeNascimento = dataDeNascimento;
	}

	public List<AvaliacaoFisicaDTO> getAvaliacoes() {
		return avaliacoes;
	}
	
}
