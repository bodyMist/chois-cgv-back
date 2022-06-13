package choiscgvback.cgv.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Entity(name = "TICKETS")
@NoArgsConstructor
public class Ticket {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TICKET_ID")
    private Long id;
    @NotNull
    private Boolean status; // 0: 예매 1: 예매취소
    private Integer price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MEMBER_ID")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "RUNNING_ID")
    private Running running;

    public Ticket(Boolean status, Integer price, Member member, Running running) {
        this.status = status;
        this.price = price;
        this.member = member;
        this.running = running;
    }
}
