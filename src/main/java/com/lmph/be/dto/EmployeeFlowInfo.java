package com.lmph.be.dto;

import com.lmph.be.entity.Employee;
import com.lmph.be.entity.Flow;
import com.lmph.be.entity.Section;
import com.lmph.be.entity.Subsection;
import com.lmph.be.enums.PassFailFlag;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class EmployeeFlowInfo {

    private Long id;

    private Employee employee;

    private Flow flow;

    private Integer sortOrder;

}
