package com.lmph.be.entity;

import com.lmph.be.enums.PassFailFlag;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

/**
 * Entity for Employee's Flow
 *
 * @author Jeffrey John Javison
 * @since 06-Dec-2023
 */
@Data
@Entity
@Table(name="employee_flow")
public class EmployeeFlow {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name="employee_id")
    @OneToOne(targetEntity = Employee.class, fetch = FetchType.LAZY)
    private Employee employee;

    @Column(insertable=false, updatable=false, name = "employee_id")
    private Long employeeId;

    @JoinColumn(name="flow_id")
    @ManyToOne(targetEntity = Flow.class, fetch = FetchType.LAZY)
    private Flow flow;

    @JoinColumn(name="section_id")
    @ManyToOne(targetEntity = Section.class, fetch = FetchType.LAZY)
    private Section section;

    @JoinColumn(name="subsection_id")
    @ManyToOne(targetEntity = Subsection.class, fetch = FetchType.LAZY)
    private Subsection subSection;

    private String status;

    private char passFailFlag;

    private LocalDate startDate;

    private LocalDate completedDate;
}
