package com.devtypes.retrospec.journal;

import com.devtypes.retrospec.common.base.BaseController;
import com.devtypes.retrospec.common.rest.Envelope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Nonnull;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/journals")
public class JournalsController extends BaseController<JournalVo, IJournalService> {

    public JournalsController(IJournalService journalService) {
        super(journalService);
    }

//    @Nonnull
//    @GetMapping
//    public Envelope<JournalVo> index() {
//        JournalVo result = new JournalVo();
//        result.setId(UUID.randomUUID());
//        result.setName("My first journal");
//
//        return new Envelope<>(result);
//    }

}
