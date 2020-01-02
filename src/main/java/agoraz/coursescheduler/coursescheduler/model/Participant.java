package agoraz.coursescheduler.coursescheduler.model;

import lombok.Data;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@Table(name = "participant")
public class Participant implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "participant_id")
    private Integer id;

    private String name;

    private String firstname;

    @OneToMany(mappedBy = "participant")
    private List<Attendance> attendances;
}
