package guru.springframework.spring_6_webapp.services;

import guru.springframework.spring_6_webapp.domain.Publisher;

public interface PublisherService {

    Iterable<Publisher> findAll();
}
