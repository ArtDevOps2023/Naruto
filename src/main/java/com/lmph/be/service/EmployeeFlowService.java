package com.lmph.be.service;

import com.lmph.be.dao.EmployeeFlowDao;
import com.lmph.be.dto.EmployeeFlowInfo;
import com.lmph.be.entity.*;
import com.lmph.be.enums.PassFailFlag;
import com.lmph.be.form.EmployeeFlowForm;
import com.lmph.be.utility.FormUtil;
import org.springframework.beans.BeanUtils;
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

    /**
     * @author Jeffrey John Javison
     * @since 11-Dec-2023
     * @param employeeFlowForm
     * @return
     */
    public EmployeeFlowInfo upsertEmployeeFlow(EmployeeFlowForm employeeFlowForm){
        EmployeeFlowInfo employeeFlowInfo = new EmployeeFlowInfo();
        EmployeeFlow employeeFlow = FormUtil.employeeFlowFormToEntity(employeeFlowForm);

        employeeFlow = this.employeeFlowDao.save(employeeFlow);

        BeanUtils.copyProperties(employeeFlow, employeeFlowInfo);

        employeeFlowInfo.setPassFailFlag(PassFailFlag.getReverse(employeeFlow.getPassFailFlag()));

        return employeeFlowInfo;
    }

    /**
     * @author Jeffrey John Javison
     * @since 11-Dec-2023
     * @param employeeId
     */
    public void deleteEmployeeFlow(Long employeeId){
        this.employeeFlowDao.deleteByemployeeId(employeeId);
    }

}
