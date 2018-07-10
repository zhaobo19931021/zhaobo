package com.zb20180409.sygl.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.zb20180409.sygl.dao.ISpDao;
import com.zb20180409.sygl.domain.Sp;
import com.zb20180409.sygl.service.ISpService;

@Service
@Transactional(isolation=Isolation.SERIALIZABLE,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
public class SpServiceImpl implements ISpService {
	@Autowired
	private ISpDao dao ;

	@Override
	@Transactional(readOnly=true)
	public int total(Integer spbh, String spmc) {
		return dao.total(spbh, spmc);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Sp> findSpByPage(Integer page,Integer rows, Integer spbh, String spmc) {
		int start = (page-1)*rows ;
		int length = rows ;
		return dao.findSpByPage(start, length, spbh, spmc);
	}

	@Override
	public void delete(int spbh) {
		dao.delete(spbh);
	}

	@Override
	public void saves(List<Sp> spList) {
		for(Sp sp : spList) {
			dao.save(sp) ;
		}
		
	}

	@Override
	@Transactional(readOnly=true)
	public Sp edit(int spbh) {
		return dao.findOne(spbh);
	}

	@Override
	public void update(Sp sp) {
		// TODO Auto-generated method stub
		dao.update(sp) ;
	}
}

