package cn.flow.core.common;

public interface ErrorCodes {
    //invalidate error code
    String INVALIDATE_FLOW_CATEGORY_NAME_IS_NULL = "FLOW-000001";
    String INVALIDATE_FLOW_CATEGORY_NAME_LENGTH_LESS_100 = "FLOW-000002";
    String INVALIDATE_FLOW_CATEGORY_ID_IS_NULL = "FLOW-000003";
    String INVALIDATE_FLOW_MODEL_NAME_IS_NULL = "FLOW-000004";
    String INVALIDATE_FLOW_MODEL_NAME_LENGTH_LESS_100 = "FLOW-000005";
    String INVALIDATE_CREATE_BY = "FLOW-000006";
    String INVALIDATE_EDITED_BY = "FLOW-000007";
    String INVALIDATE_FLOW_MODEL_ID_IS_NULL = "FLOW-000008";
    String INVALIDATE_FLOW_NODE_NAME_IS_NULL = "FLOW-000009";
    String INVALIDATE_FLOW_NODE_NAME_LENGTH_LESS_100 = "FLOW-000010";
    String INVALIDATE_FLOW_NODE_TYPE_ERROR = "FLOW-000011";
    String INVALIDATE_FLOW_NODE_ID_IS_NULL = "FLOW-000012";
    String INVALIDATE_FLOW_START_NODE_ID_IS_NULL = "FLOW-000013";
    String INVALIDATE_FLOW_END_NODE_ID_IS_NULL = "FLOW-000014";
    String INVALIDATE_FLOW_NODE_LINKED_ID_IS_NULL = "FLOW-000015";
    String INVALIDATE_FLOW_NODE_OPERATOR_ID_IS_NULL = "FLOW-000016";
    String INVALIDATE_FLOW_INSTANCE_ID_IS_NULL = "FLOW-000017";
    String INVALIDATE_FLOW_DEPLOY_MODEL_ID_IS_NULL = "FLOW-000018";
    String INVALIDATE_FLOW_DEPLOY_NODE_ID_IS_NULL = "FLOW-000019";
    String INVALIDATE_FLOW_OPERATOR_IS_NULL = "FLOW-000020";
    String INVALIDATE_FLOW_TASK_ID_IS_NULL = "FLOW-000021";

    //business error code
    String DUPLICATED_FLOW_CATEGORY_NAME = "FLOW-100001";
    String FLOW_CATEGORY_PARENT_ID_NOT_EXIST = "FLOW-100002";
    String FLOW_CATEGORY_ID_NOT_EXIST = "FLOW-100003";
    String FLOW_CATEGORY_ID_EQ_PARENT_ID = "FLOW-100004";
    String FLOW_SUB_CATEGORY_EXIST_NOT_DELETE = "FLOW-100005";
    String DUPLICATED_FLOW_MODEL_NAME = "FLOW-100006";
    String FLOW_MODEL_ID_NOT_EXIST = "FLOW-100007";
    String DUPLICATED_FLOW_NODE_NAME = "FLOW-100008";
    String FLOW_NODE_ID_NOT_EXIST = "FLOW-100009";
    String FLOW_NODE_LINKED_ID_NOT_EXIST = "FLOW-100010";
    String DUPLICATED_START_FLOW_NODE = "FLOW-100011";
    String DUPLICATED_END_FLOW_NODE = "FLOW-100012";
    String FLOW_NODE_OPERATOR_ID_NOT_EXIST = "FLOW-100013";
    String FLOW_DEPLOY_MODEL_ID_NOT_EXIST = "FLOW-100014";
    String FLOW_DEPLOY_START_NODE_ID_NOT_EXIST = "FLOW-100015";
    String FLOW_TASK_ID_NOT_EXIST = "FLOW-100016";
    String FLOW_NODE_OPERATOR_IS_NOT_NULL = "FLOW-100017";
    String FLOW_INSTANCE_NOT_EXIST = "FLOW-100018";
    String FLOW_DEPLOY_NODE_ID_NOT_EXIST = "FLOW-100019";
}
