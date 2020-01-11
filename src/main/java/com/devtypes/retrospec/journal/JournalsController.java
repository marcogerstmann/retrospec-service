package com.devtypes.retrospec.journal;

import com.devtypes.retrospec.common.enums.RetrospecEntity;
import com.devtypes.retrospec.common.exception.RetrospecNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Nonnull;
import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/journals")
public class JournalsController {

    private final IJournalService journalService;

    public JournalsController(IJournalService journalService) {
        this.journalService = journalService;
    }

    @Nonnull
    @GetMapping("")
    protected ResponseEntity<List<JournalVo>> index() {
        return ResponseEntity.ok(journalService.findAll());
    }

    @Nonnull
    @GetMapping("{id}")
    protected ResponseEntity<JournalVo> get(@PathVariable UUID id) {
        return journalService.findById(id)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new RetrospecNotFoundException(RetrospecEntity.JOURNAL, id));
    }

    @Nonnull
    @PostMapping("")
    protected ResponseEntity<JournalVo> post(@RequestBody @Valid JournalVo vo) {
        return ResponseEntity.ok(journalService.create(vo));
    }

    @Nonnull
    @PutMapping("{id}")
    protected ResponseEntity<JournalVo> put(@PathVariable UUID id, @RequestBody @Valid JournalVo vo) {
        return ResponseEntity.ok(journalService.updateById(id, vo));
    }

    @Nonnull
    @DeleteMapping("{id}")
    protected ResponseEntity<Void> delete(@PathVariable UUID id) {
        journalService.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
