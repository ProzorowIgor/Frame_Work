package models;

import lombok.*;

@AllArgsConstructor
@Setter
@Getter
@ToString
@Builder


public class DataUser {

    private Integer id;
    private String email;
    private String first_name;
    private String last_name;
    private String avatar;


    public DataUser() {
        super();
    }
}
/*
id": 7,
        "email": "michael.lawson@reqres.in",
        "first_name": "Michael",
        "last_name": "Lawson",
        "avatar": "ht*/
