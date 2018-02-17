package net.bingo.vote.excel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import net.bingo.vote.model.result.VoteResult;

/**
 * 对Excel表格的基本的操作
 * 
 * @author 初坤
 *
 */
public class ExcelUtils {
	/**
	 * 
	 * @param excelPath:excel表格的输出路径
	 * @param sheetName:excel表格sheet页的名称
	 * @param data:传入的数据
	 */
	public static void writeToExcel(String excelPath, String sheetName, List<VoteResult> data) {
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("countryDB");
		XSSFRow row = sheet.createRow((short) 0);
		XSSFCell cell = null;
		cell = row.createCell(0);
		cell.setCellValue("投票名称");
		cell = row.createCell(1);
		cell.setCellValue("票数");

		VoteResult result = null;
		for (int j = 0; j < data.size(); j++) {
			result = data.get(j);
			row = sheet.createRow(j + 1);
			cell = row.createCell(0);
			cell.setCellValue(result.getVoteName());
			cell = row.createCell(1);
			cell.setCellValue(result.getVoteNum());
		}

		try {
			FileOutputStream fout = new FileOutputStream(excelPath);
			workbook.write(fout);
			fout.flush();
			fout.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * 读取Excel数据内容
	 * 
	 * @param InputStream
	 * @return Map 包含单元格数据内容的Map对象
	 * @throws IOException 
	 */
	public static Map<Integer, String> readExcelContent(String path) throws IOException {
		Map<Integer, String> content = new HashMap<Integer, String>();
		InputStream in = new FileInputStream(path);
		Workbook wb = new XSSFWorkbook(in);
		XSSFSheet xssfSheet = (XSSFSheet) wb.getSheetAt(0);
		if(xssfSheet==null){
			return null;
		}
		//遍历行
		for(int rowNum=0; rowNum<=xssfSheet.getLastRowNum();rowNum++){
			XSSFRow row = xssfSheet.getRow(rowNum);
			if(row==null){
				continue;
			}
			//遍历cell
			String str="";
			for(int cellNum=0;cellNum<=row.getLastCellNum();cellNum++){
				XSSFCell cell = row.getCell(cellNum);
				if(cell==null){
					continue;
				}
				str += getColumValues(cell)+"\t";
			}
			str = str.substring(0,str.length()-1);
			content.put(rowNum, str);
		}
		
		return content;
	}

	public static String getColumValues(XSSFCell cell) {
		if(cell.getCellTypeEnum()==CellType.STRING){
			return cell.getStringCellValue();
		}
		if(cell.getCellTypeEnum()==CellType.NUMERIC){
			return Double.toString(cell.getNumericCellValue());
		}
		return null;
	}
}
