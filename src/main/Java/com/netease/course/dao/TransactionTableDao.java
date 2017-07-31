package com.netease.course.dao;


import com.netease.course.meta.TransactionTable;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionTableDao {


    @Results({
            @Result(property = "productId", column = "contentId"),
            @Result(property = "userId", column = "personId"),
            @Result(property = "buyPrice", column = "price"),
            @Result(property = "time", column = "time"),
            @Result(property = "num", column = "num")}
    )
    @Select(" SELECT contentId, personId, price, time, num " +
            " FROM trx WHERE contentId = #{productId} ORDER BY time DESC ")
    List<TransactionTable> getTrxByProductId(int productId);


    @Select("INSERT INTO trx (contentId, personId, price, time, num) VALUES " +
            " (#{productId}, #{userId}, #{buyPrice}, #{time}, #{num})")
    void insertTrx(@Param("productId") int productId, @Param("userId") int userId, @Param("buyPrice") float buyPrice, @Param("time") long time, @Param("num") int num);

    @Results({
            @Result(property = "productId", column = "contentId"),
            @Result(property = "userId", column = "personId"),
            @Result(property = "buyPrice", column = "price"),
            @Result(property = "time", column = "time"),
            @Result(property = "num", column = "num")}
    )
    @Select("SELECT contentId, personId, price, time, num FROM trx ")
    List<TransactionTable> listTables();
}
