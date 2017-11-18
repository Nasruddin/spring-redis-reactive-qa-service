package starter.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

/**
 * Created by nasruddin on 5/6/16.
 */
@Entity
@Getter
@Setter
public class Question implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "question_id")
    private Long id;

    @Column(name = "question")
    private String question;

    @Column(name = "question_votes")
    private Long votes;

    @OneToMany(mappedBy = "question")
    private List<Answer> answerList;
}
