package com.demo.backGestor.Repository;

import com.demo.backGestor.modelos.Empresa;
import com.demo.backGestor.modelos.Material;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MaterialRepository extends JpaRepository<Material, Integer> {
}
