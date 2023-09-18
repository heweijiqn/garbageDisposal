package com.gcms.mapper;

import com.gcms.pojo.GarbageType;
import com.gcms.pojo.GarbageTypeExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GarbageTypeMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table garbage_type
     *
     * @mbg.generated Fri May 01 16:27:47 CST 2020
     */
    long countByExample(GarbageTypeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table garbage_type
     *
     * @mbg.generated Fri May 01 16:27:47 CST 2020
     */
    int deleteByExample(GarbageTypeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table garbage_type
     *
     * @mbg.generated Fri May 01 16:27:47 CST 2020
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table garbage_type
     *
     * @mbg.generated Fri May 01 16:27:47 CST 2020
     */
    int insert(GarbageType record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table garbage_type
     *
     * @mbg.generated Fri May 01 16:27:47 CST 2020
     */
    int insertSelective(GarbageType record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table garbage_type
     *
     * @mbg.generated Fri May 01 16:27:47 CST 2020
     */
    List<GarbageType> selectByExample(GarbageTypeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table garbage_type
     *
     * @mbg.generated Fri May 01 16:27:47 CST 2020
     */
    GarbageType selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table garbage_type
     *
     * @mbg.generated Fri May 01 16:27:47 CST 2020
     */
    int updateByExampleSelective(@Param("record") GarbageType record, @Param("example") GarbageTypeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table garbage_type
     *
     * @mbg.generated Fri May 01 16:27:47 CST 2020
     */
    int updateByExample(@Param("record") GarbageType record, @Param("example") GarbageTypeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table garbage_type
     *
     * @mbg.generated Fri May 01 16:27:47 CST 2020
     */
    int updateByPrimaryKeySelective(GarbageType record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table garbage_type
     *
     * @mbg.generated Fri May 01 16:27:47 CST 2020
     */
    int updateByPrimaryKey(GarbageType record);

    List<GarbageType> getAllByLimit(GarbageType pojo);

    int countAllByLimit(GarbageType pojo);
}