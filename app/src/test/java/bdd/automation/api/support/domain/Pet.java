package bdd.automation.api.support.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Pet {
    @Builder.Default
    private int id = 10;

    @Builder.Default
    private String name = "Dog";

    @Builder.Default
    private int status = 0;
}
