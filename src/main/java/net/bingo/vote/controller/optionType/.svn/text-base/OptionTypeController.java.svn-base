package net.bingo.vote.controller.optionType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import net.bingo.vote.model.optionType.OptionType;
import net.bingo.vote.service.optionType.OptionTypeService;

@Controller
@RequestMapping("/optionTypeController")
public class OptionTypeController {
	@Autowired
	private OptionTypeService optionTypeService;

	/**
	 * 新增
	 */
	@RequestMapping("/insertOptionType")
	public void insertProject() {
		OptionType vo=new OptionType();
		vo.setId("9527");
		vo.setOptionType("1");
		
		optionTypeService.insertOptionType(vo);
		System.out.println(vo);
	}

	/**
	 * 修改,根据主键
	 */
	@RequestMapping("/updateOptionType")
	public void updateProject() {
		OptionType vo=new OptionType();
		vo.setId("9527");
		vo.setOptionType("2");
		optionTypeService.updateOptionType(vo);
	}

	/**
	 * 查询
	 */
	@RequestMapping("/selectOptionType")
	public void selectProject() {
		OptionType vo=new OptionType();
		vo.setId("9527");
		optionTypeService.selectOptionType(vo);

		
	}

	/**
	 * 删除
	 */
	@RequestMapping("/deleteOptionType")
	public void deleteProject() {
		
		OptionType vo=new OptionType();
		vo.setId("9527");
		vo.setOptionType("1");
		
		optionTypeService.deleteOptionType(vo.getId());
		 

	}

}
