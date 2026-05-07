package com.demo.backGestor.Repository;

import com.demo.backGestor.Dto.TrabajadorDTO;
import com.demo.backGestor.Dto.TrabajadorListaDTO;
import com.demo.backGestor.modelos.Empresa;
import com.demo.backGestor.modelos.Trabajador;
import com.demo.backGestor.modelos.Trabajo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface TrabajadorRepository extends JpaRepository<Trabajador, Integer> {

    @Query("""
    SELECT new com.demo.backGestor.Dto.TrabajadorDTO(
        t.idTrabajador,
        t.empresa.idEmpresa,
        t.nombre,
        t.apellidos,
        t.email,
        t.password,
        t.numeroTelefono,
        t.dni,
        t.dirreccion,
        t.fechaCreacion
    )
    FROM Trabajador t WHERE t.idTrabajador = :id """)
    Optional<TrabajadorDTO> buscarPorIdTrabajador(int id);

    @Query("""
SELECT new com.demo.backGestor.Dto.TrabajadorDTO(
    t.idTrabajador,
    t.empresa.idEmpresa,
    t.nombre,
    t.apellidos,
    t.email,
    t.password,
    t.numeroTelefono,
    t.dni,
    t.dirreccion,
    t.fechaCreacion
)
FROM Trabajador t
WHERE t.email = :email AND t.password = :password
""")
    Optional<TrabajadorDTO> findByEmailAndPassword(String email , String password);

    @Query("""
SELECT new com.demo.backGestor.Dto.TrabajadorDTO(
    t.idTrabajador,
    t.empresa.idEmpresa,
    t.nombre,
    t.apellidos,
    t.email,
    t.password,
    t.numeroTelefono,
    t.dni,
    t.dirreccion,
    t.fechaCreacion
)
FROM Trabajador t
WHERE t.email = :email
""")
    Optional<TrabajadorDTO> findByEmail(String email);


    List<TrabajadorListaDTO> findByEmpresa_IdEmpresa(int id );
}
