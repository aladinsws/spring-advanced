package dev.hotel.controller;

import dev.hotel.dto.CreerReservationDto;
import dev.hotel.dto.ReservationDto;
import dev.hotel.entite.Reservation;
import dev.hotel.mapper.DtoMapper;
import dev.hotel.service.ReservationService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("reservations")
public class ReservationController {

    private ReservationService reservationService;
    private DtoMapper dtoMapper;


    public ReservationController(ReservationService reservationService, DtoMapper dtoMapper) {
        this.reservationService = reservationService;
        this.dtoMapper = dtoMapper;
    }

    @PostMapping
    public ReservationDto creerResa(@RequestBody @Valid CreerReservationDto creerResa) {

        // Démo conversion
        Reservation reservation1 = dtoMapper.toReservation(creerResa);

        Reservation reservation = reservationService.creer(creerResa.getDateDebut(), creerResa.getDateFin(),
                creerResa.getClientId(), creerResa.getChambres());

        return dtoMapper.toReservationDto(reservation);
//        return new ReservationDto(reservation.getUuid(), reservation.getDateDebut(), reservation.getDateFin());
    }


}
