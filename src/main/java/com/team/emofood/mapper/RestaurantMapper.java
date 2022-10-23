package com.team.emofood.mapper;

import com.team.emofood.dto.Restaurant;
import com.team.emofood.dto.RestaurantExample;
import com.team.emofood.util.PageQueryUtil;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface RestaurantMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table restaurant
     *
     * @mbg.generated Sun Oct 23 17:51:11 KST 2022
     */
    long countByExample(RestaurantExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table restaurant
     *
     * @mbg.generated Sun Oct 23 17:51:11 KST 2022
     */
    int deleteByExample(RestaurantExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table restaurant
     *
     * @mbg.generated Sun Oct 23 17:51:11 KST 2022
     */
    int deleteByPrimaryKey(Integer rid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table restaurant
     *
     * @mbg.generated Sun Oct 23 17:51:11 KST 2022
     */
    int insert(Restaurant row);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table restaurant
     *
     * @mbg.generated Sun Oct 23 17:51:11 KST 2022
     */
    int insertSelective(Restaurant row);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table restaurant
     *
     * @mbg.generated Sun Oct 23 17:51:11 KST 2022
     */
    List<Restaurant> selectByExample(RestaurantExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table restaurant
     *
     * @mbg.generated Sun Oct 23 17:51:11 KST 2022
     */
    Restaurant selectByPrimaryKey(Integer rid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table restaurant
     *
     * @mbg.generated Sun Oct 23 17:51:11 KST 2022
     */
    int updateByExampleSelective(@Param("row") Restaurant row, @Param("example") RestaurantExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table restaurant
     *
     * @mbg.generated Sun Oct 23 17:51:11 KST 2022
     */
    int updateByExample(@Param("row") Restaurant row, @Param("example") RestaurantExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table restaurant
     *
     * @mbg.generated Sun Oct 23 17:51:11 KST 2022
     */
    int updateByPrimaryKeySelective(Restaurant row);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table restaurant
     *
     * @mbg.generated Sun Oct 23 17:51:11 KST 2022
     */
    int updateByPrimaryKey(Restaurant row);

    List<Restaurant> findRestaurantList(PageQueryUtil pageUtil);
    int getTotalRestaurant(PageQueryUtil pageUtil);
}