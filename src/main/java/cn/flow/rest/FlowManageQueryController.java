package cn.flow.rest;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/flow-manage")
@Tag(name = "flow manage query APIs")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class FlowManageQueryController {
}
