package models;

import lombok.*;

@AllArgsConstructor
@Setter
@Getter
@ToString
@Builder
public class SingleUser {
    private Data data;
    private Support support;

}
