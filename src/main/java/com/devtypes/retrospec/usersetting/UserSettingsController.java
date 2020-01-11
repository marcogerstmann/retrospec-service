package com.devtypes.retrospec.usersetting;

import com.devtypes.retrospec.common.enums.RetrospecEntity;
import com.devtypes.retrospec.common.exception.RetrospecNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Nonnull;
import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/usersettings")
public class UserSettingsController {

    private final IUserSettingService userSettingService;

    public UserSettingsController(IUserSettingService userSettingService) {
        this.userSettingService = userSettingService;
    }

    @Nonnull
    @GetMapping
    protected ResponseEntity<List<UserSettingVo>> index() {
        return ResponseEntity.ok(userSettingService.findAll());
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
