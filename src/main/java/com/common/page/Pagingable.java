/**
 *  www.yupaopao.cn 2014-2017©All Rights Reserved
 */
package com.common.page;

import java.util.List;

import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 分页
 * </p>
 *
 * @author xiaoyu.wang
 * @date 2017年7月27日 下午3:20:29
 * @version
 */
public interface Pagingable<E, R> {

	int count(E entity);

	List<R> page(@Param("entity") E entity, @Param("paging") Paging paging);

}
