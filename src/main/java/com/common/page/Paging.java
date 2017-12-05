/**
 *  www.yupaopao.cn 2014-2017©All Rights Reserved
 */
package com.common.page;

import com.utils.Tools;

import java.io.Serializable;

/**
 * <p>
 * 分页
 * </p>
 *
 * @author xiaoyu.wang
 * @date 2017年7月27日 下午3:12:08
 * @version
 */
public class Paging implements Serializable {

	private static final long serialVersionUID = 1564526306472194613L;

	public static final int DEFAULT_PAGE = 0;
	public static final int DEFAULT_PAGE_SIZE = 20;
	public static final long DEFAUT_START = 0L;

	private int page = DEFAULT_PAGE;

	private int pageSize = DEFAULT_PAGE_SIZE;

	public Paging(int page, int pageSize) {
		setPage(page);
		setPageSize(pageSize);
	}

	public final int getPage() {
		return page;
	}

	public final int getPageSize() {
		return pageSize;
	}

	public final int getOffset() {
		return page * pageSize;
	}

	public void setP(String p) {
		setPage(Tools.parseInt(p, DEFAULT_PAGE));
	}

	public void setS(String s) {
		setPageSize(Tools.parseInt(s, DEFAULT_PAGE_SIZE));
	}

	public void setPage(int page) {
		if (page > 0) {
			this.page = page;
		}
	}

	public void setPageSize(int pageSize) {
		if (pageSize > 0) {
			this.pageSize = pageSize;
		}
	}

	@Override
	public String toString() {
		return "Paging: page = " + page + ", pageSize = " + pageSize;
	}
}
