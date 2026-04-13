package com.demo.backGestor.Repository;

import com.demo.backGestor.modelos.RegistroTrabajo;
import com.demo.backGestor.modelos.RegistroTrabajoId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResgistroTrabajoRepository extends JpaRepository<RegistroTrabajo, RegistroTrabajoId> {
}
