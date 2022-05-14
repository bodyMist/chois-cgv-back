package choiscgvback.cgv.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
@NamedEntityGraph(
        name = "member-with-reviews",
        attributeNodes = {
                @NamedAttributeNode("reviews")
        }
)
@Entity
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

    @OneToMany(mappedBy = "member", cascade = CascadeType.REMOVE)
    private List<Review> reviews = new ArrayList<>();
}
