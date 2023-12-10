package com.lmph.be.service;

import com.lmph.be.dao.EmployeeFlowDao;
import com.lmph.be.dao.FlowDao;
import com.lmph.be.dao.FlowSectionDao;
import com.lmph.be.dto.FlowInfo;
import com.lmph.be.dto.FlowSectionInfo;
import com.lmph.be.entity.Flow;
import com.lmph.be.entity.FlowSection;
import com.lmph.be.entity.Section;
import com.lmph.be.form.FlowForm;
import com.lmph.be.form.FlowSectionForm;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlowService {

    @Autowired
    private FlowDao flowDao;

    @Autowired
    private FlowSectionDao flowSectionDao;

//    @Autowired
//    public FlowService(FlowDao flowDao, FlowSectionDao flowSectionDao) {
//        this.flowDao = flowDao;
//        this.flowSectionDao = flowSectionDao;
//    }

    public List<Flow> retrieveAllFlows(){
        return this.flowDao.findAll();
    }

    public List<FlowSection> retrieveAllFlowSections(){
        return this.flowSectionDao.findAll();
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
        FlowSectionInfo flowSectionInfo = new FlowSectionInfo();

        BeanUtils.copyProperties(flowSectionForm, flowSection);

        flowSection.setFlow(new Flow(flowSectionForm.getFlowId()));
        flowSection.setSection(new Section(flowSectionForm.getSectionId()));

        flowSection = this.flowSectionDao.save(flowSection);

        BeanUtils.copyProperties(flowSection, flowSectionInfo);

        return flowSectionInfo;
    }

    public void deleteFlowSection(Long flowSectionId) {
        this.flowSectionDao.deleteById(flowSectionId);
    }

}
