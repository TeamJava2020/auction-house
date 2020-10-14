package team.java.auction.house.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AuctionInfo {
    private String auctionTitle;
    private String auctionFromUser;
    private String description;
    private LocalDateTime startOfTheAuction;
    private LocalDateTime endOfTheAuction;
    private Float minimalBid;
    private Float highestBid;
    private short bidders;

}
