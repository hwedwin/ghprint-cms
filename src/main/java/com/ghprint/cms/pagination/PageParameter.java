package com.ghprint.cms.pagination;

/**
* @ClassName: Page
* @Description: 分页参数类
* @author 庞超
* @date 2013-11-15 上午13:57:33
* 
*/
public class PageParameter {
	/**
	* @Fields DEFAULT_PAGE_SIZE : 默认显示当前页的记录数目
	* @Fields pageSize : 自定义当前页的记录数目
	* @Fields currentPage : 当前页
	* @Fields totalPage : 总页数
	* @Fields totalPage : 总记录数
	*/
    public static final int DEFAULT_PAGE_SIZE = 10;
    private int pageSize;
    private int currentPage;
    private int totalPage;
    private int totalCount;

    public PageParameter() {
        this.currentPage = 1;
        this.pageSize = DEFAULT_PAGE_SIZE;
    }
    public PageParameter(int currentPage, int pageSize) {
        this.currentPage = currentPage;
        this.pageSize = pageSize;
    }
    public int getCurrentPage() {
        return currentPage;
    }
    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }
    public int getPageSize() {
        return pageSize;
    }
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
	/** 
	* @Title: page信息
	* @Description: 获取上一页
	* @return map
	* @throws 
	*/ 	
    public int getPrePage() {
        return this.currentPage>1?this.currentPage-1:this.currentPage;
    }
	/** 
	* @Title: page信息
	* @Description: 获取下一页
	* @return map
	* @throws 
	*/ 	
    public int getNextPage() {
        return this.currentPage<this.totalPage?this.currentPage+1:this.currentPage;
    }
    public int getTotalPage() {
        return totalPage;
    }
    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }
    public int getTotalCount() {
        return totalCount;
    }
    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }
}
