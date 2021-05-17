package cz.czechitas.java2webapps.ukol6.controller;

import cz.czechitas.java2webapps.ukol6.service.CitatyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;


/**
 * Controller providing GET rest-method URL mappings to fetch the following from a repository:
 * 1) random quotes at http://{base_url}/
 * 2) specific quotes at http://{base_url}/{number} where {number} starts with 1 and corresponds
 * to a quote's order in the repository. If it exceeds the bounds or is not a number, a random
 * quote is generated instead of a specific one.
 */
@Controller
public class CitatyController {

    private final CitatyService service;

    @Autowired
    public CitatyController(CitatyService service) {
        this.service = service;
    }

    @GetMapping("/")
    public ModelAndView nahodnyCitat() {
        ModelAndView modelAndView = new ModelAndView("citat");
        modelAndView.addObject("citat", service.nahodnyCitat());
        return modelAndView;
    }

    @GetMapping("/{suffix}")
    public ModelAndView konkretniCitat(@PathVariable String suffix) {
        ModelAndView modelAndView = new ModelAndView("citat");

        switch (suffix.toLowerCase()) {
            case "it-quote":
                modelAndView.addObject("citat", service.nahodnyItCitat());
                break;
            case "sports-quote":
                modelAndView.addObject("citat", service.nahodnySportovniCitat());
                break;
            case "murphys-law":
                modelAndView.addObject("citat", service.nahodnyMurphyhoZakon());
                break;
            default:
                try {
                    int poradi = Integer.parseInt(suffix);
                    modelAndView.addObject("citat", service.konkretniCitat(poradi));
                } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                    return nahodnyCitat();
                }
        }
        return modelAndView;
    }

    @GetMapping("/it/")
    public ModelAndView nahodnyItCitat() {
        ModelAndView modelAndView = new ModelAndView("citat");
        modelAndView.addObject("citat", service.nahodnyItCitat());
        return modelAndView;
    }

    @GetMapping("/murphy/")
    public ModelAndView nahodnyMurphyhoZakon() {
        ModelAndView modelAndView = new ModelAndView("citat");
        modelAndView.addObject("citat", service.nahodnyMurphyhoZakon());
        return modelAndView;
    }
}
