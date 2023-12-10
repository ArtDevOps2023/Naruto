package com.lmph.be.form;

import com.lmph.be.enums.PassFailFlag;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;

@Data
public class EmployeeFlowForm implements Serializable {

    @Serial
    private static final long serialVersionUID = 9008820118367315917L;

    private Long id;

    @NotNull(message = "Flow name must be selected.")
    @Positive
    private Long flowId;

    @NotNull(message = "Section name must be selected.")
    @Positive
    private Long sectionId;

    @NotNull(message = "Employee must be selected.")
    @Positive
    private Long employeeId;

    @NotNull(message = "Subsection must be selected.")
    @Positive
    private Long subsectionId;

    @NotEmpty
    private String status;

    @NotNull
    private PassFailFlag passFailFlag = PassFailFlag.Unset;

    @PastOrPresent
    private LocalDate startDate;

    @PastOrPresent
    private LocalDate completedDate;

}
