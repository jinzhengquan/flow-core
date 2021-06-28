package cn.flow.engine.service;

import lombok.RequiredArgsConstructor;
import cn.flow.engine.model.FlowTaskHistoric;
import cn.flow.engine.repository.FlowTaskHistoricRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class FlowTaskHistoricService {
    private final FlowTaskHistoricRepository flowTaskHistoricRepository;

    public void saveFlowTaskHistoric(FlowTaskHistoric flowNodeProcessHis) {
        flowTaskHistoricRepository.save(flowNodeProcessHis);
    }
}
