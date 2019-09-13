package com.qingshixun.project.crm.module.problem.dao;

import java.util.List;
import java.util.Map;

import org.hibernate.criterion.Criterion;
import org.springframework.stereotype.Repository;

import com.qingshixun.project.crm.core.BaseHibernateDao;
import com.qingshixun.project.crm.core.PageContainer;
import com.qingshixun.project.crm.model.ProblemModel;

/**
 * 问题处理Dao类
 * 
 * @author HJQ
 * 
 * @version 1.0
 */
@Repository
public class ProblemDao extends BaseHibernateDao<ProblemModel,Long> {

	/**
     * 查询所有问题分页信息
     * 
     * @param
     * @return
     */
    public PageContainer getProblemPage(Map<String, String> params) {
    	// 创建根据问题的查询条件
    	Criterion problemName = createLikeCriterion("problem", "%" + params.get("problem") + "%");
    	// 查询，并返回查询到的问题结果信息
    	return getDataPage(params, problemName);
    }
	
    /**
     * 根据输入的问题单，进行搜索
     * 
     * @param
     * @return
     */ 
	public List<ProblemModel> getProblemList(String value) {
		// 创建根据客户名称查询条件
        Criterion problemName = createLikeCriterion("problem", "%" + value + "%");
        // 查询，并返回查询到的客户结果信息
        return find(problemName);
	}
}
