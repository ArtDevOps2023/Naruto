package com.lmph.be.dto;

import com.lmph.be.entity.Section;
import com.lmph.be.entity.Flow;
import lombok.Data;

@Data
public class FlowSectionInfo {

    private Long id;

    private Flow flow;

    private Section section;

    private Integer passFailFlag;

    private Integer sortOrder;

}
