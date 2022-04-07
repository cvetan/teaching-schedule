package dev.cvetan.teachingschedule.model.dto;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.security.SecureRandom;
import java.time.Instant;

@Data
public class AcademicYearDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = new SecureRandom().nextLong();

    private String year;
    private Instant startDate;
    private Instant endDate;
}
