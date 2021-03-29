package kr.co.fastcampus.eatgo.domain;

import lombok.*;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@CrossOrigin
public class Restaurant {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Setter
    private Long id;

    @NotEmpty
    private String name;

    @NotEmpty
    private String address;

    @Transient // 임시 처리
    private List<MenuItem> menuItems;

    public void setMenuItems(List<MenuItem> menuItems) {
        //this.menuItems = menuItems;
        this.menuItems = new ArrayList<>(menuItems);
    }

    public void updateInfo(String name, String address) {
        this.name = name;
        this.address = address;
    }
}
