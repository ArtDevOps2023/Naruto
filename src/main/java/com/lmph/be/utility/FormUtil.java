package com.lmph.be.utility;

import com.lmph.be.dto.FlowSectionInfo;
import com.lmph.be.entity.*;
import com.lmph.be.form.EmployeeFlowForm;
import com.lmph.be.form.FlowForm;
import org.springframework.beans.BeanUtils;

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
//        if(employeeFlowForm.getFlows() != null)
//            employeeFlow.setFlows(employeeFlowForm.getFlows().stream().map(FormUtil::flowFormToEntity).toList());
//        else if(employeeFlowForm.getFlowId() != null)
//            employeeFlow.getFlows().add(new Flow(employeeFlowForm.getFlowId()));
        employeeFlow.setFlow(new Flow(employeeFlowForm.getFlowId()));

        employeeFlow.setSortOrder(employeeFlowForm.getSortOrder());

        return employeeFlow;

    }

    /**
     * @author Jeffrey John Javison
     * @since 12-Dec-2023
     * @param flowForm
     * @return
     */
    public static Flow flowFormToEntity(FlowForm flowForm){
        Flow flow = new Flow();

        BeanUtils.copyProperties(flowForm, flow);

        return flow;
    }

}
