package hank.dev.alu.repository;

import hank.dev.alu.dto.Acronym;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IAcronymRepository extends MongoRepository<Acronym, String> {
}
