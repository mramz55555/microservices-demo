package com.isoft.accounts.dto;

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public abstract class BaseDTO {
    private Long id;
    private String createdUser;
    private LocalDate createdDate;
    private String updatedUser;
    private LocalDate updatedDate;

}
