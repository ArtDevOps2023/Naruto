package com.lmph.be.controller;

import com.lmph.be.dto.FlowInfo;
import com.lmph.be.entity.Flow;
import com.lmph.be.entity.FlowSection;
import com.lmph.be.form.FlowForm;
import com.lmph.be.service.FlowService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class FlowController {

    FlowService flowService;

    @Autowired
    public FlowController(FlowService flowService) {
        this.flowService = flowService;
    }

    @QueryMapping
    public List<Flow> allFlows(){
        return this.flowService.getAllFlows();
    }

    @QueryMapping
    public List<FlowSection> allFlowsSections(){
        return this.flowService.getAllFlowSections();
    }

    @MutationMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public FlowInfo upsertFlow(@Valid @Argument FlowForm form){
        if (form != null)
            return this.flowService.upsert(form);
        else
            return null;
    }

    @MutationMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public Boolean deleteFlow(@Valid @Argument Long flowId){
        if (flowId != null)
            this.flowService.deleteFlow(flowId);

        return true;
    }

}
