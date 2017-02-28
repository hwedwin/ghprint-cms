package com.ghprint.cms.serviceDao;

import com.ghprint.cms.model.sys.TDictionaryInfo;
import com.ghprint.cms.model.sys.TDictionaryInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TDictionaryInfoMapper {
    int countByExample(TDictionaryInfoExample example);

    int deleteByExample(TDictionaryInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TDictionaryInfo record);

    int insertSelective(TDictionaryInfo record);

    List<TDictionaryInfo> selectByExample(TDictionaryInfoExample example);

    TDictionaryInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TDictionaryInfo record, @Param("example") TDictionaryInfoExample example);

    int updateByExample(@Param("record") TDictionaryInfo record, @Param("example") TDictionaryInfoExample example);

    int updateByPrimaryKeySelective(TDictionaryInfo record);

    int updateByPrimaryKey(TDictionaryInfo record);
}