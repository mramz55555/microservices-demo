//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.isoft.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Schema(
        name = "Response DTO",
        description = "A DTO for successful response"
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResponseDTO<T> {
    @Schema(
            description = "body.all content are shown here",
            example = "{\"id\":1 , \"name\":\"Ali Ahmadi\"}"
    )
    private T body;
    @Schema(
            description = "successful status message",
            example = "200"
    )
    private String statusMessage;
}
