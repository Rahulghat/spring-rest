package guru.springframework.spring6restmvc.model;

import lombok.Builder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
@Slf4j
public class Customer {

    private String customerName;
    private UUID id;
    private String version;
    private LocalDateTime createdDate;
    private LocalDateTime updateDate;
}
