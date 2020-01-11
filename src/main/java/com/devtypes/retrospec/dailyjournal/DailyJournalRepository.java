package com.devtypes.retrospec.dailyjournal;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DailyJournalRepository extends JpaRepository<DailyJournal, UUID> {
}
