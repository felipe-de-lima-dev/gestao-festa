package br.gov.etec.gestaofesta2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import br.gov.etec.gestaofesta2.model.Convidado;
import br.gov.etec.gestaofesta2.model.Login;
import br.gov.etec.gestaofesta2.repository.ConvidadoRepository;
import br.gov.etec.gestaofesta2.repository.LoginRepository;

@RestController
public class ApiLogin {

	@Autowired 
	LoginRepository repo;
	
	@GetMapping("logins")
	public ResponseEntity<?> logins() {
		List<Login> lista = repo.findAll();
		return new ResponseEntity<>(lista, HttpStatus.OK);
	}
	
}
