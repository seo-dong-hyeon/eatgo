package kr.co.fastcampus.eatgo.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MenuItem {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private Long restaurantId;

    private String name;
}
