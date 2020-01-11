package com.devtypes.retrospec.user;

import com.devtypes.retrospec.common.enums.RetrospecEntity;
import com.devtypes.retrospec.common.exception.RetrospecNotFoundException;
import com.devtypes.retrospec.usersetting.IUserSettingService;
import com.devtypes.retrospec.usersetting.UserSettingVo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Nonnull;
import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/users")
public class UsersController {

    private final IUserService userService;
    private final IUserSettingService userSettingService;

    public UsersController(IUserService userService, IUserSettingService userSettingService) {
        this.userService = userService;
        this.userSettingService = userSettingService;
    }

    @Nonnull
    @GetMapping
    protected ResponseEntity<List<UserVo>> index() {
        return ResponseEntity.ok(userService.findAll());
    }

    @Nonnull
    @GetMapping("{id}")
    protected ResponseEntity<UserVo> get(@PathVariable UUID id) {
        return userService.findById(id)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new RetrospecNotFoundException(RetrospecEntity.USER, id));
    }

    @Nonnull
    @GetMapping("{id}/settings")
    protected ResponseEntity<UserSettingVo> getSettings(@PathVariable UUID id) {
        return userSettingService.findByUserId(id)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new RetrospecNotFoundException(RetrospecEntity.USER_SETTING, id));
    }

    @Nonnull
    @PostMapping
    protected ResponseEntity<UserVo> post(@RequestBody @Valid UserVo vo) {
        return ResponseEntity.ok(userService.create(vo));
    }

    @Nonnull
    @PutMapping("{id}")
    protected ResponseEntity<UserVo> put(@PathVariable UUID id, @RequestBody @Valid UserVo vo) {
        return ResponseEntity.ok(userService.updateById(id, vo));
    }

    @Nonnull
    @DeleteMapping("{id}")
    protected ResponseEntity<Void> delete(@PathVariable UUID id) {
        userService.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
