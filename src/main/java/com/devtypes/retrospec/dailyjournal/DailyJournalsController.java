package com.devtypes.retrospec.dailyjournal;

import com.devtypes.retrospec.common.enums.RetrospecEntity;
import com.devtypes.retrospec.common.exception.RetrospecNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Nonnull;
import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/daily-journals")
public class DailyJournalsController {

    private final IDailyJournalService habitService;

    public DailyJournalsController(IDailyJournalService habitService) {
        this.habitService = habitService;
    }

    @Nonnull
    @GetMapping
    protected ResponseEntity<List<DailyJournalVo>> index() {
        return ResponseEntity.ok(habitService.findAll());
    }

    @Nonnull
    @GetMapping("{id}")
    protected ResponseEntity<DailyJournalVo> get(@PathVariable UUID id) {
        return habitService.findById(id)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new RetrospecNotFoundException(RetrospecEntity.HABIT, id));
    }

    @Nonnull
    @PostMapping
    protected ResponseEntity<DailyJournalVo> post(@RequestBody @Valid DailyJournalVo vo) {
        return ResponseEntity.ok(habitService.create(vo));
    }

    @Nonnull
    @PutMapping("{id}")
    protected ResponseEntity<DailyJournalVo> put(@PathVariable UUID id, @RequestBody @Valid DailyJournalVo vo) {
        return ResponseEntity.ok(habitService.updateById(id, vo));
    }

    @Nonnull
    @DeleteMapping("{id}")
    protected ResponseEntity<Void> delete(@PathVariable UUID id) {
        habitService.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
