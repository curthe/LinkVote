package net.bingo.vote.service.project;

import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;

import net.bingo.vote.common.JsonData;
import net.bingo.vote.common.Pagination;
import net.bingo.vote.model.project.Project;

public interface ProjectService {
	
	public Pagination findList(String Data, int rows, int currentPage);

	/**
	 * 增
	 * 
	 * @param vo
	 * @return
	 */
	public void insertProject(Project vo);

	/**
	 * 删
	 * 
	 * @param vo
	 * @return
	 */
	public void deleteProject(String id);

	/**
	 * 查
	 * 
	 * @param vo
	 * @return
	 */
	public Project selectProject(Project vo);

	/**
	 * 改
	 * 
	 * @param vo
	 * @return
	 */
	public void updateProject(Project vo);

	/**
	 * 新增
	 * @param data
	 * @return
	 */
	public JsonData createVote(String data);

	public List<Map> selectStartProjectById(Pagination pagination, String id);
	
	public List<Map> selectEndProjectById(Pagination pagination, String id);

	public List<Map> enterVoting(String pId,String userId) ;

	public void post4Voting(String pId, String userId, String result);

	public void edit4Voting(String pId, String uId, String result);

	public List view4Voting(String pId, String uId);

	public List<Object> getVotedResult(String pId);


}
