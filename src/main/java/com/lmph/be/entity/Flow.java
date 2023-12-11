package com.lmph.be.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long flowId;

    private String name;

    @OneToMany(mappedBy="flow", orphanRemoval = true, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<FlowSection> flowSections;

    private String createdBy;

    private LocalDate createdDate;

    public Flow() {
    }

    public Flow(Long flowId){
        this.flowId = flowId;
    }

    public Flow(Long flowId, String name, String createdBy, LocalDate createdDate) {
        this.flowId = flowId;
        this.name = name;
        this.createdBy = createdBy;
        this.createdDate = createdDate;
    }
}
