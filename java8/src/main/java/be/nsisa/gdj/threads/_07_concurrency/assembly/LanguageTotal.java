package be.nsisa.gdj.threads._07_concurrency.assembly;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Builder
@Getter
@ToString
public class LanguageTotal {
    private String language;
    private Integer total;
}
