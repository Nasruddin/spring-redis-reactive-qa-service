package starter.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

/**
 * Created by nasir on 18/11/17.
 */
@Entity
@Getter
@Setter
public class Answer implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "answer_id")
    private Long id;


    @Column(name = "answer")
    private String answer;

    @Column(name = "answer_votes")
    private Long votes;

    @ManyToOne
    @JoinColumn(name = "question_id", nullable = false)
    private Question question;
}
