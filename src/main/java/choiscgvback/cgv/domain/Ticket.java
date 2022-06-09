package choiscgvback.cgv.domain;

import lombok.Getter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Entity(name = "TICKETS")
public class Ticket {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TICKET_ID")
    private Long id;
    @NotNull
    private Boolean status; // 0: 예매 1: 예매취소
    @NotNull
    private Integer price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MEMBER_ID")
    private Member member;

    public Ticket(Boolean status, Integer price, Member member) {
        this.status = status;
        this.price = price;
        this.member = member;
    }
}
