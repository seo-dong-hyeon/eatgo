package kr.co.fastcampus.eatgo.domain;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class RestaurantTests {

    @Test
    public void creation(){
        Restaurant restaurant = new Restaurant(1004L, "bob", "Seoul");
        assertThat(restaurant.getId(),is(1004L));
        assertThat(restaurant.getName(),is("bob"));
        assertThat(restaurant.getAddress(),is("Seoul"));
    }

    @Test
    public void information(){
        Restaurant restaurant = new Restaurant(1004L, "bob", "Seoul");
        assertThat(restaurant.getInformation(),is("bob in Seoul"));
    }


}