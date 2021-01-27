package dev.hotel.controller;

import com.fasterxml.jackson.annotation.JsonView;
import dev.hotel.entite.Client;
import dev.hotel.service.ClientService;
import dev.hotel.views.View;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("v2/clients") // /clients
public class ClientV2Controller {

    private ClientService clientService;

    public ClientV2Controller(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/1")
    @JsonView(View.Synthetique.class)
    public List<Client> listerClients1(@RequestParam Integer start, @RequestParam Integer size) {
        return clientService.lister(start, size);
    }

    @GetMapping("/2")
    @JsonView(View.Complete.class)
    public List<Client> listerClients2(@RequestParam Integer start, @RequestParam Integer size) {
        return clientService.lister(start, size);
    }


}
