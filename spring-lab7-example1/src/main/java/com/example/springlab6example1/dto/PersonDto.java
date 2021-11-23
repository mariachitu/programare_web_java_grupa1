package com.example.springlab6example1.dto;

import com.example.springlab6example1.validator.OnlyLetters;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PersonDto {

    @NotNull(message = "Name must not null")
    @NotBlank
    @NotEmpty
    @OnlyLetters
    private String name;

    @NotNull(message = "Surname must not be null")
    @NotBlank
    @NotEmpty
    @OnlyLetters(message = "Surname should consist of only letters!")
    private String surname;

    @NotNull(message = "AdditionalInfo must not be null")
    @Size(min = 2, max = 50, message = "AdditionalInfo cannot have this size")
    private String additionalInfo;
}
