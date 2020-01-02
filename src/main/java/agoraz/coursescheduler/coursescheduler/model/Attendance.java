package agoraz.coursescheduler.coursescheduler.model;

import lombok.Data;
import javax.persistence.*;

@Entity
@Data
@Table(name = "attendance")
public class Attendance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "attendance_id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name ="participant_id")
    private Participant participant;

    @ManyToOne
    @JoinColumn(name ="event_id")
    private Event event;
}
