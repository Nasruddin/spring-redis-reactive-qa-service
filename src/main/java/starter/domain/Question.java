package starter.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by nasruddin on 5/6/16.
 */
@Entity(name = "questions")
@Getter
@Setter
public class Question extends AuditOperations implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "question_id")
    private Long id;

    @Column(name = "question")
    private String question;

    @Column(name = "question_votes")
    private Long votes;
}
