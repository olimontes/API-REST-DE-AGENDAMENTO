package com.example.agendamento_api.repository;

import com.example.agendamento_api.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository // Anotação que marca esta interface como um componente de repositório do Spring.
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    // --- Métodos de CRUD já inclusos pelo JpaRepository ---
    // save() - salva ou atualiza um usuário
    // findById() - busca um usuário pelo ID
    // findAll() - busca todos os usuários
    // deleteById() - deleta um usuário pelo ID
    // E muitos outros!

    // --- Métodos de consulta customizados (Exemplos) ---

    /**
     * Busca um usuário pelo seu endereço de e-mail.
     * O Spring Data JPA cria a consulta automaticamente a partir do nome do método.
     * @param email O e-mail a ser pesquisado.
     * @return um Optional contendo o usuário, se encontrado.
     */
    Optional<Usuario> findByEmail(String email);

    /**
     * Busca um usuário pelo seu CPF.
     * @param cpf O CPF a ser pesquisado.
     * @return um Optional contendo o usuário, se encontrado.
     */
    Optional<Usuario> findByCpf(String cpf);

}