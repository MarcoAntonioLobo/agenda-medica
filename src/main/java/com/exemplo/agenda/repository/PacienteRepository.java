package com.exemplo.agenda.repository;

import com.exemplo.agenda.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {
}
