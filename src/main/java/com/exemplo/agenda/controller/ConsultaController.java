package com.exemplo.agenda.controller;

import com.exemplo.agenda.model.Consulta;
import com.exemplo.agenda.model.TipoServico;
import com.exemplo.agenda.repository.TipoServicoRepository;
import com.exemplo.agenda.service.ConsultaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/consultas")
public class ConsultaController {

    private final ConsultaService consultaService;
    private final TipoServicoRepository tipoServicoRepository;

    public ConsultaController(ConsultaService consultaService, TipoServicoRepository tipoServicoRepository) {
        this.consultaService = consultaService;
        this.tipoServicoRepository = tipoServicoRepository;
    }

    @PostMapping
    public ResponseEntity<Consulta> agendar(@RequestBody Consulta consulta) {
        return ResponseEntity.ok(consultaService.agendarConsulta(consulta));
    }

    @PostMapping("/{id}/cancelar")
    public ResponseEntity<Consulta> cancelar(@PathVariable Long id) {
        return ResponseEntity.ok(consultaService.cancelarConsulta(id));
    }

    @PutMapping("/{id}/servico/{servicoId}")
    public ResponseEntity<Consulta> atualizarServico(@PathVariable Long id, @PathVariable Long servicoId) {
        TipoServico novoServico = tipoServicoRepository.findById(servicoId).orElseThrow();
        return ResponseEntity.ok(consultaService.atualizarServico(id, novoServico));
    }

    @GetMapping("/servicos")
    public List<TipoServico> listarServicos() {
        return tipoServicoRepository.findAll();
    }
}
