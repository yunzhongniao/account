package org.yunzhong.account.admin.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public abstract class AcctBasicDao<T> {
    private JdbcTemplate template;

    public JdbcTemplate getTemplate() {
        return template;
    }

    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    protected List<T> querySQL(String sql, RowMapper<T> rowMapper, Object... args) {
        return template.query(sql, rowMapper, args);
    }

    protected int updateSQL(String sql, Object... args) {
        return template.update(sql, args);
    }

    protected <W> W queryObject(String sql, Class<W> clz, Object... args) {
        return template.queryForObject(sql, clz, args);
    }
}
