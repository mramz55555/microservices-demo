//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.isoft.accounts.controller;

import com.isoft.accounts.dto.AccountDTO;
import com.isoft.accounts.dto.CustomerDTO;
import com.isoft.accounts.dto.DataBaseConfigDTO;
import com.isoft.accounts.dto.ErrorResponseDTO;
import com.isoft.accounts.dto.ResponseDTO;
import com.isoft.accounts.service.AccountService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(
        path = {"/api/v1/accounts"},
        produces = {"application/json"}
)
@Tag(
        name = "Accounts rest api"
)
public class AccountController {
    private final AccountService accountService;
    private final DataBaseConfigDTO dataBaseConfigDTO;

    public AccountController(AccountService accountService, DataBaseConfigDTO dataBaseConfigDTO) {
        this.accountService = accountService;
        this.dataBaseConfigDTO = dataBaseConfigDTO;
    }

    @PostMapping({"/create"})
    @Operation(
            summary = "a post method for creating account based on its customer",
            description = "post account method",
            requestBody = @RequestBody(
                    required = true,
                    description = "customer object v2"
            )
    )
    @ApiResponses({@ApiResponse(
            responseCode = "201",
            description = "returns 201 if its unique by mobile number"
    ), @ApiResponse(
            responseCode = "500",
            content = {@Content(
                    schema = @Schema(
                            implementation = ErrorResponseDTO.class
                    )
            )},
            description = "returns 500 if its duplicate"
    )})
    public ResponseEntity<ResponseDTO<AccountDTO>> create(@org.springframework.web.bind.annotation.RequestBody CustomerDTO customerDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseDTO(this.accountService.save(customerDTO), "Account created"));
    }

    @PutMapping({"/update"})
    @Operation(
            summary = "a put method for updating account based on its customer"
    )
    @ApiResponses({@ApiResponse(
            responseCode = "200",
            description = "returns 200 if its exists by mobile number"
    ), @ApiResponse(
            responseCode = "500",
            content = {@Content(
                    schema = @Schema(
                            implementation = ErrorResponseDTO.class
                    )
            )},
            description = "returns 500 if its does not exist"
    )})
    public ResponseEntity<ResponseDTO<CustomerDTO>> update(@org.springframework.web.bind.annotation.RequestBody CustomerDTO customerDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseDTO(this.accountService.update(customerDTO), "Account updated"));
    }

    @GetMapping({"/find-by-mobile-number/{mobile_number}"})
    @Operation(
            summary = "a get method for fetching account based on its mobile number",
            description = "get account method"
    )
    @ApiResponses({@ApiResponse(
            responseCode = "302",
            description = "returns 302 if its found by mobile number"
    ), @ApiResponse(
            responseCode = "500",
            content = {@Content(
                    schema = @Schema(
                            implementation = ErrorResponseDTO.class
                    )
            )},
            description = "returns 500 if it does not exist"
    )})
    public ResponseEntity<ResponseDTO<CustomerDTO>> findCustomerByMobileNumber(@PathVariable("mobile_number") String mobileNumber) {
        return ResponseEntity.status(HttpStatus.FOUND).body(new ResponseDTO(this.accountService.findCustomerByMobileNumber(mobileNumber), "found"));
    }

    @DeleteMapping({"/delete-by-mobile-num/{mobileNumber}"})
    @Operation(
            summary = "a delete method for deleting account based on its mobile number",
            description = "delete account method",
            requestBody = @RequestBody(
                    description = "delete by mobile number's request body",
                    required = true
            )
    )
    @ApiResponses({@ApiResponse(
            responseCode = "200",
            description = "returns 200 if its found and delete by mobile number"
    ), @ApiResponse(
            responseCode = "500",
            content = {@Content(
                    schema = @Schema(
                            implementation = ErrorResponseDTO.class
                    )
            )}
    )})
    public ResponseEntity<String> delete(@PathVariable String mobileNumber) {
        this.accountService.deleteByMobileNumber(mobileNumber);
        return ResponseEntity.ok().body("ok");
    }

    @GetMapping({"/props"})
    public ResponseEntity<DataBaseConfigDTO> getProps() {
        return ResponseEntity.ok(this.dataBaseConfigDTO);
    }
}
