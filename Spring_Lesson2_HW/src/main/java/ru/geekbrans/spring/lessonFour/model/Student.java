package ru.geekbrans.spring.lessonFour.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {

        private Long id;
        private String name;

        public Long getId() {
                return id;
        }

        public String getName() {
                return name;
        }

        public int getScore() {
                return score;
        }

        private int score;



}
