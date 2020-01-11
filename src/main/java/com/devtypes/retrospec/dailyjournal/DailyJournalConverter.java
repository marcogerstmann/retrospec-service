package com.devtypes.retrospec.dailyjournal;

import com.devtypes.retrospec.common.base.AbstractConverter;
import org.dozer.DozerBeanMapper;
import org.springframework.stereotype.Component;

@Component
public class DailyJournalConverter extends AbstractConverter<DailyJournal, DailyJournalVo> {

    public DailyJournalConverter(DozerBeanMapper mapper) {
        super(mapper, DailyJournal.class, DailyJournalVo.class);
    }

}
