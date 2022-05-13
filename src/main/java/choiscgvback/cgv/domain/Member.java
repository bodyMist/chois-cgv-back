package choiscgvback.cgv.domain;

import javax.persistence.*;
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
    @Column(name = "NAME", nullable = false)
    private String name;
    @Column(name = "AGE", nullable = false)
    private Integer age;
    @Column(name = "SEX", nullable = false)
    private boolean sex;    // 0: 남자 1: 여자
    @Column(name = "TYPE", nullable = false)
    private boolean type;   // 0: 관리자 1: 회원

    @OneToMany(mappedBy = "member", cascade = CascadeType.REMOVE)
    private List<Review> reviews = new ArrayList<>();
}
