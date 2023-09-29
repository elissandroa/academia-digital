package me.dio.academia.academiadigital.dto;

import java.time.LocalDate;

import me.dio.academia.academiadigital.entities.Aluno;
import me.dio.academia.academiadigital.entities.Matricula;

public class MatriculaDTO {

	private Long id;
	private Aluno aluno;
	private LocalDate dataDaMatricula;
	
	public MatriculaDTO() {
	}

	public MatriculaDTO(Long id, Aluno aluno, LocalDate dataDaMatricula) {
		this.id = id;
		this.aluno = aluno;
		this.dataDaMatricula = dataDaMatricula;
	}
	
	public MatriculaDTO(Matricula entity) {
		this.id = entity.getId();
		this.aluno = entity.getAluno();
		this.dataDaMatricula = entity.getDataDaMatricula();
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

	public LocalDate getDataDaMatricula() {
		return dataDaMatricula;
	}

	public void setDataDaMatricula(LocalDate dataDaMatricula) {
		this.dataDaMatricula = dataDaMatricula;
	}
	
}
