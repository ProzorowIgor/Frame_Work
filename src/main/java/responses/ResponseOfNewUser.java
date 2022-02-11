package responses;

import lombok.*;

@AllArgsConstructor
@Setter
@Getter
@ToString
@Builder
public class ResponseOfNewUser {
    private String name;
    private String job;
    private int id;
    private String createdAt;

  /*   "name": "morpheus",
             "job": "leader",
             "id": "277",
             "createdAt":*/
}
