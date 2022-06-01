package choiscgvback.cgv.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

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
}
