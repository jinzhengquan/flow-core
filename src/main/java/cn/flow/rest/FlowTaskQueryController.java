package cn.flow.rest;

import cn.flow.query.view.*;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.flow.query.*;
import org.flow.query.view.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import cn.flow.query.FlowQuery;
import test.flow.query.view.*;

import java.util.List;

@RestController
@RequestMapping("/api/flow-process")
@Tag(name = "flow process query APIs")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class FlowTaskQueryController {
    private final FlowQuery flowQuery;

    @GetMapping("/search-flow-info")
    public List<FlowBriefView> searchFlowInfo(@RequestParam("operator") String operator,
                                              @RequestParam(value = "role") String role) {
        return flowQuery.searchStartFlowInfo(operator, role);
    }

    @GetMapping("/search-flow-deal-with")
    public List<FlowDealWithBriefView> searchFlowDealWith(@RequestParam("operator") String operator,
                                                          @RequestParam(value = "role") String role) {
        return flowQuery.searchDealWithFlow(operator, role);
    }

    @GetMapping("/search-flow-task")
    public FlowTaskBriefView searchFlowTask(@RequestParam("flowTaskId") String flowTaskId) {
        return flowQuery.searchFlowTask(flowTaskId);
    }

    @GetMapping("/search-flow-already-deal")
    public List<FlowAlreadyBriefView> searchFlowAlreadyDeal(@RequestParam("operator") String operator) {
        return flowQuery.searchFlowAlreadyDeal(operator);
    }

    @GetMapping("/search-flow-end")
    public List<FlowEndBriefView> searchFlowEnd(@RequestParam("operator") String operator) {
        return flowQuery.searchFlowEnd(operator);
    }

    @GetMapping("/search-flow-chart")
    public void searchFlowChart(@RequestParam("flowTaskId") String flowTaskId) {

    }

    @GetMapping("/search-flow-his-node")
    public void searchFlowHisNode(@RequestParam("flowTaskId") String flowTaskId) {

    }
}
