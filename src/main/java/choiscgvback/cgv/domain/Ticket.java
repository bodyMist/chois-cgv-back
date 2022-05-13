package choiscgvback.cgv.domain;

import javax.persistence.*;

@Entity
public class Ticket {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TICKET_ID")
    private Long id;
    @Column(name = "STATUS")
    private Boolean status; // 0: 예매 1: 예매취소

    @ManyToOne
    @JoinColumn(name = "member")
    private Member member;
}
