package me.dio.academia.academiadigital.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import me.dio.academia.academiadigital.dto.AlunoDTO;
import me.dio.academia.academiadigital.dto.AvaliacaoFisicaDTO;
import me.dio.academia.academiadigital.entities.Aluno;
import me.dio.academia.academiadigital.entities.AvaliacaoFisica;
import me.dio.academia.academiadigital.repositories.AlunoRepository;
import me.dio.academia.academiadigital.repositories.AvaliacaoFisicaRepository;
import me.dio.academia.academiadigital.services.exceptions.DatabaseException;
import me.dio.academia.academiadigital.services.exceptions.EntityNotFoundExceptionService;

@Service
public class AlunoService {

	@Autowired
	private AlunoRepository repository;
	
	@Autowired
	private AvaliacaoFisicaRepository avaliacaoFisicaRepository;
	
	@Transactional(readOnly = true)
	public List<AlunoDTO> findAll(){
		List<Aluno>alunos = repository.findAll();
		return alunos.stream().map(x -> new AlunoDTO(x)).toList();
	}
	
	@Transactional(readOnly = true)
	public AlunoDTO findById(Long id){
		Optional<Aluno> alunoPorId = repository.findById(id);
		Aluno entity = alunoPorId.orElseThrow(() -> new EntityNotFoundExceptionService("Entity not found"));
		return new AlunoDTO(entity);
	}
	
	@Transactional
	public AlunoDTO insert(AlunoDTO dto) {
		Aluno entity = new Aluno();
		copyDtoToEntity(dto, entity);
		entity = repository.save(entity);
		return new AlunoDTO(entity);

	}

	private void copyDtoToEntity(AlunoDTO dto, Aluno entity) {
		entity.setNome(dto.getNome());
		entity.setBairro(dto.getBairro());
		entity.setCpf(dto.getCpf());
		entity.setDataDeNascimento(dto.getDataDeNascimento());
		
		
		entity.getAvaliacoes().clear();
		
		for(AvaliacaoFisicaDTO avaliaDTO : dto.getAvaliacoes()) {
			AvaliacaoFisica avaliacao = avaliacaoFisicaRepository.getReferenceById(avaliaDTO.getId());
			entity.getAvaliacoes().add(avaliacao);
		}
	}
	
	@Transactional
	public AlunoDTO update(Long id, AlunoDTO dto) {
		try {
			Aluno entity = repository.getReferenceById(id);
			copyDtoToEntity(dto, entity);
			return new AlunoDTO(entity);
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
