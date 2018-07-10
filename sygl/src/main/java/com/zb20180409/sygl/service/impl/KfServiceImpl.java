package com.zb20180409.sygl.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.zb20180409.sygl.dao.IKfDao;
import com.zb20180409.sygl.domain.Kf;
import com.zb20180409.sygl.service.IKfService;

@Service
@Transactional(isolation=Isolation.SERIALIZABLE,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
public class KfServiceImpl implements IKfService{
	@Autowired
	private IKfDao dao;

	@Override
	@Transactional(readOnly=true)
	public int total(Integer kfbh, String kfmc) {
		return dao.total(kfbh, kfmc);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Kf> findKfByPage(Integer page, Integer rows, Integer kfbh, String kfmc) {
		int start = (page-1)*rows;
		int length= rows;
		return dao.findKfByPage(start, length, kfbh, kfmc);
	}

	@Override
	public void delete(int kfbh) {
		dao.delete(kfbh);
	}

	@Override
	public void save(List<Kf> kfList) {
		for(Kf kf:kfList)
		dao.save(kf);
	}

	@Override
	@Transactional(readOnly=true)
	public Kf edit(int kfbh) {
		return dao.findOne(kfbh);
	}

	@Override
	public void update(Kf kf) {
		dao.update(kf);
	}
}
