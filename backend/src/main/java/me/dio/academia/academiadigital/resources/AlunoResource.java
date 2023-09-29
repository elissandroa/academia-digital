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
import me.dio.academia.academiadigital.dto.AlunoDTO;
import me.dio.academia.academiadigital.services.AlunoService;

@RestController
@RequestMapping(value = "/alunos")
public class AlunoResource {
	
	@Autowired
	private AlunoService service;
	
	@GetMapping
	public ResponseEntity<List<AlunoDTO>> findAll(){
		List<AlunoDTO> alunos = service.findAll();
		return ResponseEntity.ok().body(alunos);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<AlunoDTO> findById(@PathVariable Long id){
		AlunoDTO aluno = service.findById(id);
		return ResponseEntity.ok().body(aluno);
	}
	
	@PostMapping
	public ResponseEntity<AlunoDTO> insert(@Valid @RequestBody AlunoDTO dto){
		dto = service.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(dto);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<AlunoDTO> update(@Valid @RequestBody AlunoDTO dto, @PathVariable Long id){
		dto = service.update(id, dto);
		return ResponseEntity.ok().body(dto);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<AlunoDTO> delete (@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	

}
