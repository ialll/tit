package org.tit_admin_dao.demo;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.tit_admin_model.demo.TestDomain;
import org.tit_admin_model.demo.TestDomainExample;

public interface MyBatisTestDao {
    int countByExample(TestDomainExample example);

    int deleteByExample(TestDomainExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TestDomain record);

    int insertSelective(TestDomain record);

    List<TestDomain> selectByExample(TestDomainExample example);

    TestDomain selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TestDomain record, @Param("example") TestDomainExample example);

    int updateByExample(@Param("record") TestDomain record, @Param("example") TestDomainExample example);

    int updateByPrimaryKeySelective(TestDomain record);

    int updateByPrimaryKey(TestDomain record);
}