package com.springPro.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;

import com.springPro.dao.BaseDao;
import com.springPro.entity.Entity;
import com.springPro.service.BaseService;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

@Service
public class BaseServiceImpl implements BaseService {

	@Autowired
	@Qualifier("baseDaoImpl")
	private BaseDao baseDao;
	
	@Override
	public <T extends Entity> List<T> findListByCondition(T condition) {
		// TODO Auto-generated method stub
		return baseDao.findList(condition);
	}

	@Override
	public <T extends Entity> List<T> findPageByCondition(T condition) {
		// TODO Auto-generated method stub
		return baseDao.findPage(condition);
	}

	@Override
	public <T extends Entity> T findOne(T condition) {
		return baseDao.findOne(condition);
	}

	@Override
	public <T extends Entity> void deleteOne(T condition) {
		baseDao.delete(condition);
	}

	@Override
	public <T extends Entity> T saveOrUpdate(T condition) {
		if(condition.getKey() != null){
			return this.baseDao.update(condition);
		}else{
			return this.baseDao.insert(condition);
		}
	}

	@Autowired
	private DataSourceTransactionManager transactionManager;

	public void txManual(){
		DefaultTransactionDefinition def = new DefaultTransactionDefinition();
		def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRES_NEW);// 事物隔离级别，开启新事务
		TransactionStatus status = transactionManager.getTransaction(def); // 获得事务状态
		try{
			//TODO
			transactionManager.commit(status);
		}catch(Exception e){
			transactionManager.rollback(status);
			throw e;
		}
	}
	
	
}
