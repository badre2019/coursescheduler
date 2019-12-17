package agoraz.coursescheduler.coursescheduler.model;

import lombok.*;
import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
public class Event {

    @Id
    @GeneratedValue
    private int sessionId;

    private String name;

    private String details;

    private String color;

    @Column
    @Basic
    @Temporal(TemporalType.TIMESTAMP)
    private Date utilTimestampStart;

    @Column
    @Basic
    @Temporal(TemporalType.TIMESTAMP)
    private Date utilTimestampEnd;

    @OneToOne
    private Member member;
}
