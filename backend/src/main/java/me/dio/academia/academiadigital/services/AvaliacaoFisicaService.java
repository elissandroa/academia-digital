package me.dio.academia.academiadigital.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import me.dio.academia.academiadigital.dto.AvaliacaoFisicaDTO;
import me.dio.academia.academiadigital.entities.AvaliacaoFisica;
import me.dio.academia.academiadigital.repositories.AvaliacaoFisicaRepository;
import me.dio.academia.academiadigital.services.exceptions.DatabaseException;
import me.dio.academia.academiadigital.services.exceptions.EntityNotFoundExceptionService;

@Service
public class AvaliacaoFisicaService {

	@Autowired
	private AvaliacaoFisicaRepository repository;
	
	
	@Transactional(readOnly = true)
	public List<AvaliacaoFisicaDTO> findAll(){
		List<AvaliacaoFisica>AvaliacaoFisicas = repository.findAll();
		return AvaliacaoFisicas.stream().map(x -> new AvaliacaoFisicaDTO(x)).toList();
	}
	
	@Transactional(readOnly = true)
	public AvaliacaoFisicaDTO findById(Long id){
		Optional<AvaliacaoFisica> AvaliacaoFisicaPorId = repository.findById(id);
		AvaliacaoFisica entity = AvaliacaoFisicaPorId.orElseThrow(() -> new EntityNotFoundExceptionService("Entity not found"));
		return new AvaliacaoFisicaDTO(entity);
	}
	
	@Transactional
	public AvaliacaoFisicaDTO insert(AvaliacaoFisicaDTO dto) {
		AvaliacaoFisica entity = new AvaliacaoFisica();
		copyDtoToEntity(dto, entity);
		entity = repository.save(entity);
		return new AvaliacaoFisicaDTO(entity);

	}

	private void copyDtoToEntity(AvaliacaoFisicaDTO dto, AvaliacaoFisica entity) {
		entity.setAltura(dto.getAltura());
		entity.setAluno(dto.getAluno());
		entity.setDataDaAvaliacao(dto.getDataDaAvaliacao());
		entity.setPeso(dto.getPeso());
	}
	
	@Transactional
	public AvaliacaoFisicaDTO update(Long id, AvaliacaoFisicaDTO dto) {
		try {
			AvaliacaoFisica entity = repository.getReferenceById(id);
			copyDtoToEntity(dto, entity);
			return new AvaliacaoFisicaDTO(entity);
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
