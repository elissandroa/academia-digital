package me.dio.academia.academiadigital.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import me.dio.academia.academiadigital.entities.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long>  {

}
