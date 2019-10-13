package starter.cache.service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;
import starter.cache.model.Timeline;
import starter.cache.repository.TimelineRepository;

import java.util.Optional;

@Getter
@Setter
@AllArgsConstructor
@Service
public class TimelineService {

    private final TimelineRepository timelineRepository;

    public Timeline save(Timeline timeline) {
        return timelineRepository.save(timeline);
    }

    public Optional<Timeline> getTimeline(Long id) {
        return timelineRepository.findById(id);
    }
}
