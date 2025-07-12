package com.exemplo.agenda.service;

import com.exemplo.agenda.model.Consulta;
import com.exemplo.agenda.model.TipoServico;
import com.exemplo.agenda.repository.ConsultaRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class ConsultaService {
    private final ConsultaRepository consultaRepository;

    public ConsultaService(ConsultaRepository consultaRepository) {
        this.consultaRepository = consultaRepository;
    }

    public Consulta agendarConsulta(Consulta consulta) {
        double preco = consulta.getTipoServico().getPreco();
        consulta.setValor(preco);
        consulta.setCancelada(false);
        consulta.setTaxaCancelamento(false);
        return consultaRepository.save(consulta);
    }

    public Consulta cancelarConsulta(Long id) {
        Consulta consulta = consultaRepository.findById(id).orElseThrow();
        if (consulta.isCancelada()) return consulta;

        LocalDate hoje = LocalDate.now();
        LocalDate dataConsulta = consulta.getDataHora().toLocalDate();

        if (hoje.equals(dataConsulta)) {
            consulta.setTaxaCancelamento(true);
            consulta.setValor(consulta.getValor() / 2);
        } else {
            consulta.setTaxaCancelamento(false);
            consulta.setValor(0);
        }

        consulta.setCancelada(true);
        return consultaRepository.save(consulta);
    }

    public Consulta atualizarServico(Long id, TipoServico novoServico) {
        Consulta consulta = consultaRepository.findById(id).orElseThrow();
        consulta.setTipoServico(novoServico);
        consulta.setValor(novoServico.getPreco());
        return consultaRepository.save(consulta);
    }
}
