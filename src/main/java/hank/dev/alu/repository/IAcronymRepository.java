package hank.dev.alu.repository;

import hank.dev.alu.dto.Acronym;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface IAcronymRepository extends MongoRepository<Acronym, String> {
    List<Acronym> findByNameAndExt(String name, String ext);
    List<Acronym> findByName(String name);
}
