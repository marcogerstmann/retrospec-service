package com.devtypes.retrospec.journal;

import com.devtypes.retrospec.common.base.BaseController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/journals")
public class JournalsController extends BaseController<JournalVo, IJournalService> {

    public JournalsController(IJournalService journalService) {
        super(journalService);
    }

}
