package com.lmph.be.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

/**
 * Entity object for Flow's Section
 *
 * @author Jeffrey John Javison
 * @since 06-Dec-2023
 */
@Data
@Entity
@Table(name="flow_section")
public class FlowSection {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "section_id")
    @OneToOne(targetEntity = Section.class, fetch = FetchType.LAZY)
    private Section section;

    @JoinColumn(name = "flow_id")
    @OneToOne(targetEntity = Flow.class, fetch = FetchType.LAZY)
    private Flow flow;

    @Column(name = "flow_id", insertable = false, updatable = false)
    private Long flowId;

    private Boolean passFailFlag;

    private Integer sortOrder;
}
