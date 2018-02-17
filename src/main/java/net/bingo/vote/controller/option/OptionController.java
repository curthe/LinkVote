package net.bingo.vote.controller.option;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import net.bingo.vote.model.option.Option;
import net.bingo.vote.model.optionType.OptionType;
import net.bingo.vote.model.project.Project;
import net.bingo.vote.service.option.OptionService;
import net.bingo.vote.service.optionType.OptionTypeService;
import net.bingo.vote.service.project.ProjectService;

@Controller
@RequestMapping("/optionController")
public class OptionController {
	@Autowired
	private OptionService optionService;
	
	@Autowired
	private OptionTypeService optionTypeService;
	
	@Autowired
	ProjectService projectService;
	/**
	 * 新增
	 */
	@RequestMapping("/insertOption")
	public void insertOption() {
		
		Option vo =new Option();
		vo.setId("45sdsds");
		vo.setpId("2222");;//-------
		vo.setOtId("pingfen");//----
		
		//要先创建，已有。
	//	OptionType t=new OptionType();
	//	t.setId("pingfen");//-----
	//	t.setOptionType("1");
	//	optionTypeService.insertOptionType(t);
		
		Project t2=new Project();
		t2.setId("2222");//----------
		t2.setTitle("test");
		
		projectService.insertProject(t2);
		optionService.insertOption(vo);
	}

	/**
	 * 修改,根据主键
	 */
	@RequestMapping("/updateOption")
	public void updateOption() {
		Option vo =new Option();
		vo.setId("45sdsds");
		vo.setpId("2222");//------
		vo.setOtId("pingfen");//------
		optionService.updateOption(vo);
		System.out.println(vo);
	}

	/**
	 * 查询
	 */
	@RequestMapping("/selectOption")
	public void selectOption() {
		Option vo =new Option();
		vo.setId("45sdsds");
		vo.setOtId("pingfen");
		optionService.selectOption(vo);
		
	}

	/**
	 * 删除
	 */
	@RequestMapping("/deleteOption")
	public void deleteOption() {
		Option vo =new Option();
		vo.setId("45sdsds");
		vo.setOtId("114");
		optionService.deleteOption(vo.getId());
	 

	}
}
