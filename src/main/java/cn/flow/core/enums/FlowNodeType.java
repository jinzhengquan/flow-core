package cn.flow.core.enums;

public enum FlowNodeType {
    START_NODE(0, "START_NODE"), APPROVAL_NODE(1, "APPROVAL_NODE"), END_NODE(2, "END_NODE");

    private int index;
    private String type;

    FlowNodeType(int index, String type) {
        this.index = index;
        this.type = type;
    }

    public String value() {
        return type;
    }
}
