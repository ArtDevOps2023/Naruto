package com.lmph.be.service;

import com.lmph.be.dao.EmployeeFlowDao;
import com.lmph.be.entity.EmployeeFlow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service for Employee's Flow
 *
 * @author Jeffrey John Javison
 * @since 06-Dec-2023
 */
@Service
public class EmployeeFlowService {

    private EmployeeFlowDao employeeFlowDao;

    @Autowired
    public EmployeeFlowService(EmployeeFlowDao employeeFlowDao) {
        this.employeeFlowDao = employeeFlowDao;
    }

    /**
     * Get all of {@link com.lmph.be.entity.Employee Employee}'s {@link com.lmph.be.entity.Flow Flow}
     *
     * @author Jeffrey John Javison
     * @since 06-Dec-2023
     */
    public List<EmployeeFlow> getEmployeeFlowsByEmployeeId(Long employeeId){
        return this.employeeFlowDao.findByemployeeId(employeeId);
    }


}
