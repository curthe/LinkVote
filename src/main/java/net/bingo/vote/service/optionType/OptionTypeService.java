package net.bingo.vote.service.optionType;

import net.bingo.vote.model.optionType.OptionType;

public interface OptionTypeService {
	/**
	 * 增
	 * 
	 * @param vo
	 * @return
	 */
	public void insertOptionType(OptionType vo);

	/**
	 * 删
	 * 
	 * @param vo
	 * @return
	 */
	public void deleteOptionType(String id);

	/**
	 * 查
	 * 
	 * @param vo
	 * @return
	 */
	public OptionType selectOptionType(OptionType vo);

	/**
	 * 改
	 * 
	 * @param vo
	 * @return
	 */
	public void updateOptionType(OptionType vo);
}
