package br.com.mercadao99.model;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.util.List;
;


@Entity
public class Cart {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @NotBlank(message = "{carrinho.cliente.blank}")
    private Store store;

    @OneToOne
    @NotBlank(message = "{carrinho.cliente.blank}")
    private Client cliente;

    @OneToMany
    @NotBlank(message = "{carrinho.produtos.blank}")
    private List<Product> produtos;

    @NotBlank(message = "{carrinho.valorTotalDaCompra.blank}")
    private BigDecimal valorTotalDaCompra;



}
