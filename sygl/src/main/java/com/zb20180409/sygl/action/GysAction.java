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

import com.zb20180409.sygl.domain.Gys;
import com.zb20180409.sygl.domain.PageInfo;
import com.zb20180409.sygl.service.IGysService;
import com.zb20180409.sygl.util.Zjm;

@RestController
public class GysAction {
	@Autowired
	private IGysService service;
	@RequestMapping("/gys.do")
	public PageInfo gysList(Integer page,Integer rows,Integer gysbh,String gysmc) {
		int total=service.total(gysbh, gysmc);
		
		List<Gys> list=service.findGysByPage(page, rows, gysbh, gysmc);
		
		PageInfo p = new PageInfo(total,list) ;
		return p ;
		
	}
	@RequestMapping("/gysDelete.do")
	public void delete(int gysbh) {
		service.delete(gysbh);
	}
	@RequestMapping("/saves.do")
	public void save(MultipartFile excel) throws InvalidFormatException, IOException {
		List<Gys> list = new ArrayList<Gys>();
		Workbook wb = WorkbookFactory.create(excel.getInputStream());
		
		Sheet sheet = wb.getSheetAt(0);
		Zjm z = new Zjm();
		for(int i=1;i<=sheet.getLastRowNum();i++) {
			Row row = sheet.getRow(i);
			Cell c1 = row.getCell(1);
			Cell c2 =row.getCell(2);
			Cell c3 =row.getCell(3);
			Cell c4 =row.getCell(4);
			
			String gysmc = c1.getStringCellValue();
			String gyslxfs = c2.getStringCellValue();
			String gysdz = c3.getStringCellValue();
			String gyslxr = c4.getStringCellValue();
			String zjm = z.String2Alpha(gysmc);
			Gys gys = new Gys(null,gysmc,zjm,gyslxfs,gysdz,gyslxr,null,null,null,null,null);
			list.add(gys);
		}
		service.save(list);
	} 
	@RequestMapping("/gysEdit.do")
	public Gys edit(int gysbh) {
		return service.edit(gysbh);
	}
	@RequestMapping("/gysUpdate.do")
	public void update(Gys gys) {
		Zjm z = new Zjm();
		String Zjm = z.String2Alpha(gys.getGysmc());
		gys.setZjm(Zjm);
		service.update(gys);
	}

}

