package net.bingo.vote.dao.optionType;

import org.apache.ibatis.annotations.Param;

import net.bingo.vote.model.optionType.OptionType;

public interface OptionTypeDao {

	/**
	 * 查找OptionType
	 * 
	 * @param vo
	 * @return
	 */
	public OptionType selectOptionType(@Param(value = "vo") OptionType vo);

	/**
	 * 删除OptionType
	 * 
	 * @param vo
	 * @return
	 */
	public void deleteOptionType(@Param(value = "id") String id);

	/**
	 * 新增OptionType
	 * 
	 * @param vo
	 * @return
	 */
	public void insertOptionType(@Param(value = "vo") OptionType vo);

	/**
	 * 修改OptionType
	 * 
	 * @param vo
	 * @return
	 */
	public void updateOptionType(@Param(value = "vo") OptionType vo);
}
