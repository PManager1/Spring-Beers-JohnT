package guru.springframework.spring6restmvc.model;

import lombok.Builder;
import lombok.Data;
import lombok.Singular;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Builder
@Data
public class Partner {
    private UUID id;
    private String firstName;
    private String lastName;
    private String email;
    private String country;
    @Singular private List<String> availableDates;

}
