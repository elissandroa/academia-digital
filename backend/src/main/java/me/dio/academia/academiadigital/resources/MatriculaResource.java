package me.dio.academia.academiadigital.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import jakarta.validation.Valid;
import me.dio.academia.academiadigital.dto.MatriculaDTO;
import me.dio.academia.academiadigital.services.MatriculaService;

@RestController
@RequestMapping(value = "/matriculas")
public class MatriculaResource {
	
	@Autowired
	private MatriculaService service;
	
	@GetMapping
	public ResponseEntity<List<MatriculaDTO>> findAll(){
		List<MatriculaDTO> Matriculas = service.findAll();
		return ResponseEntity.ok().body(Matriculas);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<MatriculaDTO> findById(@PathVariable Long id){
		MatriculaDTO Matricula = service.findById(id);
		return ResponseEntity.ok().body(Matricula);
	}
	
	@PostMapping
	public ResponseEntity<MatriculaDTO> insert(@Valid @RequestBody MatriculaDTO dto){
		dto = service.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(dto);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<MatriculaDTO> update(@Valid @RequestBody MatriculaDTO dto, @PathVariable Long id){
		dto = service.update(id, dto);
		return ResponseEntity.ok().body(dto);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<MatriculaDTO> delete (@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	

}
