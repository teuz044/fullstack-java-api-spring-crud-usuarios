package br.com.criandoapi.projeto.model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @NotBlank(message = "O nome é obrigatório")
    @Column(name = "nome_completo", length = 200, nullable = false)
    private String nome;

    @Email(message = "Digite um email válido")
    @NotBlank(message = "O email é obrigatório")
    @Column(name = "email", length = 50, nullable = false)
    private String email;

    @NotBlank(message = "A senha é obrigatório")
    @Column(name = "senha", columnDefinition = "TEXT", nullable = false)
    private String senha;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
