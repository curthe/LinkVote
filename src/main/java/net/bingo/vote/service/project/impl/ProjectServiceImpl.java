package net.bingo.vote.service.project.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.bingo.vote.common.JsonData;
import net.bingo.vote.common.Pagination;
import net.bingo.vote.dao.option.OptionDao;
import net.bingo.vote.dao.optionResult.OptionResultDao;
import net.bingo.vote.dao.optionTemplate.Template3Dao;
import net.bingo.vote.dao.optionType.OptionTypeDao;
import net.bingo.vote.dao.project.ProjectDao;
import net.bingo.vote.model.option.Option;
import net.bingo.vote.model.optionResult.OptionResult;
import net.bingo.vote.model.optionTemplate.Template3;
import net.bingo.vote.model.project.Project;
import net.bingo.vote.model.userProject.UserProject;
import net.bingo.vote.service.optionTemplate.OptionTemplateService;
import net.bingo.vote.service.optionTemplate.impl.OptionTemplate3Imlp;
import net.bingo.vote.service.project.ProjectService;
import net.bingo.vote.service.userProject.UserProjectService;

/**
 * 
 * @author wshzh 单个用户增删查改
 */
@Transactional
@Service("projectService")
public class ProjectServiceImpl implements ProjectService {

	@Autowired
	private ProjectDao projectDao;
	@Autowired
	OptionDao optionDao;
	@Autowired
	OptionTypeDao optionTypeDao;
	@Autowired
	OptionResultDao optionResultDao;
	@Autowired
	UserProjectService userProjectService;
	
	@Autowired
	Template3Dao template3Dao;

	public Pagination findList(String Data, int rows, int currentPage) {

		return projectDao.findList(Data, rows, currentPage);
	}

	@Override
	public Project selectProject(Project vo) {
		return projectDao.selectProject(vo);
	}

	@Override
	public void insertProject(Project vo) {
		projectDao.insertProject(vo);
	}

	@Override
	public void deleteProject(String id) {
		projectDao.deleteProject(id);
	}

	@Override
	public void updateProject(Project vo) {
		projectDao.updateProject(vo);
	}

	@Override
	public JsonData createVote(String data) {

		return null;
	}

	@Override
	public List selectStartProjectById(Pagination pagination, String id) {
		int li=pagination.getPageNo()-1;
		int lo=pagination.getPageSize();
		List<Map> list = projectDao.selectStartProjectById(li,lo, id);
		return list;
	}
	@Override
	public List selectEndProjectById(Pagination pagination, String id) {
		int li=pagination.getPageNo()-1;
		int lo=pagination.getPageSize();
		List<Map> list = projectDao.selectEndProjectById(li,lo, id);

		return list;
	}
	@Override
	public List enterVoting(String pId,String userId) {
		Option option = optionDao.selectOptionBypId(pId);
		// optionId、optionTypeId决定该表
		String otId = option.getOtId();
		String oId = option.getId();
		String tableName = null;
		switch (otId) {
		case "pingfen":
			// System.out.println("1");
			tableName = "v_option_introduction_one";
			break;
		case "didian":
			// System.out.println("2");
			tableName = "v_option_introduction_one";
			break;
		case "jushou":
			System.out.println("3");
			tableName = "v_option_introduction_one";
			break;
		case "jiangxiang":
			// System.out.println("4 奖项类");
			tableName = "v_option_introduction_three";
			break;
		case "danxuan":
			// System.out.println("5");
			tableName = "v_option_introduction_one";
			break;
		case "duoxuan":
			// System.out.println("6");
			tableName = "v_option_introduction_one";
			break;
		default:
			// System.out.println("未定义");
			tableName = "v_option_introduction_one";
			break;
		}

		List<Map> list = projectDao.enterVoting(tableName, otId, oId,pId);
		return list;
	}
	
	
	/**
	 * 4 奖项类
	 */
	@Override
	public void post4Voting(String pId, String uId, String result){
			
			OptionResult optionResult=new OptionResult();
			String orId=UUID.randomUUID().toString();
			optionResult.setId(orId);
			optionResult.setResult(result);
			optionResult.setuId(uId);
			//result 就是 oiId
			optionResult.setOiId(result);
			optionResultDao.insertOptionResult(optionResult);
			
			UserProject up=new UserProject();
			//未进行过投票的都没维护过这个关系
			String upId=UUID.randomUUID().toString();
			up.setId(upId);
			up.setuId(uId);
			up.setpId(pId);
			up.setParticipation("1");
			userProjectService.insertUserProject(up);
			//插入这个表维护userProject_optionResult表的关系
			up.setuId(uId);
			up.setpId(pId);
			UserProject upR=userProjectService.selectUserProject(up);
			//传入upId，ResultId
			optionResultDao.insertUserProjrct_OptionResult(upR.getId(),orId);
		}
	/**
	 * 4 奖项类，已经投票，编辑
	 */
	@Override
	public void edit4Voting(String pId, String uId, String result){
		
			OptionResult optionResult=new OptionResult();

			optionResult.setResult(result);
			optionResult.setuId(uId);
			//result 就是 oiId
			optionResult.setOiId(result);
			
			optionResultDao.updateOptionResult(optionResult);
		}

	@Override
	public List view4Voting(String pId, String uId) {
		OptionResult optionResult=new OptionResult();
		optionResult.setuId(uId);
		UserProject up=new UserProject();
		up.setuId(uId);
		up.setpId(pId);
		//先获取当前用户对应的project的userProjectId
		UserProject upR=userProjectService.selectUserProject(up);
		String upId=upR.getId();
		//通过userproject_result的ID查找
		List<Map> list=optionResultDao.selectOptionResultByuprId(upId);
		//奖项类的结果只有一个
		String RId=(String) list.get(0).get("resultID");
		optionResult.setId(RId);
		
		OptionResult resultList=optionResultDao.selectOptionResult(optionResult);
		String r=resultList.getResult();
		
		List<Map> baseList=this.enterVoting(pId,uId);
		for(Map li:baseList){
			String result=(String) li.get("voi_id");
			if(r.equals(result)){
				li.put("result", r);
			}
			else{
				li.put("result", "0");
			}
		}
		System.out.println(baseList);
		return baseList;
	}

	@Override
	public List<Object> getVotedResult(String pId) {
		List<Map> list=null;
		list=projectDao.getVotedResult(pId);
		List<Object> listReturn=new ArrayList<Object>();
		int i=list.size();
		//返回多少个结果
		List<Map>list2=projectDao.getVotedResultNum(pId);
		List<Object> listReturn2=new ArrayList<Object>();
		//多少个候选人
		int ii=list2.size();
		for(int j=0;j<ii;j++){
			Map map =null;
			map=(Map) list2.get(j);
			List l=new ArrayList();
			//结果
			String r=(String) map.get("result");
			
			for(int kk=0;kk<i;kk++){
				//1个结果
				Map kkr=list.get(kk);
				
				if(r.equals(kkr.get("result"))){
					//结果和结果列相同
					Map m=list.get(j);
					String re=(String) m.get("result");
					//转化结果
					Template3 tp3=new Template3();
					tp3.setId(re);
					Template3 tp3R=template3Dao.selectTemplate3(tp3);
					String rr=tp3R.getTitle();
					Map mm=new HashMap();
					mm.put("result", rr);
					mm.put("uId", m.get("u_id"));
					l.add(mm);
					//将转化的结果放回去
				}
			}
			
			listReturn.add(l);
			
		}
		return listReturn;
	}
}
