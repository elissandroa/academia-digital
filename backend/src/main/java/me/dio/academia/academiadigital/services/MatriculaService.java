package me.dio.academia.academiadigital.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import me.dio.academia.academiadigital.dto.MatriculaDTO;
import me.dio.academia.academiadigital.entities.Matricula;
import me.dio.academia.academiadigital.repositories.MatriculaRepository;
import me.dio.academia.academiadigital.services.exceptions.DatabaseException;
import me.dio.academia.academiadigital.services.exceptions.EntityNotFoundExceptionService;

@Service
public class MatriculaService {

	@Autowired
	private MatriculaRepository repository;
	
	
	@Transactional(readOnly = true)
	public List<MatriculaDTO> findAll(){
		List<Matricula>Matriculas = repository.findAll();
		return Matriculas.stream().map(x -> new MatriculaDTO(x)).toList();
	}
	
	@Transactional(readOnly = true)
	public MatriculaDTO findById(Long id){
		Optional<Matricula> MatriculaPorId = repository.findById(id);
		Matricula entity = MatriculaPorId.orElseThrow(() -> new EntityNotFoundExceptionService("Entity not found"));
		return new MatriculaDTO(entity);
	}
	
	@Transactional
	public MatriculaDTO insert(MatriculaDTO dto) {
		Matricula entity = new Matricula();
		entity.setAluno(dto.getAluno());
		entity.setDataDaMatricula(LocalDate.now());
		entity = repository.save(entity);
		return new MatriculaDTO(entity);

	}

		
	@Transactional
	public MatriculaDTO update(Long id, MatriculaDTO dto) {
		try {
			Matricula entity = repository.getReferenceById(id);
			entity.setAluno(dto.getAluno());
			return new MatriculaDTO(entity);
		} catch (EntityNotFoundExceptionService e) {
			throw new EntityNotFoundExceptionService("Id not found "+id);
		}
	}
	
	public void delete (Long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new EntityNotFoundExceptionService("Id not found" + id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException("Integrity violation");
		}
	}
	
}
