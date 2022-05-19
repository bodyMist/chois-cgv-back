package choiscgvback.cgv.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Entity
@Table(name = "DIRECTORS")
@DiscriminatorValue("D")
public class Director extends Worker{
}
