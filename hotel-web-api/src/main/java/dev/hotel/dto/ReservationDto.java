package dev.hotel.dto;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public class ReservationDto {

    private UUID uuid;
    private LocalDate debut;
    private LocalDate fin;

    private List<UUID> chambres;

    public List<UUID> getChambres() {
        return chambres;
    }

    public void setChambres(List<UUID> chambres) {
        this.chambres = chambres;
    }

    public ReservationDto() {
    }

    public ReservationDto(UUID uuid, LocalDate debut, LocalDate fin) {
        this.uuid = uuid;
        this.debut = debut;
        this.fin = fin;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public LocalDate getDebut() {
        return debut;
    }

    public void setDebut(LocalDate debut) {
        this.debut = debut;
    }

    public LocalDate getFin() {
        return fin;
    }

    public void setFin(LocalDate fin) {
        this.fin = fin;
    }
}
