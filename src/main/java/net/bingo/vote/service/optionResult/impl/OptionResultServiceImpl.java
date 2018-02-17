package net.bingo.vote.service.optionResult.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.bingo.vote.dao.optionResult.OptionResultDao;
import net.bingo.vote.model.optionResult.OptionResult;
import net.bingo.vote.service.optionResult.OptionResultService;
@Transactional
@Service("OptionTypeService")
public class OptionResultServiceImpl implements OptionResultService {

@Autowired
private OptionResultDao optionResultDao;

@Override
public void insertOptionResult(OptionResult vo) {
	optionResultDao.insertOptionResult(vo);
}

@Override
public void deleteOptionResult(String id) {
	optionResultDao.deleteOptionResult(id);
}

@Override
public OptionResult selectOptionResult(OptionResult vo) {
	
	return optionResultDao.selectOptionResult(vo);
}

@Override
public void updateOptionResult(OptionResult vo) {
	optionResultDao.updateOptionResult(vo);
}

}
