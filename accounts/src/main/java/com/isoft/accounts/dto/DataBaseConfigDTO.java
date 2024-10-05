package com.isoft.accounts.dto;

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.util.List;
import java.util.Map;

import lombok.*;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

@ConfigurationProperties(
        prefix = "isoft"
)
@Validated
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DataBaseConfigDTO {
    private Map<String, String> datasource;
    private List<String> maintainers;
    @Setter(AccessLevel.NONE)
    private String manager;

    public void setManager(String manager) {
        this.manager = manager.trim();
    }
}
