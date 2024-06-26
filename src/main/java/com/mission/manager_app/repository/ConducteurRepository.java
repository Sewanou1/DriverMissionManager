package com.mission.manager_app.repository;

import com.mission.manager_app.model.Conducteur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConducteurRepository extends JpaRepository<Conducteur,Long>  {
}
