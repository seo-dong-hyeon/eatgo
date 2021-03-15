package kr.co.fastcampus.eatgo.domain;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class RestaurantTests {

    @Test
    public void creation(){
        Restaurant restaurant = Restaurant.builder()
                .id(1004L)
                .name("bob")
                .address("Seoul")
                .build();
        assertThat(restaurant.getId(),is(1004L));
        assertThat(restaurant.getName(),is("bob"));
        assertThat(restaurant.getAddress(),is("Seoul"));
    }
}