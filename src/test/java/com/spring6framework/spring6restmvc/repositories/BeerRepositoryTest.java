package com.spring6framework.spring6restmvc.repositories;

import com.spring6framework.spring6restmvc.bootstrap.BootstrapData;
import com.spring6framework.spring6restmvc.entities.Beer;
import com.spring6framework.spring6restmvc.model.BeerStyle;
import com.spring6framework.spring6restmvc.services.BeerCsvServiceImpl;
import jakarta.validation.ConstraintViolationException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.data.domain.Page;

import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DataJpaTest
@Import({BootstrapData.class, BeerCsvServiceImpl.class})
class BeerRepositoryTest {

    @Autowired
    BeerRepository beerRepository;

    @Test
    void testGetBeerListByName() {
        Page<Beer> list = beerRepository.findAllByBeerNameIsLikeIgnoreCase("%IPA%", null);

        assertThat(list.getContent().size()).isEqualTo(336);
    }

    @Test
    void testSaveBeerNameTooLong() {

        assertThrows(ConstraintViolationException.class, () -> {
            beerRepository.save(Beer.builder()
                    .beerName("""
                        We're no strangers to love
                        You know the rules and so do I (do I)
                        A full commitment's what I'm thinking of
                        You wouldn't get this from any other guy""")
                    .beerStyle(BeerStyle.PALE_ALE)
                    .upc("64353235")
                    .price(new BigDecimal("22.12"))
                    .build());

            beerRepository.flush();
        });
    }

    @Test
    void testSaveBeer() {
        Beer savedBeer = beerRepository.save(Beer.builder()
                        .beerName("My beer")
                        .beerStyle(BeerStyle.PALE_ALE)
                        .upc("64353235")
                        .price(new BigDecimal("22.12"))
                .build());

        beerRepository.flush();

        assertThat(savedBeer).isNotNull();
        assertThat(savedBeer.getId()).isNotNull();
    }
}