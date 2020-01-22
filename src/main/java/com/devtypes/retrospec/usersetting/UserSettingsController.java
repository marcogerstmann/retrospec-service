package com.devtypes.retrospec.usersetting;

import com.devtypes.retrospec.common.enums.RetrospecEntity;
import com.devtypes.retrospec.common.exception.RetrospecNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Nonnull;
import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/usersettings")
public class UserSettingsController {

    private final UserSettingService userSettingService;

    public UserSettingsController(UserSettingService userSettingService) {
        this.userSettingService = userSettingService;
    }

    @Nonnull
    @GetMapping("{id}")
    protected ResponseEntity<UserSettingVo> get(@PathVariable UUID id) {
        return userSettingService.findById(id)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new RetrospecNotFoundException(RetrospecEntity.USER, id));
    }

    @Nonnull
    @PostMapping
    protected ResponseEntity<UserSettingVo> post(@RequestBody @Valid UserSettingVo vo) {
        return ResponseEntity.ok(userSettingService.create(vo));
    }

    @Nonnull
    @PutMapping("{id}")
    protected ResponseEntity<UserSettingVo> put(@PathVariable UUID id, @RequestBody @Valid UserSettingVo vo) {
        return ResponseEntity.ok(userSettingService.updateById(id, vo));
    }

    @Nonnull
    @DeleteMapping("{id}")
    protected ResponseEntity<Void> delete(@PathVariable UUID id) {
        userSettingService.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
