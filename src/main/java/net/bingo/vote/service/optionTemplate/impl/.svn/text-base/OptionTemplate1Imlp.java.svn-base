package net.bingo.vote.service.optionTemplate.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.bingo.vote.dao.optionTemplate.Template1Dao;
import net.bingo.vote.model.optionTemplate.Template;
import net.bingo.vote.model.optionTemplate.Template1;
import net.bingo.vote.service.optionTemplate.OptionTemplateService;

@Transactional
@Service("OptionTemplate1Service")
public class OptionTemplate1Imlp implements OptionTemplateService {
	@Autowired
	private Template1Dao template1Dao;
	/**
	 * 新增OptionTemplate1，
	 * 必须要先新增OptionType
	 */
	@Override
	public void insertOptionTemplate(Template vo) {
		template1Dao.insertTemplate1((Template1) vo);
		
	}

	@Override
	public void deleteOptionTemplate(String id) {
		template1Dao.deleteTemplate1(id);
		
	}

	@Override
	public Template1 selectOptionTemplate(Template vo) {
		
		return template1Dao.selectTemplate1((Template1) vo);
	}

	@Override
	public void updateOptionTemplate(Template vo) {
		template1Dao.updateTemplate1((Template1) vo);
	}

}
