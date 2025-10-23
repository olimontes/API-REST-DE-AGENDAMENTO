package com.example.agendamento_api.service;

import com.example.agendamento_api.model.Usuario;
import com.example.agendamento_api.repository.UsuarioRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Transactional
    public Usuario criarUsuario(Usuario usuario) {
        // Lógica de segurança: Criptografar a senha antes de salvar (essencial!)
        // Ex: usuario.setSenha(passwordEncoder.encode(usuario.getSenha()));

        Usuario usuarioSalvo = usuarioRepository.save(usuario);
        return usuarioSalvo;
    }

    @Transactional(readOnly = true)
    public Usuario buscarPorId(Long id) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado com o ID: " + id));

        // Medida de segurança: Nunca retorne a senha na resposta da API
        usuario.setSenha(null);
        return usuario;
    }

    @Transactional(readOnly = true)
    public List<Usuario> listarTodos() {
        List<Usuario> usuarios = usuarioRepository.findAll();

        // Itera sobre a lista para remover a senha de cada usuário antes de retornar
        usuarios.forEach(usuario -> usuario.setSenha(null));

        return usuarios;
    }

    @Transactional
    public void deletar(Long id) {
        if (!usuarioRepository.existsById(id)) {
            throw new EntityNotFoundException("Usuário não encontrado com o ID: " + id);
        }
        usuarioRepository.deleteById(id);
    }
}