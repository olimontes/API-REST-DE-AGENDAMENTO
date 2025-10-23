package com.example.agendamento_api.service;

import com.example.agendamento_api.model.Agendamento;
import com.example.agendamento_api.repository.AgendamentoRepository;
import com.example.agendamento_api.repository.UsuarioRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AgendamentoService {

    @Autowired
    private AgendamentoRepository agendamentoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    // A DEPENDÊNCIA 'ProfissionalRepository' FOI REMOVIDA

    @Transactional
    public Agendamento criarAgendamento(Agendamento agendamento) {
        // 1. Valida se o usuário associado ao agendamento existe
        Long usuarioId = agendamento.getUsuario().getId();
        usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado com o ID: " + usuarioId));

        // 2. A VALIDAÇÃO DO PROFISSIONAL FOI REMOVIDA

        // Lógica de negócio: Validar se o horário está disponível para este usuário (pode ser adicionado aqui)

        return agendamentoRepository.save(agendamento);
    }

    @Transactional(readOnly = true)
    public Agendamento buscarPorId(Long id) {
        return agendamentoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Agendamento não encontrado com o ID: " + id));
    }

    @Transactional(readOnly = true)
    public List<Agendamento> listarPorUsuario(Long usuarioId) {
        if (!usuarioRepository.existsById(usuarioId)) {
            throw new EntityNotFoundException("Usuário não encontrado com o ID: " + usuarioId);
        }
        return agendamentoRepository.findByUsuarioId(usuarioId);
    }
}