package com.example.project3.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TaskDto {

    private int id;

    private int customers;

    private String title;

    private String description;

    private Boolean completed;
}
