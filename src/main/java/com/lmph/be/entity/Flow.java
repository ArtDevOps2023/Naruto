package com.lmph.be.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

/**
 * Entity object for Flow
 *
 * @author Jeffrey John Javison
 * @since 06-Dec-2023
 */
@Data
@Entity
@Table(name="flow")
public class Flow {

    @Id
    @PrimaryKeyJoinColumn
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long flowId;

    private String name;

    private String createdBy;

    private LocalDate createdDate;
}
