package kr.co.fastcampus.eatgo.domain;

import org.springframework.web.bind.annotation.CrossOrigin;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@Entity
public class Restaurant {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String name;
    private String address;

    @Transient // 임시 처리
    private List<MenuItem> menuItems = new ArrayList<MenuItem>();

    // Controller POST -> RequestBody에서 아무것도 없는 객체 생성
    public Restaurant(){

    }

    public Restaurant(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public Restaurant(Long id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public List<MenuItem> getMenuItem(){
        return menuItems;
    }

    public String getInformation() {
        return name +" in "+ address;
    }

    public void addMenuItem(MenuItem menuItem) {
        menuItems.add(menuItem);
    }

    public void setId(long id){
        this.id = id;
    }

    public void setMenuItems(List<MenuItem> menuItems) {
        for(MenuItem menuItem : menuItems){
            addMenuItem(menuItem);
        }
    }

    public void updateInfo(String name, String address) {
        this.name = name;
        this.address = address;
    }
}
