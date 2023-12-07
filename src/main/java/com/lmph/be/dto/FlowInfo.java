package com.lmph.be.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class FlowInfo {

    private Long flowId;

    private String name;

    private String createdBy;

    private LocalDate createdDate;
}
