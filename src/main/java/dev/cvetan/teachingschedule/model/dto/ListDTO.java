package dev.cvetan.teachingschedule.model.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.security.SecureRandom;
import java.util.Collection;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ListDTO<T extends Serializable> implements Serializable {

    @Serial
    private static final long serialVersionUID = new SecureRandom().nextLong();

    private Collection<T> data;
    private long totalCount;
}
