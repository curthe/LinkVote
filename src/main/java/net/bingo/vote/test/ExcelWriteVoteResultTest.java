package net.bingo.vote.test;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import net.bingo.vote.excel.ExcelUtils;
import net.bingo.vote.model.result.VoteResult;

public class ExcelWriteVoteResultTest {

	//测试在excel表格中写入数据,测试通过
	@Test
	public void test() {
		List<VoteResult> list  = new ArrayList<>();
		list.add(new VoteResult("华山", 100));
		list.add(new VoteResult("泰山", 92));
		list.add(new VoteResult("黄山", 89));
		list.add(new VoteResult("白云山", 86));
		
		String excelPath = "H:\\JavaDev\\Bingo\\linkVoteApp\\data\\travel.xlsx";
		ExcelUtils.writeToExcel(excelPath, "旅游", list);
	}
	
	//测试从excel表格中取出数据，测试通过
	@Test
	public void testReadExcel(){
		String path = "H:\\JavaDev\\Bingo\\linkVoteApp\\data\\travel.xlsx";
		try {
			Map<Integer, String> content = ExcelUtils.readExcelContent(path);
			for(Map.Entry<Integer, String> entry: content.entrySet()){
				System.out.println(entry.getValue());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
