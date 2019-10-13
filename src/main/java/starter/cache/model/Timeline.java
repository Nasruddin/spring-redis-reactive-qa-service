package starter.cache.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;
import starter.domain.Answer;
import starter.domain.Question;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@RedisHash("timeline")
public class Timeline {

    @Indexed
    @Id
    private Long id;
    private Question question;
    private Set<Answer> answers;
}
