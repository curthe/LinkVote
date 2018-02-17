package net.bingo.vote.service.option.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.bingo.vote.dao.option.OptionDao;
import net.bingo.vote.model.option.Option;
import net.bingo.vote.service.option.OptionService;
@Transactional
@Service("OptionService")
public class OptionServiceImpl implements OptionService {

	@Autowired
	private OptionDao optionDao;

	@Override
	public void insertOption(Option vo) {
		optionDao.insertOption(vo);
	}

	@Override
	public void deleteOption(String id) {
		optionDao.deleteOption(id);
	}

	@Override
	public Option selectOption(Option vo) {
		
		return optionDao.selectOption(vo);
	}

	@Override
	public void updateOption(Option vo) {
		optionDao.updateOption(vo);
	}

}
