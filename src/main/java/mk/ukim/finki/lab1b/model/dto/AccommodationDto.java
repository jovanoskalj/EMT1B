package mk.ukim.finki.lab1b.model.dto;

import lombok.Data;
import mk.ukim.finki.lab1b.model.AccCategory;

@Data
public class AccommodationDto {
    //  id (Long), name (String), category (enum), host (Host), numRooms (Integer).
    private String name;
    private AccCategory category;
    private  Long host;
    private  Integer numRooms;

}
