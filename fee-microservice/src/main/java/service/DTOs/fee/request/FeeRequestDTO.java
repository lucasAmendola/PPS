package service.DTOs.fee.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Date;

@Data
@Getter
@RequiredArgsConstructor
@AllArgsConstructor
public class FeeRequestDTO {
    @NotNull(message = "id cannot be null")
    @NotEmpty(message = "id cannot be empty")
    private Long id;
    @NotNull(message = "amount cannot be null")
    @NotEmpty(message = "amount cannot be empty")
    private Double amount;
    @NotNull(message = "payDay cannot be null")
    @NotEmpty(message = "payDay cannot be empty")
    private Date payDay;
    @NotNull(message = "paid cannot be null")
    @NotEmpty(message = "paid cannot be empty")
    private Boolean paid;
    @NotNull(message = "playerID cannot be null")
    @NotEmpty(message = "playerID cannot be empty")
    private int playerID;
}
