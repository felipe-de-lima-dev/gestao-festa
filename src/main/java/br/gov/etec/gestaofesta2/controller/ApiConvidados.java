package br.gov.etec.gestaofesta2.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import br.gov.etec.gestaofesta2.model.Convidado;
import br.gov.etec.gestaofesta2.repository.ConvidadoRepository;

@RestController
public class ApiConvidados {
	
	@Autowired
	ConvidadoRepository repo;
	
	@GetMapping("convidados")
	public ResponseEntity<?> convidados() {
		List<Convidado> lista = repo.findAll();
		return new ResponseEntity<>(lista, HttpStatus.OK);
	}
	
}
