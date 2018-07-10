package com.zb20180409.sygl.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.zb20180409.sygl.domain.Kf;
import com.zb20180409.sygl.domain.PageInfo;
import com.zb20180409.sygl.service.IKfService;
import com.zb20180409.sygl.util.Zjm;

@RestController
public class KfAction {
	@Autowired
	private IKfService service;
	@RequestMapping("/kf.do")
	public PageInfo KfList(Integer page,Integer rows,Integer kfbh,String kfmc) {
		int total=service.total(kfbh, kfmc);
		
		List<Kf> list=service.findKfByPage(page, rows, kfbh, kfmc);
		
		PageInfo p = new PageInfo(total,list);
		return p;
	} 
	@RequestMapping("/kfDelete.do")
	public void delete(int kfbh) {
		service.delete(kfbh);
	}
	@RequestMapping("/kfSaves.do")
	public void saves(MultipartFile excel) throws InvalidFormatException, IOException {
		
		List<Kf> list = new ArrayList<Kf>();
		Workbook wb = WorkbookFactory.create(excel.getInputStream());
		Sheet sheet = wb.getSheetAt(0);
		Zjm z = new Zjm();
		for(int i=1;i<=sheet.getLastRowNum();i++) {
			Row row = sheet.getRow(i);
			Cell c1 = row.getCell(1);
			Cell c2 = row.getCell(2);
			Cell c3 = row.getCell(3);
			Cell c4 = row.getCell(4);
			
			String kfmc = c1.getStringCellValue();
			String kfdz = c2.getStringCellValue();
			String kfgly = c3.getStringCellValue();
			Integer kflxfs = (int)c4.getNumericCellValue();
			String zjm = z.String2Alpha(kfmc);
			Kf kf = new Kf(null,kfmc,zjm,kfdz,kfgly,kflxfs,null,null,null,null,null);
			list.add(kf);
		}
		service.save(list);
	}
	@RequestMapping("/kfEdit.do")
	public Kf edit(int kfbh) {
		return service.edit(kfbh);
	}
	@RequestMapping("/kfUpdate.do")
	public void update(Kf kf) {
		Zjm z = new Zjm();
		String Zjm =z.String2Alpha(kf.getKfmc());
		kf.setZjm(Zjm);
		service.update(kf);
	}
}







