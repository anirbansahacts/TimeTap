package com.elams.leaveservice.service.impl;
import com.elams.leaveservice.entity.LeaveBalance;
import com.elams.leaveservice.exception.InsufficientLeaveBalanceException;
import com.elams.leaveservice.repository.LeaveBalanceRepository;
import com.elams.leaveservice.service.LeaveBalanceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

import org.springframework.stereotype.Service;
 
@Service
@RequiredArgsConstructor
@Slf4j
public class LeaveBalanceServiceImpl implements LeaveBalanceService {
 
    private final LeaveBalanceRepository repository;
 
    @Override
    public LeaveBalance getLeaveBalanceByEmployeeId(String employeeId) {
        return repository.findByEmployeeId(employeeId)
                .orElseGet(() -> {
log.info("Creating default leave balance for employee {}", employeeId);
                    LeaveBalance balance = new LeaveBalance(null, employeeId, 10, 0);
                    return repository.save(balance);
                });
    }
 
    @Override
    public void deductLeave(String employeeId, int noOfDays) {
        LeaveBalance balance = getLeaveBalanceByEmployeeId(employeeId);
        if (balance.getRemainingLeaves() < noOfDays) {
            throw new InsufficientLeaveBalanceException("Not enough leave balance.");
        }
 
        balance.setUsedLeaves(balance.getUsedLeaves() + noOfDays);
        repository.save(balance);
log.info("Deducted {} days from employee {}. Remaining: {}", noOfDays, employeeId, balance.getRemainingLeaves());
    }
    
    @Override
    public void resetAllLeaveBalances() {
        List<LeaveBalance> allBalances = repository.findAll();
     
        for (LeaveBalance balance : allBalances) {
            balance.setUsedLeaves(0);
            balance.setTotalLeaves(10); // or any default value you prefer
        }
     
        repository.saveAll(allBalances);
        log.info("Leave balances reset for all employees");
    }
    
     
    
}