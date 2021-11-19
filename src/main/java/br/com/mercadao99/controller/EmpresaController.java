package br.com.mercadao99.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.mercadao99.model.Empresa;
import br.com.mercadao99.repository.EmpresaRepository;

@Controller
public class EmpresaController {

	@Autowired
	private EmpresaRepository repository;
	
	@GetMapping("/")
	public ModelAndView index() {
		List<Empresa> empresas = repository.findAll();
		ModelAndView mav = new ModelAndView("index");
		mav.addObject("empresas", empresas);
		return mav;
	}
	
	@GetMapping("/create-company")
	public String create(Empresa empresa) {
		return "create-company";
	}
	
	@PostMapping("/create-company")
	public String save(@Valid Empresa empresa, BindingResult result, RedirectAttributes redirect){
		if (result.hasErrors()) {
			return "create-company";
		}
		repository.save(empresa);
		redirect.addFlashAttribute("msg", "Empresa cadastrada com sucesso!");
		return "redirect:/";
	}
}
