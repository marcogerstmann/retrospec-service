package com.devtypes.retrospec.dailyjournal;

import com.devtypes.retrospec.common.base.BaseDataServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.ParametersAreNonnullByDefault;
import javax.transaction.Transactional;

@Service
@Transactional
@ParametersAreNonnullByDefault
public class DailyJournalServiceImpl extends BaseDataServiceImpl<DailyJournal, DailyJournalVo> implements DailyJournalService {

    public DailyJournalServiceImpl(DailyJournalRepository dailyJournalRepository, DailyJournalConverter dailyJournalConverter) {
        super(dailyJournalRepository, dailyJournalConverter);
    }

}
