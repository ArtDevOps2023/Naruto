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
    @ManyToOne(targetEntity = Employee.class, fetch = FetchType.LAZY)
    private Employee employee;

    @Column(insertable=false, updatable=false, name = "employee_id")
    private Long employeeId;

    @JoinColumn(name="flow_id")
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    private Flow flow;

    private Integer sortOrder;

    @Override
    public String toString() {
        return "EmployeeFlow{" +
                "id=" + id +
                ", employee=" + employee +
                ", employeeId=" + employeeId +
                ", flow=" + flow +
                ", sortOrder=" + sortOrder +
                '}';
    }
}
