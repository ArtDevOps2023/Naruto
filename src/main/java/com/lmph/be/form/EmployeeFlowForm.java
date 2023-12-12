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
import java.util.List;

@Data
public class EmployeeFlowForm implements Serializable {

    @Serial
    private static final long serialVersionUID = 9008820118367315917L;

    private Long id;

    @Positive
    private Long employeeId;

    @Positive
    private Long flowId;

    @Positive
    private Integer sortOrder;

    private List<FlowForm> flows;

}
