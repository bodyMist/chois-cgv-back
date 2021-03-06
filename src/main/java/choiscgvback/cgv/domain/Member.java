package choiscgvback.cgv.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
@NamedEntityGraphs(value = {
        @NamedEntityGraph(
                name = "member-with-reviews",
                attributeNodes = {
                        @NamedAttributeNode("reviews")
                }
        ),
        @NamedEntityGraph(
                name = "member-with-tickets",
                attributeNodes = {
                        @NamedAttributeNode(value = "tickets", subgraph = "ticket_with_running")
                },
                subgraphs = {
                        @NamedSubgraph(name = "ticket_with_running",
                                attributeNodes = {
                                @NamedAttributeNode(value = "running", subgraph = "running_with_movie")
                        }),
                        @NamedSubgraph(name = "running_with_movie",
                        attributeNodes = {
                                @NamedAttributeNode(value = "movie")
                        })
                }
        )
})

@Entity(name = "MEMBERS")
@Getter
@ToString
public class Member{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MEMBER_ID", nullable = false)
    private Long id;
    @NotNull
    private String account;
    @NotNull
    private String password;
    @NotNull
    private String name;
    @NotNull
    private Integer age;
    @NotNull
    private boolean sex;    // 0: 남자 1: 여자
    @NotNull
    private boolean type;   // 0: 관리자 1: 회원

    @JsonIgnore
    @OneToMany(mappedBy = "member", cascade = CascadeType.REMOVE)
    private List<Review> reviews = new ArrayList<>();
    @OneToMany(mappedBy = "member", cascade = CascadeType.REMOVE)
    private List<Ticket> tickets = new ArrayList<>();
}
