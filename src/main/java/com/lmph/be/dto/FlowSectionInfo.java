package com.lmph.be.dto;

import com.lmph.be.entity.Section;
import com.lmph.be.entity.Flow;
import lombok.Data;

@Data
public class FlowSectionInfo {

    private Long flowSectionId;

    private Flow flow;

    private SectionInfo section;

    private Integer sortOrder;

}
