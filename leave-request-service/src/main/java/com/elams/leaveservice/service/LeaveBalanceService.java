package com.elams.leaveservice.service;

import com.elams.leaveservice.entity.LeaveBalance;

public interface LeaveBalanceService {
    LeaveBalance getLeaveBalanceByEmployeeId(String employeeId);
    void deductLeave(String employeeId, int noOfDays);
    void resetAllLeaveBalances();
}
