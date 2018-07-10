package com.zb20180409.sygl.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.zb20180409.sygl.domain.PageInfo;
import com.zb20180409.sygl.domain.Sp;
import com.zb20180409.sygl.service.ISpService;
import com.zb20180409.sygl.util.Zjm;

@RestController
public class SpAction {

	@Autowired
	private ISpService service ;
	
	@RequestMapping("/sp.do")
	public PageInfo spList(Integer page , Integer rows , Integer spbh , String spmc) {
		
		int total = service.total(spbh, spmc) ;//总页数
		List<Sp> list = service.findSpByPage(page, rows, spbh, spmc) ;//每页显示的数据
		
		PageInfo p = new PageInfo(total,list) ;
		
		return p ;
		
	}
	
	@RequestMapping("/spDelete.do")
	public void delete(int spbh) {
		service.delete(spbh);
	}
	
	@RequestMapping("/spSaves.do")
	public void saves(MultipartFile excel) throws Exception{
		List<Sp> list = new ArrayList<Sp>();
		Workbook book = WorkbookFactory.create(excel.getInputStream()) ;
		
		Sheet sheet = book.getSheetAt(0) ;
		Zjm z = new Zjm();
		for(int i=1;i<=sheet.getLastRowNum();i++) {
			Row row = sheet.getRow(i) ;
			Cell c1 = row.getCell(0);
			Cell c2 = row.getCell(1);
			Cell c3 = row.getCell(2);
			
			String spmc = c1.getStringCellValue() ;
			String dw = c2.getStringCellValue() ;
			String xh = c3.getStringCellValue() ;
			String zjm = z.String2Alpha(spmc) ;
			Sp sp = new Sp(null,spmc,zjm,dw,xh,null,null,null);
			list.add(sp) ;
		}
		
		service.saves(list);
		
	}
	
	@RequestMapping("/spEdit.do")
	public Sp edit(int spbh) {
		return service.edit(spbh) ;
	}
	
	@RequestMapping("/spUpdate.do")
	public void update(Sp sp) {
		Zjm z = new Zjm();
		String zjm = z.String2Alpha(sp.getSpmc()) ;
		sp.setZjm(zjm);
		service.update(sp) ;
	}
	
}

