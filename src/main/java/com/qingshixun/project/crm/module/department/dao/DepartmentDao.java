package com.qingshixun.project.crm.module.department.dao;

import java.util.Map;

import org.hibernate.criterion.Criterion;
import org.springframework.stereotype.Repository;

import com.qingshixun.project.crm.core.BaseHibernateDao;
import com.qingshixun.project.crm.core.PageContainer;
import com.qingshixun.project.crm.model.DepartmentModel;

/**
 * 部门处理Dao类
 * 
 * @author Golovin
 * 
 * @version 1.0
 */
@Repository
public class DepartmentDao extends BaseHibernateDao<DepartmentModel, Long> {

    /**
     * 查询所有部门分页信息
     * 
     * @return
     */
    public PageContainer getDepartmentPage(Map<String, String> params) {
        Criterion name = createLikeCriterion("name", "%" + params.get("name") + "%");
        return getDataPage(params, name);
    }
}
