package net.bingo.vote.dao.optionTemplate;

import org.apache.ibatis.annotations.Param;

import net.bingo.vote.common.Pagination;
import net.bingo.vote.model.optionTemplate.Template2;

public interface Template2Dao {
	public Pagination findList(String Data, int rows, int currentPage);

	/**
	 * 查找Template3
	 * 
	 * @param vo
	 * @return
	 */
	public Template2 selectTemplate2(@Param(value = "vo") Template2 vo);

	/**
	 * 删除Template3
	 * 
	 * @param vo
	 * @return
	 */
	public void deleteTemplate2(@Param(value = "id") String id);

	/**
	 * 新增Template3
	 * 
	 * @param vo
	 * @return
	 */
	public void insertTemplate2(@Param(value = "vo") Template2 vo);

	/**
	 * 修改Template3
	 * 
	 * @param vo
	 * @return
	 */
	public void updateTemplate2(@Param(value = "vo") Template2 vo);
}
