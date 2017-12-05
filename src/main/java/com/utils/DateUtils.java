/**
 *  www.yupaopao.cn 2014-2017©All Rights Reserved
 */
package com.utils;

import com.common.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;

import lombok.extern.slf4j.Slf4j;

/**
 * <p>
 * 日期工具类
 * </p>
 *
 * @author xiaoyu.wang
 * @date 2017年8月11日 下午3:00:13
 * @version
 */
@Slf4j
public class DateUtils {

	/**
	 * <p>
	 * 解析日期 默认格式yyyy-MM-dd HH:mm:ss
	 * </p>
	 * 
	 * @param value
	 * @return Date
	 */
	public static Date parseSecond(String value) {
		if (StringUtils.isBlank(value)) {
			return null;
		}
		return parse(value, DateFormat.StrikeDateTime.format);
	}

	/**
	 * <p>
	 * 解析日期
	 * </p>
	 * 
	 * @param value
	 *            时间字符串
	 * @param format
	 *            时间格式
	 * @return
	 */
	public static Date parse(String value, String format) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(format);
		try {
			Date date = dateFormat.parse(value);
			return date;
		} catch (ParseException e) {
			log.error(e.getMessage(), e);
		}
		return null;
	}

	/**
	 * <p>
	 * 计算开始日期和结束日期的间隔时间
	 * </p>
	 * 
	 * @param begin
	 *            开始日期
	 * @param end
	 *            结束日期
	 * @return 差值
	 */
	public static long substractDate(Date begin, Date end) {
		if (begin == null || end == null) {
			return 0l;
		}
		return substractTime(begin.getTime(), end.getTime());
	}

	/**
	 * <p>
	 * 计算开始时间和结束时间的间隔时间
	 * </p>
	 * 
	 * @param beginTime
	 *            开始时间
	 * @param endTime
	 *            结束时间
	 * @return 差值
	 */
	public static long substractTime(long beginTime, long endTime) {
		return endTime - beginTime;
	}

	/**
	 * <p>
	 * 获取时间描述 XX天XX小时XX分钟
	 * </p>
	 * 
	 * @param subTime
	 * @return XX天XX小时XX分钟
	 */
	public static String subTimeDesc(long subTime) {
		long day = subTime / (24 * 60 * 60 * 1000);
		long hour = (subTime / (60 * 60 * 1000) - day * 24);
		long min = ((subTime / (60 * 1000)) - day * 24 * 60 - hour * 60);
		long second = (subTime / 1000 - day * 24 * 60 * 60 - hour * 60 * 60 - min * 60);
		StringBuilder builder = new StringBuilder();
		if (day > 0) {
			builder.append(day).append("天");
		}
		if (hour > 0) {
			builder.append(hour).append("小时");
		}
		if (min > 0) {
			builder.append(min).append("分钟");
		}
		if (builder.length() == 0 && second > 0) {
			builder.append("1分钟");
		}
		return builder.length() == 0 ? StringUtils.EMPTY : builder.toString();
	}
}
