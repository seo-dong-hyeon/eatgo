package kr.co.fastcampus.eatgo.interfaces;


import kr.co.fastcampus.eatgo.application.MenuItemService;
import kr.co.fastcampus.eatgo.domain.MenuItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MenuItemController {

    @Autowired
    private MenuItemService menuItemService;

    @GetMapping("/restaurants/{restaurantId}/menuItems")
    public List<MenuItem> list(@PathVariable Long restaurantId){
        return menuItemService.getMenuItems(restaurantId);
    }

    @PatchMapping("/restaurants/{restaurantId}/menuItems")
    public String bulkUpdate(@PathVariable("restaurantId")Long restaurantId, @RequestBody List<MenuItem> menuItems){
        menuItemService.bulkUpdate(restaurantId, menuItems);

        return "";
    }
}
