package agoraz.coursescheduler.coursescheduler.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "event")
public class Event {

    @Id
    @GeneratedValue
    @Column(name = "event_id")
    private int id;

    private String name;

    private String details;

    private String color;


    @Basic
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm")
    private Date start;


    @Basic
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm")
    private Date end;

    @OneToOne
    private Member member;

    /*// a participant attends to an event (or session)
    @OneToMany//(mappedBy = "event")
    private List<Attendance> attendances;*/

    @OneToMany
    @JoinTable(
            name="attendance"
            , joinColumns={
            @JoinColumn(name="event_id", nullable=false)
    }
            , inverseJoinColumns={
            @JoinColumn(name="participant_id", nullable=false)
    }
    )
    private List<Attendance> attendances;


}
