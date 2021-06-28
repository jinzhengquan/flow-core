CREATE TABLE flow_category
(
    id               bigint(20) NOT NULL AUTO_INCREMENT,
    parent_id        bigint(20) DEFAULT NULL,
    category_name    varchar(64) NOT NULL,
    created_at       TIMESTAMP   NOT NULL,
    created_by       varchar(64) NOT NULL,
    last_modified_at TIMESTAMP   NOT NULL,
    last_modified_by varchar(64) NOT NULL,
    PRIMARY KEY (id) USING BTREE
);

CREATE TABLE flow_model
(
    id                 bigint(20) NOT NULL AUTO_INCREMENT,
    flow_model_name    varchar(64) NOT NULL,
    category_id        bigint(20) NOT NULL,
    flow_model_version int         not null,
    created_at         TIMESTAMP   NOT NULL,
    created_by         varchar(64) NOT NULL,
    last_modified_at   TIMESTAMP   NOT NULL,
    last_modified_by   varchar(64) NOT NULL,
    PRIMARY KEY (id) USING BTREE
);

CREATE TABLE flow_node
(
    id               bigint(20) NOT NULL AUTO_INCREMENT,
    node_name        varchar(64) NOT NULL,
    node_type        varchar(64) NOT NULL,
    flow_model_id    bigint(20) NOT NULL,
    flow_title       varchar(64) DEFAULT NULL,
    created_at       TIMESTAMP   NOT NULL,
    created_by       varchar(64) NOT NULL,
    last_modified_at TIMESTAMP   NOT NULL,
    last_modified_by varchar(64) NOT NULL,
    PRIMARY KEY (id) USING BTREE
);

CREATE TABLE flow_node_linked
(
    id               bigint(20) NOT NULL AUTO_INCREMENT,
    start_node_id    bigint(20) NOT NULL,
    end_node_id      bigint(20) NOT NULL,
    flow_model_id    bigint(20) NOT NULL,
    created_at       TIMESTAMP   NOT NULL,
    created_by       varchar(64) NOT NULL,
    last_modified_at TIMESTAMP   NOT NULL,
    last_modified_by varchar(64) NOT NULL,
    PRIMARY KEY (id) USING BTREE
);

CREATE TABLE flow_instance
(
    id                   varchar(64) NOT NULL,
    flow_deploy_model_id bigint(20) NOT NULL,
    flow_status          varchar(50) NOT NULL,
    created_at           TIMESTAMP   NOT NULL,
    created_by           varchar(64) NOT NULL,
    end_at               TIMESTAMP   NOT NULL,
    PRIMARY KEY (id) USING BTREE
);

CREATE TABLE flow_task
(
    id                   varchar(64) NOT NULL,
    flow_instance_id     varchar(64) NOT NULL,
    started_time         TIMESTAMP   NOT NULL,
    flow_deploy_model_id bigint(20) NOT NULL,
    flow_node_id         bigint(20) NOT NULL,
    end_time             TIMESTAMP   NOT NULL,
    flow_operator        varchar(64) NOT NULL,
    flow_node_status     varchar(50) NOT NULL,
    PRIMARY KEY (id) USING BTREE
);

CREATE TABLE flow_node_operator
(
    id               bigint(20) NOT NULL AUTO_INCREMENT,
    flow_model_id    bigint(20) NOT NULL,
    flow_node_id     bigint(20) NOT NULL,
    operator         varchar(64) DEFAULT NULL,
    role             varchar(64) DEFAULT NULL,
    created_at       TIMESTAMP   NOT NULL,
    created_by       varchar(64) NOT NULL,
    last_modified_at TIMESTAMP   NOT NULL,
    last_modified_by varchar(64) NOT NULL,
    PRIMARY KEY (id) USING BTREE
);

CREATE TABLE flow_deploy_model
(
    id                 bigint(20) NOT NULL AUTO_INCREMENT,
    flow_model_id      bigint(20) NOT NULL,
    flow_model_name    varchar(64) NOT NULL,
    flow_model_version INT         NOT NULL,
    category_id        bigint(20) NOT NULL,
    deployed_at        TIMESTAMP   NOT NULL,
    deployed_by        varchar(64) NOT NULL,
    PRIMARY KEY (id) USING BTREE
);

CREATE TABLE flow_deploy_node
(
    id                   bigint(20) NOT NULL AUTO_INCREMENT,
    node_id              bigint(20) NOT NULL,
    node_name            varchar(64) NOT NULL,
    node_type            varchar(64) NOT NULL,
    flow_title           varchar(64) DEFAULT NULL,
    flow_deploy_model_id bigint(20) NOT NULL,
    deployed_at          TIMESTAMP   NOT NULL,
    deployed_by          varchar(64) NOT NULL,
    PRIMARY KEY (id) USING BTREE
);

CREATE TABLE flow_deploy_node_linked
(
    start_node_id        bigint(20) NOT NULL,
    end_node_id          bigint(20) NOT NULL,
    flow_deploy_model_id bigint(20) NOT NULL,
    deployed_at          TIMESTAMP   NOT NULL,
    deployed_by          varchar(64) NOT NULL
);
CREATE UNIQUE INDEX flow_node_linked_deploy_unique_index on flow_deploy_node_linked (start_node_id, end_node_id, flow_deploy_model_id);

CREATE TABLE flow_deploy_node_operator
(
    id                   bigint(20) NOT NULL AUTO_INCREMENT,
    flow_model_id        bigint(20) NOT NULL,
    flow_node_id         bigint(20) NOT NULL,
    flow_deploy_model_id bigint(20) NOT NULL,
    operator             varchar(64) DEFAULT NULL,
    role                 varchar(64) DEFAULT NULL,
    created_at           TIMESTAMP   NOT NULL,
    created_by           varchar(64) NOT NULL,
    PRIMARY KEY (id) USING BTREE
);

CREATE TABLE flow_task_historic
(
    id                   varchar(64) NOT NULL,
    flow_instance_id     varchar(64) NOT NULL,
    started_time         TIMESTAMP   NOT NULL,
    flow_deploy_model_id bigint(20) NOT NULL,
    flow_node_id         bigint(20) NOT NULL,
    end_time             TIMESTAMP   NOT NULL,
    flow_operator        varchar(64) NOT NULL,
    flow_node_status     varchar(50) NOT NULL,
    PRIMARY KEY (id) USING BTREE
);
