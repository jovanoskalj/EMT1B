package mk.ukim.finki.lab1b.model.dto;

import lombok.Data;

@Data
public class HostDto
{
    // id (Long), name (String), surname (String), country (Country).

    private String name;
    private  String surname;
    private  Long country;
}
