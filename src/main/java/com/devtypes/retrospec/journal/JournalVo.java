package com.devtypes.retrospec.journal;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.annotation.ParametersAreNonnullByDefault;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import java.util.UUID;

@ParametersAreNonnullByDefault
@NoArgsConstructor
@AllArgsConstructor
public class JournalVo {
    @Id
    private UUID id;

    @NotBlank
    private String name;
}
