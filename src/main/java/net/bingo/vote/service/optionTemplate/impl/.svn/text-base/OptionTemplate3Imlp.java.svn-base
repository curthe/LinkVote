package net.bingo.vote.service.optionTemplate.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.bingo.vote.dao.optionTemplate.Template3Dao;
import net.bingo.vote.model.optionTemplate.Template;
import net.bingo.vote.model.optionTemplate.Template3;
import net.bingo.vote.service.optionTemplate.OptionTemplateService;

@Transactional
@Service("OptionTemplate3Service")
public class OptionTemplate3Imlp implements OptionTemplateService {
	@Autowired
	private Template3Dao template3Dao;

	/**
	 * 新增OptionTemplate3， 必须要先新增OptionType
	 */
	@Override
	public void insertOptionTemplate(Template vo) {
		template3Dao.insertTemplate3((Template3) vo);

	}

	@Override
	public void deleteOptionTemplate(String id) {
		template3Dao.deleteTemplate3(id);

	}

	@Override
	public Template3 selectOptionTemplate(Template vo) {

		return template3Dao.selectTemplate3((Template3) vo);
	}

	@Override
	public void updateOptionTemplate(Template vo) {
		template3Dao.updateTemplate3((Template3) vo);
	}

}
