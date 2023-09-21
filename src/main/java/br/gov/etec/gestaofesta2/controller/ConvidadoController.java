package br.gov.etec.gestaofesta2.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import br.gov.etec.gestaofesta2.model.Convidado;
import br.gov.etec.gestaofesta2.repository.ConvidadoRepository;

@Controller
@RequestMapping("convidado")
public class ConvidadoController {
	
	@Autowired
	private ConvidadoRepository repo;
	
	@GetMapping("home")
	public String openScreen() {
		return "convidado.html";
	}
	
	@PostMapping("salvar")
	public ModelAndView salvarConvidado(Convidado convidado) {
		
		repo.save(convidado);
		List<Convidado> listaConvidados = repo.findAll();
		ModelAndView view = new ModelAndView("lista-convidado.html");
		view.addObject("convidados", listaConvidados);
		return view;
		
	}
	
	@GetMapping("lista-convidados")
	public ModelAndView listaConvidados() {
		
		List<Convidado> listaConvidados = repo.findAll();
		ModelAndView view = new ModelAndView("lista-convidado.html");
		view.addObject("convidados", listaConvidados);
		return view;
		
	}
	
	@GetMapping("excluir/{id}")
	public ModelAndView excluirConvidado(@PathVariable Long id) {
		repo.deleteById(id);
		List<Convidado> listaConvidados = repo.findAll();
		ModelAndView view = new ModelAndView("lista-convidado.html");
		view.addObject("convidados", listaConvidados);
		return view;
	}
	
	@GetMapping("editar/{id}")
	public ModelAndView editar(@PathVariable Long id) {
		Convidado c = repo.findById(id).get();
		ModelAndView view = new ModelAndView("editar");
		view.addObject("convidado", c);
		return view;
	}
	
}
