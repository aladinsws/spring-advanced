package dev.hotel.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

/*
{
    "dateDebut": "2019-10-01",
    "dateFin": "2019-10-10",
    "clientId": "UUID_CLIENT",
    "chambres": [
        "UUID_CHAMBRE_X",
        "UUID_CHAMBRE_Y",
        "UUID_CHAMBRE_Z"
    ]
}
 */
public class CreerReservationDto {

    @NotNull
    private LocalDate dateDebut;
    @NotNull
    private LocalDate dateFin;
    @NotNull
    private UUID clientId;

    @NotEmpty
    private List<@NotNull UUID> chambres;

    public LocalDate getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(LocalDate dateDebut) {
        this.dateDebut = dateDebut;
    }

    public LocalDate getDateFin() {
        return dateFin;
    }

    public void setDateFin(LocalDate dateFin) {
        this.dateFin = dateFin;
    }

    public UUID getClientId() {
        return clientId;
    }

    public void setClientId(UUID clientId) {
        this.clientId = clientId;
    }

    public List<UUID> getChambres() {
        return chambres;
    }

    public void setChambres(List<UUID> chambres) {
        this.chambres = chambres;
    }
}
