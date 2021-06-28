package cn.flow.core.common;

public interface Regex {
    String HTTP_ADDR = "^([hH][tT]{2}[pP]://|[hH][tT]{2}[pP][sS]://)(([A-Za-z0-9-~]+).)+([A-Za-z0-9-~\\\\/])+$";
    String URL_PATTERN = "^\\/([A-Za-z0-9-~.!#$&'()*+,-/:;=?@_*~|\\\\/])+?$";
    String NODE_TYPE = "^(START_NODE|APPROVAL_NODE|END_NODE)$";
}
