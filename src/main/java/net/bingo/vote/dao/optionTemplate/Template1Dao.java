package net.bingo.vote.dao.optionTemplate;

import org.apache.ibatis.annotations.Param;

import net.bingo.vote.common.Pagination;
import net.bingo.vote.model.optionTemplate.Template1;

public interface Template1Dao {
	public Pagination findList(String Data, int rows, int currentPage);

	/**
	 * 查找Template3
	 * 
	 * @param vo
	 * @return
	 */
	public Template1 selectTemplate1(@Param(value = "vo") Template1 vo);

	/**
	 * 删除Template3
	 * 
	 * @param vo
	 * @return
	 */
	public void deleteTemplate1(@Param(value = "id") String id);

	/**
	 * 新增Template3
	 * 
	 * @param vo
	 * @return
	 */
	public void insertTemplate1(@Param(value = "vo") Template1 vo);

	/**
	 * 修改Template3
	 * 
	 * @param vo
	 * @return
	 */
	public void updateTemplate1(@Param(value = "vo") Template1 vo);
}
