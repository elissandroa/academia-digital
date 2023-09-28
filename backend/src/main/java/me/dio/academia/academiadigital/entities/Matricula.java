package me.dio.academia.academiadigital.entities;

import java.time.LocalDate;
import java.util.Objects;

public class Matricula {

	private Long id;
	private Aluno aluno;
	private LocalDate dataDaMatricula;
		
	public Matricula() {
	}

	public Matricula(Long id, Aluno aluno, LocalDate dataDaMatricula) {
		this.id = id;
		this.aluno = aluno;
		this.dataDaMatricula = dataDaMatricula;
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

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Matricula other = (Matricula) obj;
		return Objects.equals(id, other.id);
	}

}
