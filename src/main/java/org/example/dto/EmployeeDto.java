package org.example.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class EmployeeDto {

    private String name;
    private String email;
    private double salary;
    private Date startDate;
    private Date endDate;
}
