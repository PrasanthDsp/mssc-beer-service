package guru.springframework.msscbreweryservice.web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Null;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BeerDto {

    @Null
    private UUID id;

    @Null
    private Integer version;
    @Null
    private OffsetDateTime createDate;
    @Null
    private OffsetDateTime lastModifiedDate;
    @NotBlank
    private String beerName;
    @NotBlank
    private BeerStyleEnum beerStyle;

    @Positive
    @NotBlank
    private long upc;

    @Positive
    @NotBlank
    private BigDecimal price;
    private Integer quantity;
}
