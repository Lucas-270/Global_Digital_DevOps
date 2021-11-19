package br.com.mercadao99.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotBlank(message = "O CPF é obrigatório!")
    private String cpf;

    @NotBlank(message = "O nome é obrigatório!")
    private String nome;

    @NotBlank(message = "O Email é obrigatório!")
    private String email;

    @NotBlank
    @Size(min=6, message = "A senha necessita de 6 caracteres")
    private String password;
}
