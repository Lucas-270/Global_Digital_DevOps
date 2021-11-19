package br.com.mercadao99.controller;


;
import br.com.mercadao99.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class StoreController {

    @Autowired
    private StoreRepository repository;
}
