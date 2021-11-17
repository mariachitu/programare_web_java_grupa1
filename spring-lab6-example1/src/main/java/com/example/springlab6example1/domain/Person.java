package com.example.springlab6example1.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Person {

    private String firstName;
    private String lastName;
    private String description;
}
