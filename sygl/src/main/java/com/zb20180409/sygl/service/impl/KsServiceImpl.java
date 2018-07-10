package com.zb20180409.sygl.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.zb20180409.sygl.dao.IKsDao;
import com.zb20180409.sygl.domain.Ks;
import com.zb20180409.sygl.service.IKsService;

@Service
@Transactional(isolation=Isolation.SERIALIZABLE,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
public class KsServiceImpl implements IKsService{
	@Autowired
	private IKsDao dao;

	@Override
	@Transactional(readOnly=true)
	public int total(Integer ksbh, Integer ksmc) {
		return dao.total(ksbh, ksmc);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Ks> findKsByPage(Integer page, Integer rows, Integer ksbh, Integer ksmc) {
		int start = (page-1)*rows;
		int length = rows;
		return dao.findKsByPage(start, length, ksbh, ksmc);
	}

	@Override
	public void delete(int ksbh) {
		dao.delete(ksbh);
	}

	@Override
	public void save(List<Ks> ksList) {
		for(Ks ks:ksList)
		dao.save(ks);
	}

	@Override
	@Transactional(readOnly=true)
	public Ks edit(int ksbh) {
		return dao.findOne(ksbh);
	}

	@Override
	public void update(Ks ks) {
		dao.update(ks);
		
	}

	
}
