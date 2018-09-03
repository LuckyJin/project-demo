package com.cn.springmvc;

import com.cn.service.common.util.DateUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.core.convert.converter.Converter;

import java.util.Arrays;
import java.util.Date;

/**
 * Created by baomingfeng at 2017-09-04 16:50:48
 * <p>
 * 日期转换器(处理Controller方法自定义的接收参数对象Date类型Field)
 * <p/>
 * 根据日期字符串长度判断是长日期还是短日期。只支持yyyy-MM-dd，yyyy-MM-dd HH:mm:ss，yyyy-MM-dd HH:mm:ss.SSS (自定义扩展)
 *
 * @see <a href="http://docs.spring.io/spring/docs/current/spring-framework-reference/html/validation.html">9.5.3 GenericConverter</a>
 */
public class StringToDateConverter implements Converter<String, Date> {

    @Override
    public Date convert(String text) {
        if (StringUtils.isEmpty(text)) {
            return null;
        }

        text = text.trim();

        /*根据字符串长度，怎么简单怎么来?*/
        if (text.length() == DateUtils.DATE_PATTERN.length()) {
            return DateUtils.parseDate(text);
        } else if (text.length() == DateUtils.DATETIME_PATTERN.length()) {
            return DateUtils.parseDatetime(text);
        } else if (text.length() == DateUtils.DATETIME_MILLI_PATTERN.length()) {
            return DateUtils.parseDatetimeMilli(text);
        }

        throw new IllegalArgumentException("Could not parse date: [" + text + "], choose date pattern from "
                + Arrays.asList(DateUtils.DATE_PATTERN, DateUtils.DATETIME_PATTERN, DateUtils.DATETIME_MILLI_PATTERN));
    }

}
