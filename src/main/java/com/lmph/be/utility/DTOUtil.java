package com.lmph.be.utility;

import com.lmph.be.dto.FlowAndSectionsInfo;
import com.lmph.be.dto.FlowSectionInfo;
import com.lmph.be.dto.SectionInfo;
import com.lmph.be.entity.Flow;
import com.lmph.be.entity.FlowSection;
import com.lmph.be.entity.Section;

import java.util.Comparator;

public class DTOUtil {

    /**
     * @author Jeffrey John Javison
     * @since 11-Dec-2023
     * @param flow
     * @return
     */
    public static FlowAndSectionsInfo toFlowAndSectionsInfo(Flow flow) {
        FlowAndSectionsInfo flowAndSectionsInfo = new FlowAndSectionsInfo();
        flowAndSectionsInfo.setFlowId(flow.getFlowId());
        flowAndSectionsInfo.setFlowName(flow.getName());

        flowAndSectionsInfo.setSectionInfos(
                flow.getFlowSections().stream().map(DTOUtil::toFlowSectionInfo)
                        .sorted(Comparator.comparing(FlowSectionInfo::getSortOrder)).toList());

        return flowAndSectionsInfo;
    }

    /**
     * @author Jeffrey John Javison
     * @since 11-Dec-2023
     * @param flowSection
     * @return
     */
    public static FlowSectionInfo toFlowSectionInfo(FlowSection flowSection){
        FlowSectionInfo flowSectionInfo = new FlowSectionInfo();
        flowSectionInfo.setFlowSectionId(flowSection.getId());
        flowSectionInfo.setFlow(flowSection.getFlow());
        flowSectionInfo.setSection(DTOUtil.toSectionInfo(flowSection.getSection()));
        flowSectionInfo.setSortOrder(flowSection.getSortOrder());
        return flowSectionInfo;
    }

    /**
     *
     * @author Jeffrey John Javison
     * @since 11-Dec-2023
     * @param section
     * @return
     */
    public static SectionInfo toSectionInfo(Section section){
        SectionInfo sectionInfo = new SectionInfo();

        sectionInfo.setSectionId(sectionInfo.getSectionId());
        sectionInfo.setName(section.getName());
        sectionInfo.setColor(section.getColor());
        sectionInfo.setSubsectionList(null);

        return sectionInfo;
    }



}
