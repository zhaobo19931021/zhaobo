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
import com.zb20180409.sygl.domain.Ks;
import com.zb20180409.sygl.domain.PageInfo;
import com.zb20180409.sygl.service.IKsService;
import com.zb20180409.sygl.util.Zjm;

@RestController
public class KsAction {
	@Autowired
	private IKsService service;
	@RequestMapping("/ks.do")
	public PageInfo filterQuery(Integer page,Integer rows,Integer ksbh,Integer ksmc) {
		int total=service.total(ksbh, ksmc);
		
		List<Ks> ksList = service.findKsByPage(page, rows, ksbh, ksmc);
		
		PageInfo p = new PageInfo(total,ksList);
		return p;
	}
	@RequestMapping("/ksDelete.do")
	public void delete(int ksbh) {
		service.delete(ksbh);
	}	
	@RequestMapping("/ksSaves.do")
	public void saves(MultipartFile excel) throws InvalidFormatException, IOException {
		List<Ks> list = new ArrayList<Ks>();
		Workbook wb = WorkbookFactory.create(excel.getInputStream());
		Sheet sheet = wb.getSheetAt(0);
		Zjm z = new Zjm();
		for(int i=1;i<=sheet.getLastRowNum();i++) {
			Row row = sheet.getRow(i);
			Cell c1 = row.getCell(1);
			Cell c2 = row.getCell(2);
			Cell c3 = row.getCell(3);
			Cell c4 = row.getCell(4);
			Cell c5 = row.getCell(5);
			
			String ksmc = c1.getStringCellValue();
			String ksdz = c2.getStringCellValue();
			String kslxr = c3.getStringCellValue();
			Integer kslxfs = (int)c4.getNumericCellValue();
			String ksfkfs = c5.getStringCellValue();
			String zjm = z.String2Alpha(ksmc);
			Ks ks = new Ks(null,ksmc,zjm,ksdz,kslxr,kslxfs,ksfkfs,null,null,null,null,null);
			list.add(ks);
		}
		service.save(list);
	}
	@RequestMapping("/ksEdit.do")
	public Ks edit(int ksbh) {
		return service.edit(ksbh);
	}
	@RequestMapping("/ksUpdate.do")
	public void update(Ks ks) {
		Zjm z = new Zjm();
		String Zjm =z.String2Alpha(ks.getKsmc());
		ks.setZjm(Zjm);
		service.update(ks);
	}
}











