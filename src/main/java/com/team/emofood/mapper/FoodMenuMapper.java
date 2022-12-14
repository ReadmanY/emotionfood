package com.team.emofood.mapper;

import com.team.emofood.dto.FoodMenu;
import com.team.emofood.dto.FoodMenuExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface FoodMenuMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table food_menu
     *
     * @mbg.generated Sun Oct 23 17:51:32 KST 2022
     */
    long countByExample(FoodMenuExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table food_menu
     *
     * @mbg.generated Sun Oct 23 17:51:32 KST 2022
     */
    int deleteByExample(FoodMenuExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table food_menu
     *
     * @mbg.generated Sun Oct 23 17:51:32 KST 2022
     */
    int deleteByPrimaryKey(Integer fid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table food_menu
     *
     * @mbg.generated Sun Oct 23 17:51:32 KST 2022
     */
    int insert(FoodMenu row);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table food_menu
     *
     * @mbg.generated Sun Oct 23 17:51:32 KST 2022
     */
    int insertSelective(FoodMenu row);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table food_menu
     *
     * @mbg.generated Sun Oct 23 17:51:32 KST 2022
     */
    List<FoodMenu> selectByExample(FoodMenuExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table food_menu
     *
     * @mbg.generated Sun Oct 23 17:51:32 KST 2022
     */
    FoodMenu selectByPrimaryKey(Integer fid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table food_menu
     *
     * @mbg.generated Sun Oct 23 17:51:32 KST 2022
     */
    int updateByExampleSelective(@Param("row") FoodMenu row, @Param("example") FoodMenuExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table food_menu
     *
     * @mbg.generated Sun Oct 23 17:51:32 KST 2022
     */
    int updateByExample(@Param("row") FoodMenu row, @Param("example") FoodMenuExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table food_menu
     *
     * @mbg.generated Sun Oct 23 17:51:32 KST 2022
     */
    int updateByPrimaryKeySelective(FoodMenu row);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table food_menu
     *
     * @mbg.generated Sun Oct 23 17:51:32 KST 2022
     */
    int updateByPrimaryKey(FoodMenu row);
}