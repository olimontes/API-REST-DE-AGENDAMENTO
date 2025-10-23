package com.example.agendamento_api.repository;

import com.example.agendamento_api.model.Agendamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {

    // Os métodos básicos de CRUD (save, findById, findAll, deleteById)
    // também estão disponíveis aqui para a entidade Agendamento.

    // --- Métodos de consulta customizados (Exemplos) ---

    /**
     * Encontra todos os agendamentos para um usuário específico.
     * @param usuarioId O ID do usuário.
     * @return Uma lista de agendamentos daquele usuário.
     */
    List<Agendamento> findByUsuarioId(Long usuarioId);

    /**
     * Encontra agendamentos que ocorrem dentro de um intervalo de tempo específico.
     * Muito útil para verificar a disponibilidade de horários.
     * @param inicio O momento de início do intervalo.
     * @param fim O momento de fim do intervalo.
     * @return Uma lista de agendamentos conflitantes.
     */
    List<Agendamento> findByDataHoraInicioBetween(LocalDateTime inicio, LocalDateTime fim);

}