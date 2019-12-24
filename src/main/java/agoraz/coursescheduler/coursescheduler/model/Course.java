package agoraz.coursescheduler.coursescheduler.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Course{

    @Id
    @GeneratedValue
    private Long id;

    @NonNull
    private String name;
}
