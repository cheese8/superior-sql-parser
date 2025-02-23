package com.github.melin.superior.sql.parser

import java.io.Serializable

/**
 * Created by libinsong on 2017/3/6.
 */

enum class StatementType: Serializable {
    CREATE_DATABASE,
    DROP_DATABASE,
    DESC_DATABASE,

    CREATE_TABLE,
    CREATE_TABLE_AS_SELECT,
    REPLACE_TABLE,
    REPLACE_TABLE_AS_SELECT,
    CREATE_TABLE_AS_LIKE,
    DROP_TABLE,
    DROP_TABLE_TIDB, //mysql
    TRUNCATE_TABLE,
    RENAME_TABLE, //mysql
    MERGE_TABLE,
    REFRESH_TABLE,
    LOAD_TEMP_TABLE,
    EXPORT_TABLE,
    ANALYZE_TABLE,

    ALTER_TABLE_RENAME,
    ALTER_TABLE_ADD_COLS,
    ALTER_TABLE_ADD_COL,//mysql
    ALTER_TABLE_DROP_COL,//mysql, iceberg
    ALTER_TABLE_RENAME_COL,
    ALTER_TABLE_CHANGE_COL,
    ALTER_TABLE_MODIFY_COL, //mysql
    ALTER_TABLE_DROP_PARTS,
    ALTER_TABLE_ADD_PARTS,
    ALTER_TABLE_RENAME_PART,
    ALTER_TABLE_PROPERTIES,
    ALTER_TABLE_SET_LOCATION,
    ALTER_TABLE_ADD_INDEX, //mysql
    ALTER_TABLE_DROP_INDEX, //mysql
    ALTER_TABLE_ADD_UNIQUE_KEY, //mysql
    ALTER_TABLE_ADD_PRIMARY_KEY, //mysql
    DESC_TABLE,
    MSCK_TABLE,
    ALTER_TABLE_TOUCH,

    //DML
    QUERY,
    SELECT,
    DELETE,
    UPDATE,
    INSERT_VALUES,
    INSERT_SELECT,
    MULTI_INSERT,
    MERGE_INTO_TABLE,

    CREATE_VIEW,
    DROP_VIEW,
    ALTER_VIEW_QUERY,
    ALTER_VIEW_RENAME,
    ALTER_VIEW_PROPERTIES,

    CREATE_FUNCTION,
    DROP_FUNCTION,

    SHOW, //mysql 命令
    SHOW_COLUMNS,
    SHOW_PARTITIONS,
    SHOW_TABLES,
    SHOW_VIEWS,
    SHOW_TABLE_EXTENDED,
    SHOW_TABLE_PROPERTIES,
    SHOW_CREATE_TABLE,

    SHOW_FUNCTIONS,
    DESC_FUNCTION,

    CACHE,
    UNCACHE,
    CLEAR_CACHE,

    EXPLAIN,
    SET,
    UNSET,
    JOB,
    USE,

    DATATUNNEL,
    CALL,
    SYNC,

    ARITHMETIC,
    OPTIMIZE, // clickhouse

    UNKOWN;
}
