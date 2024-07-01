package com.mission.manager_app.repository;

import com.mission.manager_app.model.Mission;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

public interface MissionRepository extends JpaRepository<Mission, Long> {
   // boolean existsByConducteur_IdAndDateArriveeAfter(Long conducteurId, LocalDate date);
}
