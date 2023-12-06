package com.lmph.be.controller;

import com.lmph.be.entity.Flow;
import com.lmph.be.entity.FlowSection;
import com.lmph.be.service.FlowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class FlowController {

    @Autowired
    FlowService flowService;

    @QueryMapping
    public List<Flow> allFlows(){
        return this.flowService.getAllFlows();
    }

    @QueryMapping
    public List<FlowSection> allFlowsSections(){
        return this.flowService.getAllFlowSections();
    }

}
