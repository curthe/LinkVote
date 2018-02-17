package net.bingo.vote.dao.optionTemplate;

import org.apache.ibatis.annotations.Param;

import net.bingo.vote.common.Pagination;
import net.bingo.vote.model.optionTemplate.Template3;

public interface Template3Dao {
	public Pagination findList(String Data, int rows, int currentPage);

	/**
	 * 查找Template3
	 * 
	 * @param vo
	 * @return
	 */
	public Template3 selectTemplate3(@Param(value = "vo") Template3 vo);

	/**
	 * 删除Template3
	 * 
	 * @param vo
	 * @return
	 */
	public void deleteTemplate3(@Param(value = "id") String id);

	/**
	 * 新增Template3
	 * 
	 * @param vo
	 * @return
	 */
	public void insertTemplate3(@Param(value = "vo") Template3 vo);

	/**
	 * 修改Template3
	 * 
	 * @param vo
	 * @return
	 */
	public void updateTemplate3(@Param(value = "vo") Template3 vo);
}
