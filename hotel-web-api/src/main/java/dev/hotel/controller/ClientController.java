package dev.hotel.controller;

import dev.hotel.dto.ClientLightDto;
import dev.hotel.dto.CreerClientDto;
import dev.hotel.entite.Client;
import dev.hotel.exception.ClientNotFoundException;
import dev.hotel.mapper.DtoMapper;
import dev.hotel.service.ClientService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("clients") // /clients
public class ClientController {

    private ClientService clientService;
    private DtoMapper mapper;

    public ClientController(ClientService clientService, DtoMapper mapper) {
        this.clientService = clientService;
        this.mapper = mapper;
    }

    @GetMapping // GET /clients?start=0&size=3
    public List<Client> listerClients(@RequestParam Integer start, @RequestParam Integer size) {
        return clientService.lister(start, size);
    }

//    @GetMapping("{uuid}")
//    public ResponseEntity<?> rechercherUnClientV1(@PathVariable UUID uuid) {
//        Optional<Client> optionalClient = clientService.rechercherClient(uuid);
//
//        if (optionalClient.isPresent()) {
//            // 200 avec Client
//            Client client = optionalClient.get();
//            return ResponseEntity.ok(client);
//        } else {
//            // 404 avec un message
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("uuid " + uuid + " non trouvé");
//        }
//    }

    // GET /clients/uuid
    @GetMapping("{uuid}")
    public Client rechercherUnClientV2(@PathVariable UUID uuid) {
        return clientService.rechercherClient(uuid)
                .orElseThrow(() -> new ClientNotFoundException("uuid " + uuid + " non trouvé"));
    }

    @PostMapping // POST /clients
    public ClientLightDto creerClient(@RequestBody @Valid CreerClientDto client/*, BindingResult result*/) {

        Client client1 = clientService.creer(client.getNom(), client.getPrenoms());

//        ClientLightDto clientLightDto = new ClientLightDto();
//        clientLightDto.setUuid(client1.getUuid());
//        return clientLightDto;

        return mapper.toClientLightDto(client1);
    }

}
