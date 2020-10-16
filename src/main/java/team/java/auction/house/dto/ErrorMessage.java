package team.java.auction.house.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ErrorMessage {
    int status;
    String message;
    String date;
}
