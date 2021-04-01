package kr.co.fastcampus.eatgo.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

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
    @JsonInclude(JsonInclude.Include.NON_NULL) // NULL이 아닐 때만 표시
    private List<MenuItem> menuItems;

    @Transient // 임시 처리
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<Review> reviews;

    public void setMenuItems(List<MenuItem> menuItems) {
        //this.menuItems = menuItems;
        this.menuItems = new ArrayList<>(menuItems);
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = new ArrayList<>(reviews);
    }

    public void updateInfo(String name, String address) {
        this.name = name;
        this.address = address;
    }
}
