package net.bingo.vote.service.optionTemplate.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.bingo.vote.dao.optionTemplate.Template2Dao;
import net.bingo.vote.model.optionTemplate.Template;
import net.bingo.vote.model.optionTemplate.Template2;
import net.bingo.vote.service.optionTemplate.OptionTemplateService;

@Transactional
@Service("OptionTemplate2Service")
public class OptionTemplate2Imlp implements OptionTemplateService {
	
	@Autowired
	private Template2Dao template2Dao;
	/**
	 * 新增OptionTemplate2，
	 * 必须要先新增OptionType
	 */
	@Override
	public void insertOptionTemplate(Template vo) {
		template2Dao.insertTemplate2((Template2) vo);
		
	}

	@Override
	public void deleteOptionTemplate(String id) {
		template2Dao.deleteTemplate2(id);
		
	}

	@Override
	public Template2 selectOptionTemplate(Template vo) {
		
		return template2Dao.selectTemplate2((Template2) vo);
	}

	@Override
	public void updateOptionTemplate(Template vo) {
		template2Dao.updateTemplate2((Template2) vo);
	}

	
}
