package be.nsisa.gdj.threads._07_concurrency.sharedstate;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LocalText {
    private String language;
    private String text;
}
