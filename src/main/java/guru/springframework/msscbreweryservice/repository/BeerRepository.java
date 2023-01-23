package guru.springframework.msscbreweryservice.repository;

import guru.springframework.msscbreweryservice.domain.Beer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;


public interface BeerRepository extends JpaRepository<Beer, UUID> {
}
