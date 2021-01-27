package dev.demoboot.ctrl;

import dev.demoboot.entite.Plat;
import dev.demoboot.service.PlatSrv;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("plats")
public class PlatCtrl {

    private PlatSrv platSrv;

    public PlatCtrl(PlatSrv platSrv) {
        this.platSrv = platSrv;
    }

    // GET /plats
    @GetMapping
    public List<Plat> list() {
        return platSrv.lister();
    }

}
