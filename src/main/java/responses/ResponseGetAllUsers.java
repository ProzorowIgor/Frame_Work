package responses;

import lombok.*;
import models.DataUser;
import models.Support;

import java.util.List;
@AllArgsConstructor
@Setter
@Getter
@ToString
@Builder

public class ResponseGetAllUsers {
    private  int page;
    private  int per_page;
    private  int total;
    private  int total_pages;
    private List<DataUser> data;
    private Support support;



}
