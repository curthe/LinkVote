package net.bingo.vote.dao.project;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import net.bingo.vote.common.Pagination;
import net.bingo.vote.model.project.Project;

public interface ProjectDao {
	
	public Pagination findList(String Data, int rows, int currentPage);

	/**
	 * 查找Project
	 * 
	 * @param vo
	 * @return
	 */
	public Project selectProject(@Param(value = "vo") Project vo);

	/**
	 * 删除Project
	 * 
	 * @param vo
	 * @return
	 */
	public void deleteProject(@Param(value = "id") String id);

	/**
	 * 新增Project
	 * 
	 * @param vo
	 * @return
	 */
	public void insertProject(@Param(value = "vo") Project vo);

	/**
	 * 修改Project
	 * 
	 * @param vo
	 * @return
	 */
	public void updateProject(@Param(value = "vo") Project vo);

	public List<Map> selectStartProjectById(@Param(value = "li") int li,@Param(value = "lo") int lo,@Param(value = "id")String id);

	public List<Map> selectEndProjectById(@Param(value = "li") int li,@Param(value = "lo") int lo,@Param(value = "id")String id);


	public List<Map> enterVoting(@Param(value = "tName")String tableName,@Param(value = "otId")String otId, @Param(value = "oId")String oId,@Param(value = "pId")String pId);

	public List<Map> getVotedResult(@Param(value = "pId")String pId);
	
	public List<Map> getVotedResultNum(@Param(value = "pId")String pId);

}
