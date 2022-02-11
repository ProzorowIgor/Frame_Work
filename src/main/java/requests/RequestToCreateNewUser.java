package requests;

import lombok.*;

@AllArgsConstructor
@Setter
@Getter
@ToString
@Builder

public class RequestToCreateNewUser {
    private String name;
    private String job;




}
