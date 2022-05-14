package choiscgvback.cgv.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Ticket {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TICKET_ID")
    private Long id;
    @NotNull
    private Boolean status; // 0: 예매 1: 예매취소

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member")
    private Member member;
}
