package cn.flow.query.view;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.OffsetDateTime;

@Data
@AllArgsConstructor
public class FlowAlreadyBriefView {
    private String flowNodeProcessId;

    private String flowTitle;

    private OffsetDateTime createdAt;
}
