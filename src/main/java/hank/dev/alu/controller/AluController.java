package hank.dev.alu.controller;

import hank.dev.alu.dto.Acronym;
import hank.dev.alu.repository.IAcronymRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Optional;

@RestController
public class AluController {

    private final IAcronymRepository acronymRepository;

    @Autowired
    public AluController(IAcronymRepository acronymRepository) {
        this.acronymRepository = acronymRepository;
    }

    @RequestMapping("/")
    public String index() {
        return "200\n";
    }

    @GetMapping("/api/acronyms")
    public List<Acronym> all() {
        return acronymRepository.findAll();
    }

    @GetMapping("/api/acronyms/n/{name}")
    public List<Acronym> getAcronymsByName(@PathVariable String name) {
        return acronymRepository.findByName(name);
    }

    @GetMapping("/api/acronyms/{id}")
    public Optional<Acronym> getAcronymsById(@PathVariable String id) {
        return acronymRepository.findById(id);
    }

    @PostMapping("/api/acronyms")
    public Acronym newAcronym(@RequestBody Acronym newAcronym, HttpServletResponse response) {
        Acronym savedAcronym;
        List<Acronym> acronyms = acronymRepository.findByNameAndExt(newAcronym.getName(), newAcronym.getExt());

        if (acronyms.size() > 0) {
            savedAcronym = acronyms.get(0);
            response.setStatus(HttpServletResponse.SC_CONFLICT);
        } else {
            savedAcronym = acronymRepository.save(newAcronym);
        }

        return savedAcronym;
    }
}
