package dev.persistance;

import org.springframework.stereotype.Service;

@Service
public class Persistance1 implements IPersistance {

    public String get() {
        return "persistance1";
    }

}
