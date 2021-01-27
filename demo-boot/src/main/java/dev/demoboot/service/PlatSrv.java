package dev.demoboot.service;

import dev.demoboot.entite.Plat;
import dev.demoboot.repo.PlatRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlatSrv {
    private PlatRepo platRepo;

    public PlatSrv(PlatRepo platRepo) {
        this.platRepo = platRepo;
    }

    public List<Plat> lister() {
        return platRepo.findAll();
    }
}
