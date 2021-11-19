package br.com.mercadao99.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Calendar;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "{produto.nome.blank}")
    private String nome;

    @Size(min = 10, message = "A descrição deve ter pelo menos 10 caracteres")
    private String description;

    @NotBlank(message = "{produto.preco.blank}")
    private BigDecimal preco;

    @NotBlank(message = "{produto.dataDeValidade.blank}")
    private Calendar dataDevalidade;

    @NotBlank(message = "produto.estoque.blank")
    private Integer estoque;

    @ManyToOne
    @NotBlank(message = "{produto.loja.blank}")
    private User store;








}
