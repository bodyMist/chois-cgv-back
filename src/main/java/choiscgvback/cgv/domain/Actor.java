package choiscgvback.cgv.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Entity
@Table(name = "ACTORS")
@DiscriminatorValue("A")
public class Actor extends Worker{
}
