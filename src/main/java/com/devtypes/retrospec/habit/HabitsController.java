package com.devtypes.retrospec.habit;

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
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/habits")
public class HabitsController {

    private final IHabitService habitService;

    public HabitsController(IHabitService habitService) {
        this.habitService = habitService;
    }

    @Nonnull
    @GetMapping
    protected ResponseEntity<List<HabitVo>> index() {
        return ResponseEntity.ok(habitService.findAll());
    }

    @Nonnull
    @GetMapping("{id}")
    protected ResponseEntity<HabitVo> get(@PathVariable UUID id) {
        return habitService.findById(id)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new RetrospecNotFoundException(RetrospecEntity.HABIT, id));
    }

    @Nonnull
    @PostMapping
    protected ResponseEntity<HabitVo> post(@RequestBody @Valid HabitVo vo) {
        return ResponseEntity.ok(habitService.create(vo));
    }

    @Nonnull
    @PutMapping("{id}")
    protected ResponseEntity<HabitVo> put(@PathVariable UUID id, @RequestBody @Valid HabitVo vo) {
        return ResponseEntity.ok(habitService.updateById(id, vo));
    }

    @Nonnull
    @DeleteMapping("{id}")
    protected ResponseEntity<Void> delete(@PathVariable UUID id) {
        habitService.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
