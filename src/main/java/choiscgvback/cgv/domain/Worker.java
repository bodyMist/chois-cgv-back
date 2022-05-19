package choiscgvback.cgv.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@Table(name = "WORKERS")
@Inheritance(strategy = InheritanceType.JOINED)     // 상속관계 - JOIN 전략 사용
@DiscriminatorColumn
public class Worker {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "WORKER_ID")
    private Integer id;
    @NotNull
    private String name;
    @NotNull
    private LocalDateTime birth;
    @NotNull
    private String nationality;

    @OneToMany(mappedBy = "worker")
    private List<MovieWorker> movieWorkers = new ArrayList<>();
}
