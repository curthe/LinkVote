package net.bingo.vote.dao.optionResult;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import net.bingo.vote.model.optionResult.OptionResult;



public interface OptionResultDao {
	/**
	 * 查找Option
	 * 
	 * @param vo
	 * @return
	 */
	public OptionResult selectOptionResult(@Param(value = "vo") OptionResult vo);

	/**
	 * 删除Option
	 * 
	 * @param vo
	 * @return
	 */
	public void deleteOptionResult(@Param(value = "id") String id);

	/**
	 * 新增Option
	 * 
	 * @param vo
	 * @return
	 */
	public void insertOptionResult(@Param(value = "vo") OptionResult vo);

	/**
	 * 修改Option
	 * 
	 * @param vo
	 * @return
	 */
	public void updateOptionResult(@Param(value = "vo") OptionResult vo);

	public void insertUserProjrct_OptionResult(@Param(value = "userProjecID")String userProjecID, @Param(value = "resultID")String resultID);
	
	//得到userProject——结果集合
	public List<Map> selectOptionResultByuprId(@Param(value = "upId")String upId);

}
