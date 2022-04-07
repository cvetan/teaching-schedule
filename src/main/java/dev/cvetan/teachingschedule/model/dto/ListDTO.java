package dev.cvetan.teachingschedule.model.dto;


import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.security.SecureRandom;
import java.util.Collection;

@Data
public class ListDTO<T extends Serializable> implements Serializable {

    @Serial
    private static final long serialVersionUID = new SecureRandom().nextLong();

    private Collection<T> data;
    private long totalCount;
}
