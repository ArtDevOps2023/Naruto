package com.lmph.be.dto;

import com.lmph.be.entity.Employee;
import com.lmph.be.entity.Flow;
import com.lmph.be.entity.Section;
import com.lmph.be.entity.Subsection;
import lombok.Data;

import java.time.LocalDate;

@Data
public class EmployeeFlowInfo {

    private Long id;

    private Employee employee;
    private Long employeeId;

    private Flow flow;
    private Long flowId;

    private Section section;
    private Long sectionId;

    private Subsection subsection;
    private Long subsectionId;

    private String status;

    private LocalDate startDate;

    private LocalDate completedDate;

}
