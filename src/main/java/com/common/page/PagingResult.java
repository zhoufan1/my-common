/**
 *  www.yupaopao.cn 2014-2017©All Rights Reserved
 */
package com.common.page;

import java.util.List;

/**
 * <p>
 * 分页结果
 * </p>
 *
 * @author xiaoyu.wang
 * @date 2017年7月27日 下午3:27:28
 * @version
 */
public class PagingResult<R> {
	private int count;
	private int current;
	private int pageSize;
	private List<R> results;

	public PagingResult(Paging paging) {
		this.current = paging.getPage();
		this.pageSize = paging.getPageSize();
	}

	public PagingResult(Paging paging, Number count) {
		this.current = paging.getPage();
		this.pageSize = paging.getPageSize();
		setCount(count);
	}

	public int getCount() {
		return count;
	}

	public void setCount(Number count) {
		setCount(count == null ? 0 : count.intValue());
	}

	public void setCount(int count) {
		this.count = count;
	}

	public List<R> getResults() {
		return results;
	}

	public void setResults(List<R> results) {
		this.results = results;
	}

	public int getCurrent() {
		return current;
	}

	public int getPageSize() {
		return pageSize;
	}

	public int getTotalPage() {
		return (getCount() + getPageSize() - 1) / getPageSize();
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PagingResult [count=");
		builder.append(count);
		builder.append(", current=");
		builder.append(current);
		builder.append(", pageSize=");
		builder.append(pageSize);
		builder.append(", totalPage()=");
		builder.append(getTotalPage());
		builder.append(", results=");
		builder.append(results);
		builder.append("]");
		return builder.toString();
	}
}
