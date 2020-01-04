package com.devtypes.retrospec.journal;

import com.devtypes.retrospec.common.rest.Envelope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Nonnull;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/journals")
public class JournalsController {

    @Nonnull
    @GetMapping
    public Envelope<JournalVo> index() {
        JournalVo result = new JournalVo(UUID.randomUUID(), "My first journal");
        return new Envelope<>(result);
    }
    
}
