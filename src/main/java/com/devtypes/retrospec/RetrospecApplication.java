package com.devtypes.retrospec;

import com.devtypes.retrospec.common.logging.AuditorAwareService;
import org.dozer.DozerBeanMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.Collections;
import java.util.List;

@SpringBootApplication(scanBasePackages = "com.devtypes.retrospec")
@Configuration
@EnableJpaAuditing(auditorAwareRef = "auditorProvider")
public class RetrospecApplication {

    public static void main(String[] args) {
        SpringApplication.run(RetrospecApplication.class, args);
    }

    @Bean
    public DozerBeanMapper dozerBean() {
        List<String> mappingFiles = Collections.singletonList("dozerBeanMapping.xml");
        DozerBeanMapper dozerBean = new DozerBeanMapper();
        dozerBean.setMappingFiles(mappingFiles);
        return dozerBean;
    }

    @Bean
    AuditorAware<String> auditorProvider() {
        return new AuditorAwareService();
    }

}
