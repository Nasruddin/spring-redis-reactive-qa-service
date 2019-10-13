package starter.cache.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import starter.cache.model.Timeline;

@Repository
public interface TimelineRepository extends CrudRepository<Timeline, Long> {
}
