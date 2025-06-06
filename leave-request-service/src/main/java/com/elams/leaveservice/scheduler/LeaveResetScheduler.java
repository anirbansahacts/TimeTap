package com.elams.leaveservice.scheduler;

import com.elams.leaveservice.service.LeaveBalanceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
 
@Component
@RequiredArgsConstructor
@Slf4j
public class LeaveResetScheduler {
 
    private final LeaveBalanceService leaveBalanceService;
 
    // Runs every Jan 1st at 00:00
    @Scheduled(cron = "0 0 0 1 1 *")  // second minute hour day month weekday
    public void resetAllBalancesForNewYear() {
        log.info(" Running yearly leave balance reset...");
        leaveBalanceService.resetAllLeaveBalances();
        log.info(" Leave balances reset for all employees (Auto Scheduler)");
    }
}

 