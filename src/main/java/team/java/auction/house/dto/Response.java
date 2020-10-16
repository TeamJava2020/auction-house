package team.java.auction.house.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Response<T> {
    Status status;
    ErrorMessage error;
    T data;

    public enum Status {
        OK,
        ERROR,
        NO_DATA
    }
}
