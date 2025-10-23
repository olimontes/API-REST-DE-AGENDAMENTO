package com.example.agendamento_api.controller;

import com.example.agendamento_api.model.Agendamento;
import com.example.agendamento_api.service.AgendamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/agendamentos")
public class AgendamentoController {

    @Autowired
    private AgendamentoService agendamentoService;

    @PostMapping
    public ResponseEntity<Agendamento> criarAgendamento(@RequestBody Agendamento agendamento) {
        Agendamento novoAgendamento = agendamentoService.criarAgendamento(agendamento);
        return new ResponseEntity<>(novoAgendamento, HttpStatus.CREATED);
    }

    @GetMapping("/usuario/{usuarioId}")
    public ResponseEntity<List<Agendamento>> listarAgendamentosPorUsuario(@PathVariable Long usuarioId) {
        List<Agendamento> agendamentos = agendamentoService.listarPorUsuario(usuarioId);
        return ResponseEntity.ok(agendamentos);
    }
}