package com.zb20180409.sygl.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.zb20180409.sygl.dao.IJhdDao;
import com.zb20180409.sygl.dao.IKcDao;
import com.zb20180409.sygl.domain.Jhd;
import com.zb20180409.sygl.service.IJhdService;
@Service
@Transactional(isolation=Isolation.SERIALIZABLE,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
public class JhdServiceImpl implements IJhdService{
	@Autowired
	private IJhdDao dao;
	@Autowired
	private IKcDao dao2;
	@Override
	public int total() {
		return dao.total();
	}

	@Override
	public List<Jhd> findJhdAll(int page, int rows) {
		int start = (page-1)*rows;
		int length = rows;
		return dao.findJhdAll(start, length);
	}

	@Override
	public String findJhdbh(String jhdbhPrefix) {
		return dao.findJhdbh(jhdbhPrefix);
	}

	@Override
	public void save(Jhd jhd, String spbhs, String sls, String djs) {
		dao.save(jhd);
		
		String[] spbhArray = spbhs.split(",");
		String[] slArray = sls.split(",");
		String[] djArray = djs.split(",");
		
		for(int i=0;i<spbhArray.length;i++) {
			dao.saveXq(jhd.getJhdbh(),Integer.parseInt(spbhArray[i]),
					   Integer.parseInt(slArray[i]),Integer.parseInt(djArray[i]));
		}
		
		//库存
		for(int i=0;i<spbhArray.length;i++) {
			int count = dao2.findKcBySpAndKf(Integer.parseInt(spbhArray[i]), jhd.getKf());
			if(count == 0) {
				dao2.saveKc(jhd.getKf(), Integer.parseInt(spbhArray[i]), Integer.parseInt(slArray[i]));
			}else {
				dao2.updateKc(jhd.getKf(), Integer.parseInt(spbhArray[i]), Integer.parseInt(slArray[i]));
			}
		}
	}

}














