package dev.service;

import dev.domain.Person;
import dev.service.colleagues.WSColleagueService1;
import dev.service.colleagues.WSColleagueService2;
import io.vavr.collection.List;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class ExternalPersonService {

    private final WSColleagueService1 wsColleagueService1;
    private final WSColleagueService2 wsColleagueService2;

    public ExternalPersonService(WSColleagueService1 wsColleagueService1, WSColleagueService2 wsColleagueService2) {
        this.wsColleagueService1 = wsColleagueService1;
        this.wsColleagueService2 = wsColleagueService2;
    }

    private Integer birthDateToAge(String dateNaissance) {
        Period p = Period.between(ZonedDateTime.parse(dateNaissance, DateTimeFormatter.ofPattern("yyy-MM-dd'T'HH:mm:ss ZZZZZ")).toLocalDate(), LocalDate.now());
        return p.getYears();
    }

    public Flux<Person> findAll() {
        return wsColleagueService1.findAll()
                .concatWith(wsColleagueService2.findAll())
                .map(colleague -> new Person(colleague.getEmail(), colleague.getPrenom(), colleague.getNom(), birthDateToAge(colleague.getDateNaissance())));
    }
}
