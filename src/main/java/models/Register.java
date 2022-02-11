package models;


import lombok.*;

@AllArgsConstructor
@Setter
@Getter
@ToString
@Builder
public class Register {

    private String email;
    private String password;


}
