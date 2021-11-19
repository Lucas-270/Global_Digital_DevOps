package br.com.mercadao99.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.mercadao99.model.User;
import br.com.mercadao99.repository.UserRepository;

@Controller
public class UserController {

	@Autowired
	private UserRepository repository;
	
	@GetMapping("/create-user")
	public String create(User user) {
		return "create-user";
	}
	
	@PostMapping("/create-user")
	public String save(@Valid User user, BindingResult result, RedirectAttributes redirect){
		if (result.hasErrors()) {
			return "create-user";
		}
		repository.save(user);
		redirect.addFlashAttribute("msg", "Usuário cadastrada com sucesso!");
		return "redirect:/companies";
	}
}
