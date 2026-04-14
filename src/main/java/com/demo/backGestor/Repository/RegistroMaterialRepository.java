package com.demo.backGestor.Repository;

import com.demo.backGestor.modelos.RegistroMaterial;
import com.demo.backGestor.modelos.RegistroMaterialId;
import com.demo.backGestor.modelos.RegistroTrabajo;
import com.demo.backGestor.modelos.RegistroTrabajoId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegistroMaterialRepository extends JpaRepository<RegistroMaterial, RegistroMaterialId> {
}
