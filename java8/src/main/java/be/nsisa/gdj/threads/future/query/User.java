package be.nsisa.gdj.threads.future.query;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@ToString
public class User {

    private String username;
    private String name;
    private LocalDate lastLogin;
    private LocalDate lastFailedLogin;
}
