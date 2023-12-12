package com.lmph.be.utility;

import com.lmph.be.dto.*;
import com.lmph.be.entity.EmployeeFlow;
import com.lmph.be.entity.Flow;
import com.lmph.be.entity.FlowSection;
import com.lmph.be.entity.Section;
import org.springframework.beans.BeanUtils;

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
        flowSectionInfo.setId(flowSection.getId());
        flowSectionInfo.setFlow(DTOUtil.toFlowInfo(flowSection.getFlow()));
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

        sectionInfo.setSectionId(section.getSectionId());
        sectionInfo.setName(section.getName());
        sectionInfo.setColor(section.getColor());
        sectionInfo.setSubsectionList(null);

        return sectionInfo;
    }

    public static EmployeeFlowInfo toEmployeeFlowInfo(EmployeeFlow employeeFlow) {
        EmployeeFlowInfo employeeFlowInfo = new EmployeeFlowInfo();

        BeanUtils.copyProperties(employeeFlow, employeeFlowInfo);

        return employeeFlowInfo;
    }

    /**
     * @author Jeffrey John Javison
     * @since 12-Dec-2023
     * @param flow
     * @return
     */
    public static FlowInfo toFlowInfo(Flow flow){
        FlowInfo flowInfo = new FlowInfo();

        BeanUtils.copyProperties(flow, flowInfo);

        return flowInfo;
    }

}
