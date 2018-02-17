package net.bingo.vote.service.optionTemplate;

import net.bingo.vote.model.optionTemplate.Template;

public interface OptionTemplateService {
	/**
	 * 增
	 * 
	 * @param vo
	 * @return
	 */
	public void insertOptionTemplate(Template vo);

	/**
	 * 删
	 * 
	 * @param vo
	 * @return
	 */
	public void deleteOptionTemplate(String id);

	/**
	 * 查
	 * 
	 * @param vo
	 * @return
	 */
	public Template selectOptionTemplate(Template vo);

	/**
	 * 改
	 * 
	 * @param vo
	 * @return
	 */
	public void updateOptionTemplate(Template vo);
}
