package br.com.medaula.config;

import com.google.inject.Inject;
import com.google.inject.persist.PersistService;

public class InitializerJpa {

    private final PersistService service;

    @Inject
    InitializerJpa(PersistService service) {
        this.service = service;
        service.start();
    }
}
