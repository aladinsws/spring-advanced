package dev.demoboot.repo;

import dev.demoboot.entite.Plat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlatRepo extends JpaRepository<Plat, Integer> {
}
