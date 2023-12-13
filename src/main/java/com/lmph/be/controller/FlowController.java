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
import com.lmph.be.utility.ControllerUtil;
import com.lmph.be.utility.SecurityUtil;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.util.Comparator;
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

    //region Mappings for Spring Web

    @RequestMapping("/flow")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String flowManagement(Model model){
        List<FlowInfo> flowInfos = flowService.retrieveAllFlows();
        model.addAttribute("flows", flowInfos);
        return "flow_list";
    }

    @RequestMapping("/flow/create")
    @PreAuthorize("hasRole('ADMIN')")
    public String flowManagementCreate(Model model){
        List<SectionInfo> sections = sectionService.getAllSections();
        model.addAttribute("sectionsList", sections);
        model.addAttribute("flowInfo", new FlowInfo());
        return "flow_form";
    }

    @RequestMapping("flow/update/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String retrieveFlowAndSectionsById(@PathVariable("id") Long flowId,
                                              Model model){
        FlowInfo flowInfo = this.flowService.getFlowAndItsSections(flowId);

        flowInfo.setFlowSectionInfos(
                flowInfo.getFlowSectionInfos()
                        .stream()
                        .sorted(Comparator.comparing(FlowSectionInfo::getSortOrder)).toList());

        List<SectionInfo> sections = sectionService.getAllSections();

        model.addAttribute("sectionsList", sections);
        model.addAttribute("flowInfo", flowInfo);

        return "flow_form";
    }
    @RequestMapping(value="/flow/addstep")
    public String addFlowSectionInfo(final FlowInfo flowInfo, final BindingResult bindingResult) {
        flowInfo.getFlowSectionInfos().add(new FlowSectionInfo());
        return "flow_form";
    }

    @PostMapping("/flow/save")
    @PreAuthorize("hasRole('ADMIN')")
    public String persistFlowAndSections(@ModelAttribute FlowInfo form,
                                         RedirectAttributes redirectAttributes){
        String action = form.getFlowId() != null ? " added!":"updated!";

        if(form != null) {
            form.setCreatedBy(SecurityUtil.getCurrentUser());
            try{
                this.flowService.upsertFlow(form);
                redirectAttributes.addFlashAttribute("customMessage", form.getName() + " successfully "+ action);
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
                return ControllerUtil.showInternalErrorMessage(redirectAttributes, ex.getMessage(), "/flow");
            }
        }

        return "redirect:/flow";
    }

    @RequestMapping("/flow/delete/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public String flowManagementDelete(@PathVariable Long id,
                                       @RequestParam("name") String name,
                                       RedirectAttributes redirectAttributes){
        try {
            flowService.deleteFlow(id);
            redirectAttributes.addFlashAttribute("customMessage", name + " successfully deleted!");
        } catch (Exception ex) {
            return ControllerUtil.showInternalErrorMessage(redirectAttributes, ex.getMessage(), "/flow");
        }
        return "redirect:/flow";
    }

    //endregion

    //region Mutation Mappings for GraphQL

    @QueryMapping
    public List<FlowInfo> allFlows(){
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

    //endregion

}
