package be.nsisa.gdj.threads.concurrency.sharedstate;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LocalText {
    private String language;
    private String text;
}
