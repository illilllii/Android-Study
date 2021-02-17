package com.cos.moviegridapplicationtest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
class Movie {
    private Integer id;
    private String title;
    private Integer pic;
}
