package net.bingo.vote.controller.optionResult;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import net.bingo.vote.model.optionResult.OptionResult;
import net.bingo.vote.model.optionTemplate.Template;
import net.bingo.vote.model.optionTemplate.Template2;
import net.bingo.vote.model.optionType.OptionType;
import net.bingo.vote.model.user.User;
import net.bingo.vote.service.optionResult.OptionResultService;
import net.bingo.vote.service.optionTemplate.OptionTemplateService;
import net.bingo.vote.service.optionType.OptionTypeService;
import net.bingo.vote.service.user.UserService;

@Controller
@RequestMapping("/optionResultController")
public class OptionResultController {
	@Autowired
	private OptionResultService optionResultService;
	@Autowired
	private UserService userService;

	@Autowired
	private OptionTypeService optionTypeService;
	@Autowired
	@Qualifier("OptionTemplate2Service")
	private OptionTemplateService optionTemplateService2;
	/**
	 * 新增
	 */
	@RequestMapping("/insertOptionResult")
	public void insertOptionResult() {
		OptionResult vo = new OptionResult();
		vo.setId("1");
		vo.setOiId("dsd222");//-------------------
		vo.setResult("true");
		vo.setuId("4546");//--------

		// 用户 选项先创建
		User vo1=new User();
		vo1.setId("4546");//------
		userService.insertUser(vo1);
		//piontype创建
		
		OptionType vo2=new OptionType();
		vo2.setOptionType("4");
		vo2.setId("9527");//-------
		optionTypeService.insertOptionType(vo2);
		
		Template2 vo3=new Template2();
		vo3.setId("dsd222");//-------------------
		vo3.setOrId("cdffrvttbtby");
		vo3.setOtId("9527");//--------
		optionTemplateService2.insertOptionTemplate(vo3);
		
		
		
		optionResultService.insertOptionResult(vo);
	}

	/**
	 * 修改,根据主键
	 */
	@RequestMapping("/updateOptionResult")
	public void updateOptionResult() {
		OptionResult vo = new OptionResult();
		vo.setId("1");
		vo.setOiId("dsd222");//-------------------
		vo.setResult("false");
		vo.setuId("4546");//--------
		optionResultService.updateOptionResult(vo);
	}

	/**
	 * 查询
	 */
	@RequestMapping("/selectOptionResult")
	public void selectOptionResult() {
		OptionResult vo = new OptionResult();
		vo.setId("1");
		vo.setOiId("dsd222");//-------------------
		vo.setResult("false");
		vo.setuId("4546");//--------
		optionResultService.selectOptionResult(vo);
	}

	/**
	 * 删除
	 */
	@RequestMapping("/deleteOptionResult")
	public void OptionResult() {
		OptionResult vo = new OptionResult();
		vo.setId("1");
		vo.setOiId("dsd222");//-------------------
		vo.setResult("false");
		vo.setuId("4546");//--------
		optionResultService.deleteOptionResult(vo.getId());
	}

}
