package com.devtypes.retrospec.dailyjournal.dailybullet;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DailyBulletRepository extends JpaRepository<DailyBullet, UUID> {
}
