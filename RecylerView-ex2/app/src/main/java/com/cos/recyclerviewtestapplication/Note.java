package com.cos.recyclerviewtestapplication;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Note {
    Integer id;
    String title;
    String subTitle;
    Integer min;
}
