package team.java.auction.house.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "MESSAGES")
public class MessageEntity {

    @Column(name = "MESSAGE_SENDER")
    @ManyToOne
    private UserEntity messageSender;

    @Column(name = "MESSAGE_RECIPIENT")
    @ManyToOne
    private UserEntity messageRecipient;

    @Column(name = "MESSAGE_CONTENT")
    private String messageContent;

    @Column(name = "DATE")
    private LocalDateTime date;
}
