package br.gov.etec.gestaofesta2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import br.gov.etec.gestaofesta2.model.Login;
import br.gov.etec.gestaofesta2.repository.LoginRepository;

@Controller
public class LoginController {
	
	@Autowired
	LoginRepository repo;
	
	@GetMapping("/")
	public String openLogin() {
		return "login.html";
	}
		
	@GetMapping("login/cadastrar")
	public String openRegister() {
		return "cadastro-login.html";
	}
	
	@PostMapping("/login/salvar")
	public String saveRegister(Login login) {
		repo.save(login);
		return "login.html";
	}
	
	@PostMapping("/efetuar-login")
	public String doLogin(Login login) {
		
		Login user = repo.findByEmail(login.getEmail());
		if(login.getEmail().equals(user.getEmail()) && login.getSenha().equals(user.getSenha())) {
			return "redirect:convidado/lista-convidados";
		} else {
			return "login.html";
		}
	}
	
}
