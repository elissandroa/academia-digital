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
import me.dio.academia.academiadigital.dto.AvaliacaoFisicaDTO;
import me.dio.academia.academiadigital.services.AvaliacaoFisicaService;

@RestController
@RequestMapping(value = "/avaliacoes")
public class AvaliacaoFisicaResource {
	
	@Autowired
	private AvaliacaoFisicaService service;
	
	@GetMapping
	public ResponseEntity<List<AvaliacaoFisicaDTO>> findAll(){
		List<AvaliacaoFisicaDTO> AvaliacaoFisicas = service.findAll();
		return ResponseEntity.ok().body(AvaliacaoFisicas);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<AvaliacaoFisicaDTO> findById(@PathVariable Long id){
		AvaliacaoFisicaDTO AvaliacaoFisica = service.findById(id);
		return ResponseEntity.ok().body(AvaliacaoFisica);
	}
	
	@PostMapping
	public ResponseEntity<AvaliacaoFisicaDTO> insert(@Valid @RequestBody AvaliacaoFisicaDTO dto){
		dto = service.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(dto);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<AvaliacaoFisicaDTO> update(@Valid @RequestBody AvaliacaoFisicaDTO dto, @PathVariable Long id){
		dto = service.update(id, dto);
		return ResponseEntity.ok().body(dto);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<AvaliacaoFisicaDTO> delete (@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	

}
