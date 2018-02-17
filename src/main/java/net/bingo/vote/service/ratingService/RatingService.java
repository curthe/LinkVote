package net.bingo.vote.service.ratingService;


public interface RatingService {
	 
	
	/**
	 * 评分类：
	 * 
	 * 创建用户表v_user
	 * 创建工程表v_project。工程id随机生成，工程标题、标书对应为课名、描述
	 * 创建组群表(是否是群组投票，否则默认为公开投票)，并设定为群主，p_id为工程表的id
	 * 														-- 已初始化，不要管：创建选项表v_option（选项形式id：pingfen）
	 * 创建项目选项表v_option：绑定项目id 和 选项形式id
	 * 
	 * 创建该课程的教师的信息：绑定项目选项表id、选项形式表id:
	 * 			创建模板表v_option_introduction_three（选项形式id：pingfen）：教师名、简介、图片
	 * 
	 * 创建该课程的选项（上课氛围等）的信息：（每新增一个选项创建一次）
	 * 			创建模板表v_option_introduction_two（选项形式id：pingfen）
	 * 			创建结果详情表v_option_introduction_two v_option_result
	 * 
	 * 
	 * 
	 */
	/**
	 * 评分类：
	 * 投票：
	 * 创建用户表v_user-->根据用户表v_user_project，查询得到用户工程表vup_id
	 * 查询v_group群组表，看看你在这张表内是什么角色，是投票者角色--->
	 * 根据工程表vup_id查询v_option选项表，看这个工程的选项形式id为pingfen,查询v_option_type表，查出对应的形式为1
	 * 根据项目选项表v_option的id查询v_option_introduction_three表的信息:(返回的是一组数据）
	 * 											:课程信息
	 * 											v_option_introduction_three表的信息：教师名、简介、图片
	 * 
	 * 根据项目选项表v_option的id查询v_option_introduction_two表的信息：(返回的是多组v_option_introduction_two表的数据)
	 * ：评分项+结果 	-->
	 * 			v_option_introduction_two表:课程氛围选项+结果id
	 *  		结果id查询v_option_result表的信息 查询到选项结果
	 *  
	 *  
	 */
	
	/**
	 * 
	 * 奖项类：
	 * 
	 * 创建用户表v_user
	 * 创建工程表v_project。工程id随机生成，工程标题、描述对应为奖项名、描述
	 * 创建组群表(是否是群组投票，否则默认为公开投票)，并设定为群主，p_id为工程表的id
	 * 														-- 已初始化，不要管：创建选项表v_option（选项形式id：jiangxiang）
	 * 创建项目选项表v_option：绑定项目id 和 选项形式id：jiangxiang
	 * 
	 * 创建该奖项的候选人的信息：绑定项目选项表id、选项形式表id:（每新增一个候选人创建一次）
	 * 			创建模板表v_option_introduction_three（选项形式id：jiangxiang）：候选人名、简介、图片 		
	 * 		        创建结果详情表 v_option_result  
	 * 
	 * 
	 */
	
	/**
	 * 奖项类：
	 * 投票：
	 * 创建用户表v_user-->根据用户表v_user_project，查询得到用户工程表vup_id
	 * 查询v_group群组表，看看你在这张表内是什么角色，是投票者角色--->
	 * 根据工程表vup_id查询v_option选项表，看这个工程的选项形式id：jiangxiang,查询v_option_type表，查出对应的形式为4
	 * 
	 * 根据项目选项表v_option的id查询v_option_introduction_three表的信息:(返回的是多组v_option_introduction_three表的数据，因为有多个候选人）
	 * 											:候选人信息
	 * 											v_option_introduction_three表的信息：候选人名、简介、图片、你选的结果id
	 * 											结果id查询v_option_result表的信息 查询到选项结果--》你选了他没有
	 * 
	 *  
	 *  
	 */
	
	
	
	/**
	 * 协会地点类：
	 * 
	 * 创建用户表v_user
	 * 创建工程表v_project。工程id随机生成，工程标题、标书对应为课名、描述
	 * 创建组群表(是否是群组投票，否则默认为公开投票)，并设定为群主，p_id为工程表的id
	 * 														-- 已初始化，不要管：创建选项表v_option（选项形式id：pingfen）
	 * 创建项目选项表v_option：绑定项目id 和 选项形式id
	 * 
	 * 创建该课程的教师的信息：绑定项目选项表id、选项形式表id:
	 * 			创建模板表v_option_introduction_three（选项形式id：pingfen）：教师名、简介、图片
	 * 
	 * 创建该课程的选项（上课氛围等）的信息：（每新增一个选项创建一次）
	 * 			创建模板表v_option_introduction_two（选项形式id：pingfen）
	 * 			创建结果详情表v_option_introduction_two v_option_result
	 * 
	 * 
	 * 
	 */
	/**
	 * 协会地点类：
	 * 投票：
	 * 创建用户表v_user-->根据用户表v_user_project，查询得到用户工程表vup_id
	 * 查询v_group群组表，看看你在这张表内是什么角色，是投票者角色--->
	 * 根据工程表vup_id查询v_option选项表，看这个工程的选项形式id为pingfen,查询v_option_type表，查出对应的形式为1
	 * 根据项目选项表v_option的id查询v_option_introduction_three表的信息:(返回的是一组数据）
	 * 											:课程信息
	 * 											v_option_introduction_three表的信息：教师名、简介、图片
	 * 
	 * 根据项目选项表v_option的id查询v_option_introduction_two表的信息：(返回的是多组v_option_introduction_two表的数据)
	 * ：评分项+结果 	-->
	 * 			v_option_introduction_two表:课程氛围选项+结果id
	 *  		结果id查询v_option_result表的信息 查询到选项结果
	 *  
	 *  
	 */
}
