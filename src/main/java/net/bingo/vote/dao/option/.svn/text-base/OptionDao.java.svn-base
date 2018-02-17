package net.bingo.vote.dao.option;

import org.apache.ibatis.annotations.Param;

import net.bingo.vote.model.option.Option;

public interface OptionDao {
	/**
	 * 查找Option
	 * 
	 * @param vo
	 * @return
	 */
	public Option selectOption(@Param(value = "vo") Option vo);

	/**
	 * 删除Option
	 * 
	 * @param vo
	 * @return
	 */
	public void deleteOption(@Param(value = "id") String id);

	/**
	 * 新增Option
	 * 
	 * @param vo
	 * @return
	 */
	public void insertOption(@Param(value = "vo") Option vo);

	/**
	 * 修改Option
	 * @param vo
	 * @return
	 */
	public void updateOption(@Param(value = "vo") Option vo);
	/**
	 * 根据p_id查找
	 * @param pId
	 */
	public Option selectOptionBypId(@Param(value = "pId")String pId);

}
