package agoraz.coursescheduler.coursescheduler.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
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
}
