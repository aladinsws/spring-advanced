package dev.hotel.mapper;

import dev.hotel.dto.ClientLightDto;
import dev.hotel.dto.CreerReservationDto;
import dev.hotel.dto.ReservationDto;
import dev.hotel.entite.Chambre;
import dev.hotel.entite.Client;
import dev.hotel.entite.Reservation;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.UUID;

@Mapper(componentModel = "spring") // @Component
public interface DtoMapper {

    @Mapping(source = "nom", target = "name")
    ClientLightDto toClientLightDto(Client client);

    Client toClient(ClientLightDto dto);

    @Mapping(source = "dateDebut", target = "debut")
    @Mapping(source = "dateFin", target = "fin")
    ReservationDto toReservationDto(Reservation reservation);


    Reservation toReservation(CreerReservationDto reservation);

    List<Chambre> toListChambre(List<UUID> value);

    List<UUID> toListUUID(List<Chambre> value);

    default UUID toUUID(Chambre value) {
        return value.getUuid();
    }

    default Chambre toChambre(UUID value) {
        Chambre chambre = new Chambre();
        chambre.setUuid(value);
        return chambre;
    }
}
