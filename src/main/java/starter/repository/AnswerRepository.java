package starter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import starter.domain.Answer;

import java.util.Set;

/**
 * Created by nasir on 18/11/17.
 */
@Repository
public interface AnswerRepository extends JpaRepository<Answer, Long>{
    Set<Answer> findAnswerByQuestionId(Long questionId);
}
