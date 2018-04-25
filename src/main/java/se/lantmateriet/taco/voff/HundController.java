package se.lantmateriet.taco.voff;

import org.springframework.web.bind.annotation.*;
import se.lantmateriet.taco.voff.Hund.Ras;

import javax.inject.Inject;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/")
public class HundController {

    private final HundRepository repository;

    @Inject
    public HundController(HundRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/hund/{id}")
    public Optional<Hund> getById(@PathVariable("id") int id) {
        return repository.getHund(id);
    }

    @GetMapping("/hund/ras/{ras}")
    public List<Hund> getByRas(@PathVariable("ras") Ras ras) {
        return repository.getHundarByRas(ras);
    }

    @GetMapping("/hund/namn/{namn}")
    public List<Hund> getByNamn(@PathVariable("namn") String namn) {
        return repository.getHundarByNamn(namn);
    }

    @GetMapping("/hundar")
    public List<Hund> alla() {
        return repository.getHundar();
    }
}
