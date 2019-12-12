package agoraz.coursescheduler.coursescheduler.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="member")
public class Member {

    @Id
    @GeneratedValue
    private Long id;

    @NonNull
    private String name;

    @NonNull
    private String firstName;

    @ManyToMany
    @JoinTable(
            name="member_course"
            , joinColumns={
            @JoinColumn(name="member_id", nullable=false)
    }
            , inverseJoinColumns={
            @JoinColumn(name="course_id", nullable=false)
    }
    )
    private List<Course> courses;
}

