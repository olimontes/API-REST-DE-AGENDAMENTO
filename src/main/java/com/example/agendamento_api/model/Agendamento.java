package com.example.agendamento_api.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity // Anotação que marca esta classe como uma entidade do banco de dados
@Table(name = "agendamentos") // Define o nome da tabela no banco
public class Agendamento {

    @Id // Chave primária
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Estratégia de geração de ID (autoincremento)
    private Long id;

    // Relacionamento: Muitos agendamentos podem pertencer a um usuário/cliente.
    @ManyToOne(fetch = FetchType.LAZY) // LAZY: Carrega o usuário apenas quando for acessado
    @JoinColumn(name = "usuario_id", nullable = true) // Chave estrangeira
    private Usuario usuario;

    @Column(name = "data_hora_inicio", nullable = true)
    private LocalDateTime dataHoraInicio;

    @Column(name = "data_hora_fim", nullable = true)
    private LocalDateTime dataHoraFim;

    @Column(name = "observacoes", length = 500)
    private String observacoes;

    @Column(name = "data_criacao", updatable = false) // Não pode ser atualizado após a criação
    private LocalDateTime dataCriacao;

    @Column(name = "data_atualizacao")
    private LocalDateTime dataAtualizacao;

    // Construtor padrão exigido pela JPA
    public Agendamento() {
    }

    // Métodos para controle de datas de auditoria
    @PrePersist // Executa antes de salvar a entidade pela primeira vez
    protected void onCreate() {
        dataCriacao = LocalDateTime.now();
        dataAtualizacao = LocalDateTime.now();
    }

    @PreUpdate // Executa antes de atualizar uma entidade existente
    protected void onUpdate() {
        dataAtualizacao = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public LocalDateTime getDataHoraInicio() {
        return dataHoraInicio;
    }

    public void setDataHoraInicio(LocalDateTime dataHoraInicio) {
        this.dataHoraInicio = dataHoraInicio;
    }

    public LocalDateTime getDataHoraFim() {
        return dataHoraFim;
    }

    public void setDataHoraFim(LocalDateTime dataHoraFim) {
        this.dataHoraFim = dataHoraFim;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public LocalDateTime getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(LocalDateTime dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }

    // ... Getters e Setters
}
