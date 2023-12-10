package com.lmph.be.utility;

import com.lmph.be.dto.FlowSectionInfo;
import com.lmph.be.entity.*;
import com.lmph.be.form.EmployeeFlowForm;

public class FormUtil {

    /**
     *
     * @author Jeffrey John Javison
     * @since 11-Dec-2023
     * @param employeeFlowForm
     * @return
     */
    public static EmployeeFlow employeeFlowFormToEntity(EmployeeFlowForm employeeFlowForm){
        EmployeeFlow employeeFlow = new EmployeeFlow();

        employeeFlow.setId(employeeFlowForm.getId());
        employeeFlow.setEmployee(new Employee(employeeFlowForm.getEmployeeId()));
        employeeFlow.setFlow(new Flow(employeeFlowForm.getFlowId()));
        employeeFlow.setSection(new Section(employeeFlowForm.getSectionId()));
        employeeFlow.setSubSection(new Subsection(employeeFlowForm.getSubsectionId()));
        employeeFlow.setStatus(employeeFlowForm.getStatus());
        employeeFlow.setPassFailFlag(employeeFlowForm.getPassFailFlag().getRating());
        employeeFlow.setStartDate(employeeFlowForm.getStartDate());
        employeeFlow.setCompletedDate(employeeFlowForm.getCompletedDate());

        return employeeFlow;

    }

}
