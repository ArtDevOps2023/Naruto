package com.lmph.be.service;

import com.lmph.be.dao.EmployeeFlowDao;
import com.lmph.be.dao.FlowDao;
import com.lmph.be.dao.FlowSectionDao;
import com.lmph.be.entity.Flow;
import com.lmph.be.entity.FlowSection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlowService {

    private FlowDao flowDao;
    private FlowSectionDao flowSectionDao;

    @Autowired
    public FlowService(FlowDao flowDao, FlowSectionDao flowSectionDao) {
        this.flowDao = flowDao;
        this.flowSectionDao = flowSectionDao;
    }

    public List<Flow> getAllFlows(){
        return this.flowDao.findAll();
    }

    public List<FlowSection> getAllFlowSections(){
        return this.flowSectionDao.findAll();
    }
}
