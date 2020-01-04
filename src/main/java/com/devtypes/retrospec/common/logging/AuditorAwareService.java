package com.devtypes.retrospec.common.logging;

import org.springframework.data.domain.AuditorAware;

import javax.annotation.Nonnull;
import java.util.Optional;

public class AuditorAwareService implements AuditorAware<String> {

//    @Inject
//    private ISecurityContext securityContext;

    @Override
    @Nonnull
    public Optional<String> getCurrentAuditor() {
//        return Optional.of(this.securityContext.getPrincipal().getId());
        // TODO: Replace by real value of security context
        return Optional.of("Marco");
    }

}
