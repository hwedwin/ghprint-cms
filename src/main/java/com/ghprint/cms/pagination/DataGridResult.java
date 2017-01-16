package com.ghprint.cms.pagination;

import java.util.List;

/**
 * Created by lenovo on 2017/1/10.
 */
public class DataGridResult {

    private int everyPage; // 每页显示数量
    private long totalCount; // 总记录数
    private long totalPage; // 总页数
    private int currentPage; // 当前页
    private int beginIndex = 1; // 起始页
    private boolean hasPrePage; // 是否有上一页
    private boolean hasNextPage; // 是否有下一页
    private List<?> rows;//list
    private  String message;
    private boolean success;

    public DataGridResult() {

    }

    public DataGridResult(int everyPage, int totalCount, int totalPage, int currentPage, int beginIndex, boolean hasPrePage, boolean hasNextPage) {
        this.everyPage = everyPage;
        this.totalCount = totalCount;
        this.totalPage = totalPage;
        this.currentPage = currentPage;
        this.beginIndex = beginIndex;
        this.hasPrePage = hasPrePage;
        this.hasNextPage = hasNextPage;
    }

    public int getEveryPage() {
        return everyPage;
    }

    public void setEveryPage(int everyPage) {
        this.everyPage = everyPage;
    }

    public long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(long totalCount) {
        this.totalCount = totalCount;
    }

    public long getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(long totalPage) {
        this.totalPage = totalPage;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getBeginIndex() {
        return beginIndex;
    }

    public void setBeginIndex(int beginIndex) {
        this.beginIndex = beginIndex;
    }

    public boolean isHasPrePage() {
        return hasPrePage;
    }

    public void setHasPrePage(boolean hasPrePage) {
        this.hasPrePage = hasPrePage;
    }

    public boolean isHasNextPage() {
        return hasNextPage;
    }

    public void setHasNextPage(boolean hasNextPage) {
        this.hasNextPage = hasNextPage;
    }

    public List<?> getRows() {
        return rows;
    }

    public void setRows(List<?> rows) {
        this.rows = rows;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    @Override
    public String toString() {
        return "DataGridResult{" +
                "everyPage=" + everyPage +
                ", totalCount=" + totalCount +
                ", totalPage=" + totalPage +
                ", currentPage=" + currentPage +
                ", beginIndex=" + beginIndex +
                ", hasPrePage=" + hasPrePage +
                ", hasNextPage=" + hasNextPage +
                ", rows=" + rows +
                ", message='" + message + '\'' +
                ", success=" + success +
                '}';
    }
}
