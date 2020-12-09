package dev.hotel.controller;

import dev.hotel.dto.CreerClientDto;
import dev.hotel.entite.Client;
import dev.hotel.service.ClientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("clients") // /clients
public class ClientController {

    private ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping // GET /clients?start=0&size=3
    public List<Client> listerClients(@RequestParam Integer start, @RequestParam Integer size) {
        return clientService.lister(start, size);
    }

    // GET /clients/uuid
    @GetMapping("{uuid}")
    public ResponseEntity<?> rechercherUnClient(@PathVariable UUID uuid) {
        Optional<Client> optionalClient = clientService.rechercherClient(uuid);

        if (optionalClient.isPresent()) {
            // 200 avec Client
            Client client = optionalClient.get();
            return ResponseEntity.ok(client);
        } else {
            // 404 avec un message
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("uuid " + uuid + " non trouvé");
        }
    }

    @PostMapping // POST /clients
    public Client creerClient(@RequestBody CreerClientDto client) {
        return clientService.creer(client.getNom(), client.getPrenoms());
    }

}
