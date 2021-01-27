package dev.hotel.repository;

import dev.hotel.entite.Chambre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ChambreRepository extends JpaRepository<Chambre, UUID> {
}
