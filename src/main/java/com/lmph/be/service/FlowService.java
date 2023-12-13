package com.lmph.be.service;

import com.lmph.be.dao.EmployeeFlowDao;
import com.lmph.be.dao.FlowDao;
import com.lmph.be.dao.FlowSectionDao;
import com.lmph.be.dto.FlowAndSectionsInfo;
import com.lmph.be.dto.FlowInfo;
import com.lmph.be.dto.FlowSectionInfo;
import com.lmph.be.entity.Flow;
import com.lmph.be.entity.FlowSection;
import com.lmph.be.entity.Section;
import com.lmph.be.form.FlowForm;
import com.lmph.be.form.FlowSectionForm;
import com.lmph.be.utility.DTOUtil;
import com.lmph.be.utility.FormUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class FlowService {

    private FlowDao flowDao;

    private FlowSectionDao flowSectionDao;

    @Autowired
    public FlowService(FlowDao flowDao, FlowSectionDao flowSectionDao) {
        this.flowDao = flowDao;
        this.flowSectionDao = flowSectionDao;
    }

    public List<FlowInfo> retrieveAllFlows(){
        return this.flowDao.findAll().stream().map(DTOUtil::toFlowInfoNullifyFlow).toList();
    }

    public List<FlowSection> retrieveAllFlowSections(){
        return this.flowSectionDao.findAll();
    }

    public FlowInfo upsertFlow(FlowInfo flowInfo){

        Flow flow = new Flow();
        flow.setFlowId(flowInfo.getFlowId());
        flow.setName(flowInfo.getName());
        flow.setCreatedBy(flowInfo.getCreatedBy());
        flow.setCreatedDate(LocalDate.now());

        if(flowInfo.getFlowSectionInfos() != null && !flowInfo.getFlowSectionInfos().isEmpty()) {
            List<FlowSection> flowSections = new LinkedList<>();
            for(FlowSectionInfo fsi: flowInfo.getFlowSectionInfos()){
                FlowSection flowSection = new FlowSection();
                flowSection.setId(fsi.getId());
                flowSection.setFlow(new Flow(fsi.getFlowInfo().getFlowId()));
                flowSection.setSection(new Section(fsi.getSectionInfo().getSectionId()));
                flowSection.setSortOrder(fsi.getSortOrder());

                flowSections.add(flowSection);
            }

            flow.setFlowSections(flowSections);
        }

        this.flowDao.save(flow);

        return flowInfo;
    }

    public FlowInfo upsertFlow(FlowForm flowForm){
        Flow flow = new Flow();
        FlowInfo flowInfo = new FlowInfo();

        BeanUtils.copyProperties(flowForm, flow);

        flow = this.flowDao.save(flow);

        BeanUtils.copyProperties(flow, flowInfo);

        return flowInfo;
    }

    public void deleteFlow(Long flowId){
        this.flowSectionDao.deleteByflowId(flowId);
        this.flowDao.deleteById(flowId);
    }

    public FlowSectionInfo upsertFlowSection(FlowSectionForm flowSectionForm){
        FlowSection flowSection = new FlowSection();
        FlowSectionInfo flowSectionInfo;

        flowSection.setId(flowSectionForm.getId());
        flowSection.setFlow(new Flow(flowSectionForm.getFlowId()));
        flowSection.setSection(new Section(flowSectionForm.getSectionId()));
        flowSection.setSortOrder(flowSectionForm.getSortOrder());

        flowSection = this.flowSectionDao.save(flowSection);

        flowSectionInfo = DTOUtil.toFlowSectionInfo(flowSection);

        return flowSectionInfo;
    }

    public void deleteFlowSection(Long flowSectionId) {
        this.flowSectionDao.deleteById(flowSectionId);
    }

    public FlowInfo getFlowAndItsSections(Long flowId){
        Optional<Flow> flow = this.flowDao.findById(flowId);
        return flow.map(DTOUtil::toFlowInfoNullifyFlow).orElse(null);
    }

}
