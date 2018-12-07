package com.loskatt.appoint.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.loskatt.appoint.model.Appoint;
import com.loskatt.appoint.vo.AppointSearch;
import com.loskatt.appoint.vo.AppointVO;

@Mapper
public interface AppointMapper {

	 /**
	  *  *预约申请
     * @param appoint
     */
    long appoint(Appoint appoint);

    /**
     *    *判断用户当天是否预约了同一科室同一医生的号
     * @param appoint
     * 
     * @return num > 0 表示已经预约
     */
    int checkAppointByCondition(@Param("appoint") Appoint appoint);
    
    /**
     *    *根据预约ID查询预约信息,包括:科室信息、医生信息、用户信息以及预约信息
     * @param appoint
     * 
     * @return AppointVO
     */
    AppointVO selectAppointInfo(Long appointId);
    
    
    /**
     *    *根据预约ID更新预约记录的状态: 销号、取消预约
     * @param appointId   status
     * 
     * @return row 更新行
     */
    int updateStatus(@Param("id") Long id,@Param("status") Integer status);
    
    
    /**
     *    *根据组合条件查询预约记录
     * @param appointSearch
     * 
     * @returnList<AppointVO>
     */
    List<AppointVO> getAppointList(@Param("appointSearch") AppointSearch appointSearch);
    
}
