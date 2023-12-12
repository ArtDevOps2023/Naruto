package com.lmph.be.dto;

import com.lmph.be.entity.FlowSection;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class FlowInfo {

    private Long flowId;

    private String name;

    private String color;

    private String createdBy;

    private LocalDate createdDate;

    private List<FlowSection> flowSections;
}
