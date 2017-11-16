package com.betalpha.utils;

import tk.mybatis.mapper.common.IdsMapper;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * dao父接口
 * @author xiehai1
 * @date 2017/11/16 11:23
 * @Copyright(c) gome inc Gome Co.,LTD
 */
public interface CsvMapper<T> extends Mapper<T>, MySqlMapper<T>, IdsMapper<T> {
}
