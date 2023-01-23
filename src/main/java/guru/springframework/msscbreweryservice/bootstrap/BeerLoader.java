package guru.springframework.msscbreweryservice.bootstrap;

import guru.springframework.msscbreweryservice.domain.Beer;
import guru.springframework.msscbreweryservice.repository.BeerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class BeerLoader implements CommandLineRunner {

    private final BeerRepository beerRepository;

    public BeerLoader(BeerRepository beerRepository) {
        this.beerRepository = beerRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        LoadBeerObjects();
    }

    private void LoadBeerObjects() {
        if(beerRepository.count()==0){
            beerRepository.save(Beer.builder()
                    .beerName("Mango Bobs")
                    .beerStyle("IPA")
                    .quantityToBrew(200)
                    .minOnHand(12)
                    .upc(33701000001L)
                    .price(new BigDecimal("13.25"))
                    .build());

            beerRepository.save(Beer.builder()
                    .beerName("Galaxy Bobs")
                    .beerStyle("PALE_ALE")
                    .quantityToBrew(200)
                    .minOnHand(12)
                    .upc(33701000002L)
                    .price(new BigDecimal("12.75"))
                    .build());
        }

        System.out.println("Loaded Beer :"+beerRepository.count());
    }
}
