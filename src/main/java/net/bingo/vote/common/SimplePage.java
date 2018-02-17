package net.bingo.vote.common;

/**
 * 数据分页
 * 
 * @author wshzh
 *
 */
public class SimplePage implements Paginable {
	public static final int DEFAULT_COUNT = 10;
	/**
	 * 总记录数
	 */
	protected int totalCount = 0;
	/**
	 * 每页记录数
	 */
	protected int pageSize = 10;
	/**
	 * 当前页
	 */
	protected int pageNo = 1;

	/**
	 * 默认构造器
	 */
	public SimplePage() {

	}

	/**
	 * 构造器
	 * 
	 * @param pageNo
	 *            页码
	 * @param pageSize
	 *            每页几条数据
	 * @param totalCount
	 *            总共几条数据
	 */
	public SimplePage(int pageNo, int pageSize, int totalCount) {
		setTotalCount(totalCount); // 若数据总数小于0，设置为0
		setPageSize(pageSize); // 若每页数据数小于1，设置为DEFAULT_COUNT
		setPageNo(pageNo); // 若当前页码小于1，则设 为1
		adjustPageNo(); // 调整页码，使不超过最大页数
	}

	private void setTotalCount(int totalCount) {
		if (totalCount < 0) {
			this.totalCount = 0;
		} else {
			this.totalCount = totalCount;
		}
	}

	public void setPageSize(int pageSize) {
		if (pageSize < 1) {
			this.pageSize = DEFAULT_COUNT;
		} else {
			this.pageSize = pageSize;
		}
	}

	public void setPageNo(int pageNo) {
		if (pageNo < 1) {
			this.pageNo = 1;
		} else {
			this.pageNo = pageNo;
		}
	}

	public void adjustPageNo() {
		if (pageNo == 1) {
			return;
		}
		int tp = getTotalPage();
		if (pageNo > tp) {
			pageNo = tp;
		}
	}

	/**
	 * 总共总数据数目
	 */
	@Override
	public int getTotalCount() {
		// TODO Auto-generated method stub
		return totalCount;
	}

	/**
	 * 获得总共几页数据
	 */
	@Override
	public int getTotalPage() {
		int totalPage = totalCount / pageSize;
		if (totalPage == 0 || totalCount % pageSize != 0) {
			totalPage++;
		}
		return totalPage;
	}

	/**
	 * 获得每页显示几条数据
	 */
	@Override
	public int getPageSize() {
		return pageSize;
	}

	/**
	 * 获得当前页码
	 */
	@Override
	public int getPageNo() {
		return pageNo;
	}

	@Override
	public boolean isFirstPage() {
		return pageNo <= 1;
	}

	@Override
	public boolean isLastPage() {
		return pageNo >= getTotalPage();
	}

	@Override
	public int getNextPage() {
		if (isLastPage()) {
			return pageNo;
		} else {
			return pageNo + 1;
		}
	}

	@Override
	public int getPrePage() {
		if (isFirstPage()) {
			return pageNo;
		} else {
			return pageNo - 1;
		}
	}

}
