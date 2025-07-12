package com.exemplo.agenda.repository;

import com.exemplo.agenda.model.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultaRepository extends JpaRepository<Consulta, Long> {
}
