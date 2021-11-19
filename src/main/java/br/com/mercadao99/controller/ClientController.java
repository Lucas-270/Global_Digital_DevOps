package br.com.mercadao99.controller;

;
import br.com.mercadao99.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private ClientRepository repository;



//    @GetMapping
//   GetMapping public ModelAndView index() {
//        ModelAndView modelAndView = new ModelAndView("client");
//        String client = repository.findByEmail(client.getUsername);
//        modelAndView.addObject("client", client);
//        System.out.println(client);
//        return modelAndView;
//    }



}
