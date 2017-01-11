package com.ghprint.cms.pagination;

import java.util.List;

/**
 * @ClassName: Page
 * @Description: 分页类
 * @author 庞超
 * @date 2013-11-15 上午13:57:33
 * 
 */
public class Page<T> {
	/**
	 * @Fields page : 该字段包含分页的参数信息
	 * @Fields entity : 该字段用于保存查询条件
	 * @Fields showRecords : 查询返回的结果集
	 */
	private PageParameter page;
	private T entity;
	private List<T> showRecords;
	private long totoalCount;

	
	public long getTotoalCount() {
		return totoalCount;
	}

	public void setTotoalCount(long totoalCount) {
		this.totoalCount = totoalCount;
	}

	/**
	 * <p>
	 * Title:分页
	 * </p>
	 * <p>
	 * Description:对所有数据进行分页
	 * </p>
	 */
	public Page(PageParameter page) {
		this.page = page;
	}

	/**
	 * <p>
	 * Title: 分页
	 * </p>
	 * <p>
	 * Description: 根据参数查询出结果后分页
	 * </p>
	 */
	public Page(T entity, PageParameter page) {
		this.page = page;
		this.entity = entity;
	}

	public PageParameter getPage() {
		return page;
	}

	public void setPage(PageParameter page) {
		this.page = page;
	}

	public T getEntity() {
		return entity;
	}

	public void setEntity(T entity) {
		this.entity = entity;
	}

	public List<T> getShowRecords() {
		return showRecords;
	}

	public void setShowRecords(List<T> showRecords) {
		this.showRecords = showRecords;
	}
}