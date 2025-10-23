package com.example.agendamento_api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;

@Entity // 1. Anotação mais importante: diz que esta classe é uma entidade do banco.
@Table(name = "usuarios") // 2. Define o nome da tabela no banco de dados (boa prática).
public class Usuario {

    @Id // 3. Marca o campo 'id' como a chave primária da tabela.
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 4. Define que o ID será gerado automaticamente pelo banco (autoincremento).
    private Long id;

    @Column(nullable = false, length = 150) // 'nullable = false' torna o campo obrigatório.
    private String nome;

    @Column(nullable = false, unique = true, length = 11) // 'unique = true' garante que não haverá CPFs repetidos.
    private String cpf; // Mudei para String para lidar com zeros à esquerda.

    @Column(nullable = false, unique = true, length = 100)
    private String email;

    @Column(nullable = false, length = 255) // Senhas devem ter um tamanho maior para o hash.
    private String senha;

    @Column(length = 20)
    private String telefone;

    @Column(length = 200)
    private String endereco;

    @Column(length = 100)
    private String cidade;

    @Column(length = 2) // Geralmente estados são representados por 2 caracteres (ex: MG, SP).
    private String estado;

    @Column(length = 9) // CEP com traço (ex: 39400-000).
    private String cep;

    // 5. Construtor padrão (vazio) é exigido pela JPA.
    public Usuario() {
    }

    // 6. Construtor com todos os argumentos (útil para criar novos usuários).
    public Usuario(String nome, String cpf, String email, String senha, String telefone, String endereco, String cidade, String estado, String cep) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.senha = senha;
        this.telefone = telefone;
        this.endereco = endereco;
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep;
    }

    // --- Getters e Setters ---
    // (Os seus getters e setters estavam corretos, adicionei apenas o do 'id' e ajustei o do 'cpf').

    public Long getId() {
        return id;
    }

        public void setId(Long id) {
            this.id = id;
        }

        public String getCpf() {
            return cpf;
        }

        public void setCpf(String cpf) {
            this.cpf = cpf;
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

        public String getTelefone() {
            return telefone;
        }

        public void setTelefone(String telefone) {
            this.telefone = telefone;
        }

        public String getEndereco() {
            return endereco;
        }

        public void setEndereco(String endereco) {
            this.endereco = endereco;
        }

        public String getCidade() {
            return cidade;
        }

        public void setCidade(String cidade) {
            this.cidade = cidade;
        }

        public String getEstado() {
            return estado;
        }

        public void setEstado(String estado) {
            this.estado = estado;
        }

        public String getCep() {
            return cep;
        }

        public void setCep(String cep) {
            this.cep = cep;
        }
    }