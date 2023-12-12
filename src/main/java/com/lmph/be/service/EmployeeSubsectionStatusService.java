package com.lmph.be.service;

import com.lmph.be.dao.EmployeeSubsectionStatusDao;
import com.lmph.be.entity.EmployeeSubsectionStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeSubsectionStatusService {

    private EmployeeSubsectionStatusDao employeeSubsectionStatusDao;

    @Autowired
    public EmployeeSubsectionStatusService(EmployeeSubsectionStatusDao employeeSubsectionStatusDao) {
    }

    /**
     * @author Jeffrey John Javison
     * @since 12-Dec-2023
     * @return
     */
    public List<EmployeeSubsectionStatus> retrieveAllEmployeeSubsectionStatus(){
        return this.employeeSubsectionStatusDao.findAll();
    }

    /**
     * @author Jeffrey John Javison
     * @since 12-Dec-2023
     * @return
     */
    public List<EmployeeSubsectionStatus> retrieveEmployeeSubsectionStatusByEmployeeId(Long employeeId){
        return this.employeeSubsectionStatusDao.findByemployeeId(employeeId);
    }
}
