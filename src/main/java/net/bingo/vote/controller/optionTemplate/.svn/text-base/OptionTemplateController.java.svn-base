package net.bingo.vote.controller.optionTemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import net.bingo.vote.model.option.Option;
import net.bingo.vote.model.optionTemplate.Template2;
import net.bingo.vote.service.option.OptionService;
import net.bingo.vote.service.optionTemplate.OptionTemplateService;
import net.bingo.vote.service.project.ProjectService;

@Controller
@RequestMapping("/optionTemplateController")
public class OptionTemplateController {

	@Autowired
	ProjectService projectService;
	@Autowired
	OptionService optionService;
	@Autowired
	@Qualifier("OptionTemplate3Service")
	private OptionTemplateService optionTemplateService3;
	@Autowired
	@Qualifier("OptionTemplate2Service")
	private OptionTemplateService optionTemplateService2;
	@Autowired
	@Qualifier("OptionTemplate1Service")
	private OptionTemplateService optionTemplateService1;

	/**
	 * 新增
	 */
	@RequestMapping("/insertOptionTemplate")
	public void insertProject() {
		
//		Project t=new Project();
//		t.setTitle("test");
//		t.setId("95288");
//		projectService.insertProject(t);
		Option t2 =new Option();
		t2.setId("123456");//-----
		t2.setpId("95288");
		t2.setOtId("pingfen");
		 optionService.insertOption(t2);
		 
		
		Template2 vo2 = new Template2();

		vo2.setId("dsd2223");
		vo2.setOrId("9527777");
		vo2.setOtId("pingfen");//--
		vo2.setoId("123456");//id 要有
		optionTemplateService2.insertOptionTemplate(vo2);

		System.out.println(vo2);
	}

	/**
	 * 修改,根据主键
	 */
	@RequestMapping("/updateOptionTemplate")
	public void updateProject() {
		Template2 vo2 = new Template2();
		vo2.setId("dsd2223");

		vo2.setOrId("78787878");
		vo2.setContent("dsds");
		optionTemplateService2.updateOptionTemplate(vo2);

	}

	/**
	 * 查询
	 */
	@RequestMapping("/selectOptionTemplate")
	public void selectProject() {

		Template2 vo2 = new Template2();
		vo2.setId("dsd2223");
		Template2 vo1 = (Template2) optionTemplateService2.selectOptionTemplate(vo2);
		System.out.println(vo1.getId() + "555555555555555555");
	}

	/**
	 * 删除
	 */
	@RequestMapping("/deleteOptionTemplate")
	public void deleteProject() {

		Template2 vo2 = new Template2();
		vo2.setId("dsd2223");

		optionTemplateService2.deleteOptionTemplate(vo2.getId());

	}
}
