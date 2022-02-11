package models;

import lombok.*;

@AllArgsConstructor
@Setter
@Getter
@ToString
@Builder

public class Support {
    private String url;
    private String text;
}
