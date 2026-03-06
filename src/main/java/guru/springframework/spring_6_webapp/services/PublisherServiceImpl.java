package guru.springframework.spring_6_webapp.services;

import guru.springframework.spring_6_webapp.domain.Publisher;
import guru.springframework.spring_6_webapp.repositories.PublisherRepository;
import org.springframework.stereotype.Service;

@Service
public class PublisherServiceImpl implements PublisherService{

    private final PublisherRepository publisherRepository;

    public PublisherServiceImpl(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }

    @Override
    public Iterable<Publisher> findAll() {
        return publisherRepository.findAll();
    }
}
