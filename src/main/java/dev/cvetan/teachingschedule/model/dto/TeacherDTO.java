package dev.cvetan.teachingschedule.model.dto;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.security.SecureRandom;

@Data
public class TeacherDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = new SecureRandom().nextLong();
}
