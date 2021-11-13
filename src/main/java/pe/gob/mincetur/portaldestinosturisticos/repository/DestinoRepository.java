package pe.gob.mincetur.portaldestinosturisticos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.gob.mincetur.portaldestinosturisticos.entity.Destino;

@Repository
public interface DestinoRepository extends JpaRepository<Destino, Long>{
	List<Destino> findByName(String name);
	List<Destino> findByDepartamento(String departamento);
}
