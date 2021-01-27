package dev.hotel.mapper;

import dev.hotel.dto.ClientLightDto;
import dev.hotel.entite.Client;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring") // @Component
public interface DtoMapper {

    @Mapping(source = "nom", target = "name")
    ClientLightDto toClientLightDto(Client client);

    Client toClient(ClientLightDto dto);
}
