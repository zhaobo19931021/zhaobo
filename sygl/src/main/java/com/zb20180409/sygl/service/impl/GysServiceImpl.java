package com.zb20180409.sygl.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.zb20180409.sygl.dao.IGysDao;
import com.zb20180409.sygl.domain.Gys;
import com.zb20180409.sygl.service.IGysService;

@Service
@Transactional(isolation=Isolation.SERIALIZABLE,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
public class GysServiceImpl implements IGysService{
	@Autowired
	private IGysDao dao;
	@Override
	@Transactional(readOnly=true)
	public int total(Integer gysbh, String gysmc) {
		return dao.total(gysbh, gysmc);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Gys> findGysByPage(Integer page, Integer rows, Integer gysbh, String gysmc) {
		int start=(page-1)*rows;
		int length=rows;
		return dao.findGysByPage(start, length, gysbh, gysmc);
	}

	@Override
	public void delete(int gysbh) {
		dao.delete(gysbh);
	}

	@Override
	public void save(List<Gys> gysList) {
		for(Gys gys:gysList)
		dao.save(gys);
	}

	@Override
	@Transactional(readOnly=true)
	public Gys edit(int gysbh) {
		return dao.findOne(gysbh);
	}

	@Override
	public void update(Gys gys) {
		dao.update(gys);
	}

	
}
