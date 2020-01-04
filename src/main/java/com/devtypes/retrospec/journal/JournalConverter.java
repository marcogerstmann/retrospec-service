package com.devtypes.retrospec.journal;

import com.devtypes.retrospec.common.base.AbstractConverter;
import org.dozer.DozerBeanMapper;
import org.springframework.stereotype.Component;

@Component
public class JournalConverter extends AbstractConverter<Journal, JournalVo> {

    public JournalConverter(DozerBeanMapper mapper) {
        super(mapper, Journal.class, JournalVo.class);
    }

}
