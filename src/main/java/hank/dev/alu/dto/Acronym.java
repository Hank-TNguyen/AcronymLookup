package hank.dev.alu.dto;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@CompoundIndexes({ @CompoundIndex(name = "name-ext", def = "{'name' : 1, 'ext': 1}") })
public class Acronym {

    @Id private String id;

    private String name;
    private String ext; // Extension of the acronym
    private String description;

    public Acronym() {}

    public Acronym(String name, String ext, String description) {
        this.name = name;
        this.ext = ext;
        this.description = description;
    }
}
