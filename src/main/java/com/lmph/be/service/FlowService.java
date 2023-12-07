package com.lmph.be.service;

import com.lmph.be.dao.EmployeeFlowDao;
import com.lmph.be.dao.FlowDao;
import com.lmph.be.dao.FlowSectionDao;
import com.lmph.be.dto.FlowInfo;
import com.lmph.be.entity.Flow;
import com.lmph.be.entity.FlowSection;
import com.lmph.be.form.FlowForm;
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

    public List<Flow> getAllFlows(){
        return this.flowDao.findAll();
    }

    public List<FlowSection> getAllFlowSections(){
        return this.flowSectionDao.findAll();
    }

    public FlowInfo upsert(FlowForm flowForm){
        Flow flow = new Flow();
        FlowInfo flowInfo = new FlowInfo();

        flow.setFlowId(null);
        flow.setName(flowForm.getName());
        flow.setCreatedBy(flowForm.getCreatedBy());
        flow.setCreatedDate(flowForm.getCreatedDate());

        flow = this.flowDao.saveAndFlush(flow);

        BeanUtils.copyProperties(flowInfo, flow);

        return flowInfo;
    }

    public void deleteFlow(Long flowId){
        this.flowSectionDao.deleteByflowId(flowId);
        this.flowDao.deleteById(flowId);
    }
}
