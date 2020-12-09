package dev.hotel.service;

import dev.hotel.entite.Client;
import dev.hotel.repository.ClientRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ClientService {

    private ClientRepository clientRepo;

    public ClientService(ClientRepository clientRepo) {
        this.clientRepo = clientRepo;
    }

    public List<Client> lister(Integer start, Integer size) {
        return clientRepo.findAll(PageRequest.of(start, size)).getContent();
    }

    // Java 8
    public Optional<Client> rechercherClient(UUID uuid) {
        return clientRepo.findById(uuid);
    }


    @Transactional
    public Client creer(String nom, String prenoms) {
        return clientRepo.save(new Client(nom, prenoms));
    }
}
