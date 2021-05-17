package cz.czechitas.java2webapps.ukol6.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CitatyService {

    private final NahodneCisloService nahodneCisloService;
    private final CitatyRepository citatyRepository;

    @Autowired
    public CitatyService(NahodneCisloService nahodneCisloService, CitatyRepository citatyRepository) {
        this.nahodneCisloService = nahodneCisloService;
        this.citatyRepository = citatyRepository;
    }

    public String nahodnyCitat() {
        int nahodnePoradi = 1 + nahodneCisloService.dejNahodneCislo(citatyRepository.pocet());
        return citatyRepository.citat(nahodnePoradi);
    }

    public String konkretniCitat(int cislo) {
        return citatyRepository.citat(cislo);
    }

    public String nahodnyItCitat() {
        int nahodnePoradi = 1 + nahodneCisloService.dejNahodneCislo(citatyRepository.pocet("it-quote"));
        return citatyRepository.citat(nahodnePoradi, "it-quote");
    }

    public String nahodnySportovniCitat() {
        int nahodnePoradi = 1 + nahodneCisloService.dejNahodneCislo(citatyRepository.pocet("sports-quote"));
        return citatyRepository.citat(nahodnePoradi, "sports-quote");
    }

    public String nahodnyMurphyhoZakon() {
        int nahodnePoradi = 1 + nahodneCisloService.dejNahodneCislo(citatyRepository.pocet("murphys-law"));
        return citatyRepository.citat(nahodnePoradi, "murphys-law");
    }
}
