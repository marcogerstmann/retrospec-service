package com.devtypes.retrospec.dailyjournal;

import com.devtypes.retrospec.common.base.BaseDataService;
import org.springframework.stereotype.Service;

import javax.annotation.ParametersAreNonnullByDefault;
import javax.transaction.Transactional;

@Service
@Transactional
@ParametersAreNonnullByDefault
public class DailyJournalService extends BaseDataService<DailyJournal, DailyJournalVo> implements IDailyJournalService {

    public DailyJournalService(DailyJournalRepository dailyJournalRepository, DailyJournalConverter dailyJournalConverter) {
        super(dailyJournalRepository, dailyJournalConverter);
    }

}
