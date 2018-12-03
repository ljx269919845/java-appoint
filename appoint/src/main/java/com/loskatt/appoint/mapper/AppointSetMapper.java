package com.loskatt.appoint.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.loskatt.appoint.common.Result;
import com.loskatt.appoint.model.AppointSet;
import com.loskatt.appoint.vo.AppointSearch;
import com.loskatt.appoint.vo.AppointSetVO;

@Mapper
public interface AppointSetMapper {

	 /**
	  *  *新增预约设置
     * @param appoint
     */
    int insertSetting(AppointSet appointSet);
    
    
    /**
	  *  *更新预约设置
    * @param appoint
    */
    int updateSetting(AppointSet appointSet);
    
    
    /**
	  *  *删除预约设置
   * @param appoint
   */
   int deleteSetting(Long settingId);
    
    /**
	  *  *根据设置ID查询预约设置 锁行
    * @param id
    */
    AppointSet selectSettingForUpdate(Long id);
    
    
    /**
	  *  *更新预约设置余号量
   * @param appoint
   */
    int updateSurplusNum(AppointSet appointSet);
    
    
    /** 根据科室ID获取预约设置记录
   * @param id
   */
   List<AppointSet> loadSettingForDepart(Long departId);
   
   /** 根据医生ID获取预约设置记录
    * @param id
    */
    List<AppointSet> loadSettingForDoctor(Long doctorId);
    
    /** 根据条件统计已预约总数
     * @param departId
     */
    int countAppoints(@Param("appointSearch") AppointSearch appointSearch);

    /**
	  *  *恢复余号量
   * @param appoint
   */
   void clearSurplus();
   
   /** 根据条件复合查询预约配置记录
    * @param departId
    */
   List<AppointSetVO> getAppointSetList(@Param("appointSearch") AppointSearch appointSearch);
   
   /**
    *    *根据配置ID更新配置记录的状态
    * @param appointId   status
    * 
    * @return row 更新行
    */
   int updateStatus(@Param("id") Long id,@Param("status") Integer status);
}
