package org.example.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class DepartmentDto {

    private String name;
    private String location;
    private String manager;
    private double budget;

}
