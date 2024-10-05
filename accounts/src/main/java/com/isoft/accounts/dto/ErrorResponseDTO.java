//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.isoft.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import java.time.LocalDateTime;

import lombok.*;

@Schema(
        name = "Error DTO",
        description = "model for showing error"
)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponseDTO {
    @Schema(
            example = "https://localhost/api/v2/create"
    )
    private String apiPath;
    @Schema(
            example = "404",
            description = "error http code"
    )
    private int errorCode;
    @Schema(
            description = "error details",
            example = "error message"
    )
    private String errorMessage;
    @Schema(
            description = "time that error happened"
    )
    private LocalDateTime errorTime;

}
