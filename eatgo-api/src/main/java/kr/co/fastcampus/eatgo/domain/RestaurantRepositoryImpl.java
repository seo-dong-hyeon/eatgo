package kr.co.fastcampus.eatgo.domain;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component // Spring이 객체를 관리
public class RestaurantRepositoryImpl implements RestaurantRepository {

    private List<Restaurant> restaurants = new ArrayList<>();

    public RestaurantRepositoryImpl(){
        restaurants.add(new Restaurant(1004L,"bob", "Seoul"));
        restaurants.add(new Restaurant(2020L,"cyber", "Seoul"));
    }

    @Override
    public List<Restaurant> findAll() {
        return restaurants;
    }

    @Override
    public Restaurant findById(Long id) {
        Restaurant restaurant = restaurants.stream()
                .filter(r -> r.getId().equals(id))
                .findFirst()
                .orElse(null);

        return restaurant;
    }
}