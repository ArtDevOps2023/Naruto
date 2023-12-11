package com.lmph.be.controller;

import com.lmph.be.dto.FlowAndSectionsInfo;
import com.lmph.be.dto.FlowInfo;
import com.lmph.be.dto.FlowSectionInfo;
import com.lmph.be.dto.SectionInfo;
import com.lmph.be.entity.Flow;
import com.lmph.be.entity.FlowSection;
import com.lmph.be.form.FlowAndSectionsForm;
import com.lmph.be.form.FlowForm;
import com.lmph.be.form.FlowSectionForm;
import com.lmph.be.service.FlowService;
import com.lmph.be.service.SectionService;
import com.lmph.be.utility.SecurityUtil;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
public class FlowController {

    FlowService flowService;

    SectionService sectionService;

    @Autowired
    public FlowController(FlowService flowService, SectionService sectionService) {
        this.flowService = flowService;
        this.sectionService = sectionService;
    }

    @RequestMapping("/flow")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String flowManagement(Model model){
        List<Flow> flowInfos = flowService.retrieveAllFlows();
        model.addAttribute("flows", flowInfos);
        return "flow_list";
    }

    @RequestMapping("/flow/create")
    @PreAuthorize("hasRole('ADMIN')")
    public String flowManagementCreate(Model model){
        List<SectionInfo> sections = sectionService.getAllSections();
        model.addAttribute("sections", sections);
        return "flow_form";
    }

    @RequestMapping("/flow/delete/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public String flowManagementDelete(@PathVariable Long id){
        flowService.deleteFlow(id);
        return "flow_list";
    }

    @RequestMapping("flow/update/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String retrieveFlowAndSectionsById(@PathVariable("id") Long flowId,
                                              Model model){
        FlowAndSectionsInfo flowAndSectionsInfo = this.flowService.getFlowAndItsSections(flowId);

        List<SectionInfo> sections = sectionService.getAllSections();

        model.addAttribute("sections", sections);
        model.addAttribute("flowAndSections", flowAndSectionsInfo);

        return "flow_update";
    }

    @PostMapping("flow/save")
    @PreAuthorize("hasRole('ADMIN')")
    public String persistFlowAndSections(@RequestBody FlowAndSectionsForm form){
        return "flow_list";
    }

    @QueryMapping
    public List<Flow> allFlows(){
        return this.flowService.retrieveAllFlows();
    }

    @QueryMapping
    public List<FlowSection> allFlowsSections(){
        return this.flowService.retrieveAllFlowSections();
    }

    @MutationMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public FlowInfo upsertFlow(@Valid @Argument FlowForm form){
        try{
            if (form != null) {

                //populate these required fields
                form.setCreatedBy(SecurityUtil.getCurrentUser());

                if(form.getFlowId() == null)
                    form.setCreatedDate(LocalDate.now());

                return this.flowService.upsertFlow(form);
            }
            else
                throw new Exception("Flow is null.");
        } catch(Exception e){
            return null;
        }
    }

    @MutationMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public Boolean deleteFlow(@Valid @Argument Long flowId){
        try {
            if(flowId != null)
                this.flowService.deleteFlow(flowId);
            else
                throw new Exception("Flow ID is null.");

            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    @MutationMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public FlowSectionInfo upsertFlowSection(@Valid @Argument FlowSectionForm form){
        try{
            if(form != null)
                return this.flowService.upsertFlowSection(form);
            else
                throw new Exception("Employee Flow is null.");
        }
        catch(Exception ex){
            return null;
        }
    }

    @MutationMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public Boolean deleteFlowSection(@Argument Long flowSectionId){
        try {
            if(flowSectionId != null)
                this.flowService.deleteFlowSection(flowSectionId);
            else
                throw new Exception("Flow Section ID is null.");

            return true;
        } catch (Exception ex) {
            return false;
        }
    }


}
