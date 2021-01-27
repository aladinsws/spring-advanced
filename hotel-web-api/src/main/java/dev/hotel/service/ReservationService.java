package dev.hotel.service;

import dev.hotel.entite.Chambre;
import dev.hotel.entite.Client;
import dev.hotel.entite.Reservation;
import dev.hotel.exception.ReservationException;
import dev.hotel.repository.ChambreRepository;
import dev.hotel.repository.ClientRepository;
import dev.hotel.repository.ReservationRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ReservationService {

    private ReservationRepository reservationRepo;
    private ClientRepository clientRepo;
    private ChambreRepository chambreRepo;

    public ReservationService(ReservationRepository reservationRepo, ClientRepository clientRepo, ChambreRepository chambreRepo) {
        this.reservationRepo = reservationRepo;
        this.clientRepo = clientRepo;
        this.chambreRepo = chambreRepo;
    }


    @Transactional
    public Reservation creer(LocalDate dateDebut, LocalDate dateFin, UUID clientId, List<UUID> chambreIds) {

        List<String> erreurs = new ArrayList<>();

        LocalDate dateDuJour = LocalDate.now();

        if (dateDebut.isBefore(dateDuJour)) {
            erreurs.add("date de debut ko");
        }

        if (dateFin.isBefore(dateDuJour)) {
            erreurs.add("date de fin ko");
        }

        if (dateDebut.isAfter(dateFin)) {
            erreurs.add("date de debut > date de fin");
        }


        boolean isClientExist = clientRepo.existsById(clientId);

        if (!isClientExist) {
            erreurs.add("uuid client non trouvé");
        }

        List<Chambre> chambres = new ArrayList<>();

        for (UUID chambreId : chambreIds) {
            boolean isChambreExist = chambreRepo.existsById(chambreId);
            if (!isChambreExist) {
                erreurs.add("la chambre " + chambreId + " n'existe pas");
            } else {
                chambres.add(chambreRepo.getOne(chambreId));
            }
        }

        if (!erreurs.isEmpty()) {
            throw new ReservationException(erreurs);
        }


        Reservation reservation = new Reservation();
        reservation.setDateDebut(dateDebut);
        reservation.setDateFin(dateFin);

        Client client = clientRepo.getOne(clientId);
        reservation.setClient(client);

        reservation.setChambres(chambres);

        return reservationRepo.save(reservation);

    }

}

