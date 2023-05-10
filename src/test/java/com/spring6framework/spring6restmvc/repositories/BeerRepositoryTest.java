package com.spring6framework.spring6restmvc.repositories;

import com.spring6framework.spring6restmvc.entities.Beer;
import com.spring6framework.spring6restmvc.model.BeerStyle;
import jakarta.validation.ConstraintViolationException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DataJpaTest
class BeerRepositoryTest {

    @Autowired
    BeerRepository beerRepository;

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