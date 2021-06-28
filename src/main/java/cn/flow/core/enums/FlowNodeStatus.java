package cn.flow.core.enums;

public enum FlowNodeStatus {
    INIT(0), SAVE(1), SUBMIT(2), READ(3);

    private int index;

    FlowNodeStatus(int index) {
        this.index = index;
    }
}
