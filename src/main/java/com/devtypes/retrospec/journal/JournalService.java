package com.devtypes.retrospec.journal;

import com.devtypes.retrospec.common.base.BaseDataService;
import org.springframework.stereotype.Service;

import javax.annotation.ParametersAreNonnullByDefault;
import javax.transaction.Transactional;

@Service
@Transactional
@ParametersAreNonnullByDefault
public class JournalService extends BaseDataService<Journal, JournalVo> implements IJournalService {

    public JournalService(JournalRepository journalRepository, JournalConverter journalConverter) {
        super(journalRepository, journalConverter);
    }

}

