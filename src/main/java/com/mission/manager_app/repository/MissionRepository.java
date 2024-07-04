package com.mission.manager_app.repository;

import com.mission.manager_app.model.Mission;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface MissionRepository extends JpaRepository<Mission, Long> {
   //Boolean existsByConducteurIdAndDateArriveeAfter(Long conducteurId, LocalDate date);
   List<Mission> findByConducteurIdConducteur(Long idConducteur);
   boolean existsByVehiculeId(Long vehiculeId);
   boolean existsByConducteurIdConducteur(Long idConducteur);
   List<Mission> findTop6ByOrderByDateDepartDesc();
   
}
