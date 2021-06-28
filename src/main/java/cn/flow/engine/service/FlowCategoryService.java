package cn.flow.engine.service;

import cn.flow.engine.application.command.FlowCategoryDeleteCmd;
import cn.flow.engine.application.command.FlowCategoryEditCmd;
import cn.flow.engine.repository.FlowCategoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.var;
import cn.flow.engine.application.command.FlowCategoryCreateCmd;
import cn.flow.engine.factory.FlowCategoryFactory;
import cn.flow.engine.model.FlowCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class FlowCategoryService {
    private final FlowCategoryRepository flowCategoryRepository;
    private final FlowCategoryFactory flowCategoryFactory;


    public void createFlowCategory(FlowCategoryCreateCmd command) {
        flowCategoryRepository.save(flowCategoryFactory.createFlowCategory(command));
    }

    public void deleteFlowCategory(FlowCategory flowCategory, FlowCategoryDeleteCmd command) {
        flowCategoryRepository.deleteById(flowCategory.getId());
    }

    public void editFlowCategory(FlowCategory flowCategory, FlowCategoryEditCmd command) {
        var parentFlowCategory = flowCategoryRepository.findParentId(command.getParentId());
        flowCategory.editCategory(command.getCategoryName(), parentFlowCategory, command.getEditedBy());
    }
}
