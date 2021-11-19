package br.com.mercadao99.controller;



import br.com.mercadao99.model.Product;
import br.com.mercadao99.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/produto")
public class ProductController {

    @Autowired
    private ProductRepository repository;

    @Autowired
    private MessageSource message;

    @RequestMapping("novo")
    public String create(Product product) {
        return "produtos-cadastro";
    }

    @PostMapping
    public String save(@Valid Product product, BindingResult result, RedirectAttributes redirect) {
        if (result.hasErrors()) return "user-form";
        repository.save(product);
        redirect.addFlashAttribute("message",
                message.getMessage("product.new.success", null, LocaleContextHolder.getLocale()));
        return "redirect:/task";
    }

    @GetMapping
    public ModelAndView index() {
        List<Product> products = repository.findAll();
        ModelAndView modelAndView = new ModelAndView("products");
        modelAndView.addObject("products", products);
        return modelAndView;
    }


    @GetMapping("/release/{id}")
    public String release(@PathVariable Long id, Authentication auth) {
        Optional<Product> optional = repository.findById(id);
//        if (optional.isEmpty())
//            throw new ProductNotFoundException("Produto não encontrado");

        Product product = optional.get();
        repository.save(product);
        return "redirect:/task";
    }




}
