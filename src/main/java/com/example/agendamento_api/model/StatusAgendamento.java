package com.example.agendamento_api.model;

/**
 * Enum que representa os possíveis status de um agendamento.
 * Usar um Enum garante a consistência dos dados no banco.
 */
public enum StatusAgendamento {

    /**
     * O agendamento foi solicitado, mas ainda não foi confirmado.
     */
    PENDENTE,

    /**
     * O agendamento foi confirmado por todas as partes.
     */
    CONFIRMADO,

    /**
     * O agendamento foi cancelado pelo usuário ou administrador.
     */
    CANCELADO,

    /**
     * O agendamento já foi realizado e finalizado.
     */
    CONCLUIDO
}