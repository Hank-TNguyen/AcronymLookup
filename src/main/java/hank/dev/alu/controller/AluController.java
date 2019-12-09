package hank.dev.alu.controller;

import hank.dev.alu.dto.Acronym;
import hank.dev.alu.repository.IAcronymRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

    @PostMapping("/api/acronyms")
    public Acronym newAcronym(@RequestBody Acronym newAcronym) {
        return acronymRepository.save(newAcronym);
    }
}
