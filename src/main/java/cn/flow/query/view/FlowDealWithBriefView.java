package cn.flow.query.view;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.OffsetDateTime;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class FlowDealWithBriefView {
    private String flowNodeProcessId;

    private String flowTitle;

    private OffsetDateTime createdAt;
}
