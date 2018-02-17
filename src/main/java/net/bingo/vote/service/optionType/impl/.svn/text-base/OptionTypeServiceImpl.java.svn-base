package net.bingo.vote.service.optionType.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.bingo.vote.dao.optionType.OptionTypeDao;
import net.bingo.vote.model.optionType.OptionType;
import net.bingo.vote.service.optionType.OptionTypeService;
@Transactional
@Service("OptionResultService")
public class OptionTypeServiceImpl implements OptionTypeService {

	@Autowired
	private OptionTypeDao optionTypeDao;

	@Override
	public void insertOptionType(OptionType vo) {
		optionTypeDao.insertOptionType(vo);

	}

	@Override
	public void deleteOptionType(String id) {
		optionTypeDao.deleteOptionType(id);

	}

	@Override
	public OptionType selectOptionType(OptionType vo) {
		return optionTypeDao.selectOptionType(vo);
	}

	@Override
	public void updateOptionType(OptionType vo) {
		optionTypeDao.updateOptionType(vo);

	}

}
