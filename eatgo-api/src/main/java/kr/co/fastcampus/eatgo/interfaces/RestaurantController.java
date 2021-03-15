package kr.co.fastcampus.eatgo.interfaces;

import kr.co.fastcampus.eatgo.application.RestaurantService;
import kr.co.fastcampus.eatgo.domain.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;

    @GetMapping("/restaurants")
    public List<Restaurant> list(){
        return restaurantService.getRestaurants();
    }

    @GetMapping("/restaurants/{id}")
    public Restaurant detail(@PathVariable("id")Long id){
        return restaurantService.getRestaurant(id);
    }

    @PostMapping("/restaurants")
    public ResponseEntity<?> create(@RequestBody Restaurant resource) throws URISyntaxException {
        Restaurant restaurant = Restaurant.builder()
                .name(resource.getName())
                .address(resource.getAddress())
                .build();
        restaurantService.addRestaurant(restaurant);

        //return ResponseEntity.created(new URI("/restaurant/" + created.getId())).body("");
        return ResponseEntity.created(new URI("/restaurant/1234")).body("");
    }

    @PatchMapping("/restaurants/{id}")
    public String update(@PathVariable("id")Long id, @RequestBody Restaurant resource){
        restaurantService.updateResturant(id, resource.getName(), resource.getAddress());
        return "{}";
    }
}
