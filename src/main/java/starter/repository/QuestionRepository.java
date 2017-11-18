package starter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import starter.domain.Question;

/**
 * Created by nasruddin on 5/6/16.
 */
@Repository
public interface QuestionRepository extends JpaRepository<Question,Long>{

}
