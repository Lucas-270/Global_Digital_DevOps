package br.com.mercadao99.controller;


import br.com.mercadao99.model.Address;
import br.com.mercadao99.model.User;
import br.com.mercadao99.repository.UserRepository;
import br.com.mercadao99.service.AuthenticationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserRepository repository;
	
	@Autowired
	private MessageSource messages;

	@Autowired
	private Address addressRepository;


	@GetMapping
	public ModelAndView index() {
		ModelAndView modelAndView = new ModelAndView("users");
		List<User> users = repository.findAll();
		modelAndView.addObject("users", users);
		System.out.println(users);
		return modelAndView;
	}
	
	@RequestMapping("new")
	public String create(User user) {
		return "usuario-cadastro";
	}

	@PostMapping
	public String save(@Valid User user, BindingResult result, RedirectAttributes redirect) {
		if(result.hasErrors()) return "usuario-cadastro";
		user.setPassword(AuthenticationService.getPasswordEncoder().encode(user.getPassword()));
		repository.save(user);
		Optional<User> username = repository.findByEmail(user.getUsername());
		redirect.addFlashAttribute("message", messages.getMessage("newuser.success", null, LocaleContextHolder.getLocale()));
		return "redirect:user";
	}

}
