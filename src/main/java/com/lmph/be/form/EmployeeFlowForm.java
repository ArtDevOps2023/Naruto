package com.lmph.be.form;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.PastOrPresent;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;

@Data
public class EmployeeFlowForm implements Serializable {

    @Serial
    private static final long serialVersionUID = 9008820118367315917L;

    private Long id;

    @NotEmpty(message = "Flow name must be selected.")
    private Long flowId;

    @NotEmpty(message = "Section name must be selected.")
    private Long sectionId;

    @NotEmpty(message = "Employee must be selected.")
    private Long employeeId;

    @NotEmpty(message = "Subsection must be selected.")
    private Long subsectionId;

    @NotEmpty
    private String status;

    @PastOrPresent
    private LocalDate startDate;

    @PastOrPresent
    private LocalDate completedDate;

}
