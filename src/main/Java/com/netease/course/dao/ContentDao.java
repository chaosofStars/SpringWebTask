package com.netease.course.dao;


import com.netease.course.meta.Content;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContentDao {

    @Results({
            @Result(property = "productId", column = "id"),
            @Result(property = "price", column = "price",
                    javaType = Float.class, jdbcType = JdbcType.BIGINT),
            @Result(property = "title", column = "title"),
            @Result(property = "image", column = "icon"),
            @Result(property = "summary", column = "abstract"),
            @Result(property = "detail", column = "text")}
    )
    @Select("SELECT id, price, title, icon, abstract, text FROM content Where id=#{productId}")
    Content getContentById(int productId);

    @Results({
            @Result(property = "productId", column = "id"),
            @Result(property = "price", column = "price",
                    javaType = Float.class, jdbcType = JdbcType.BIGINT),
            @Result(property = "title", column = "title"),
            @Result(property = "image", column = "icon"),
            @Result(property = "summary", column = "abstract"),
            @Result(property = "detail", column = "text")}
    )
    @Select(" select id from content order by id desc limit 1 ")
    int getContentLastId();


    @Results({
            @Result(property = "productId", column = "id"),
            @Result(property = "price", column = "price",
                    javaType = Float.class, jdbcType = JdbcType.BIGINT),
            @Result(property = "title", column = "title"),
            @Result(property = "image", column = "icon"),
            @Result(property = "summary", column = "abstract"),
            @Result(property = "detail", column = "text")}
    )
    @Select("SELECT id, price, title, icon, abstract, text FROM content")
    List<Content> listContents();

    @Select("INSERT INTO content (price, title, icon, abstract, text) VALUES " +
            " (#{price}, #{title}, #{image}, #{summary}, #{detail})")

    void insertContent(@Param("price") float price, @Param("title") String title,
                              @Param("image") byte[] image, @Param("summary") String summary,
                              @Param("detail") byte[] detail);


    @Select(" DELETE FROM content WHERE id = #{productId}")
    void deleteContent(int productId);


    @Select("UPDATE content SET price = #{price}, title = #{title}, " +
            "icon = #{image}, abstract = #{summary}, text = #{detail} " +
            "  WHERE id = #{productId}")
    void updateContent(@Param("productId") int productId, @Param("price") float price,
                              @Param("title") String title, @Param("image") byte[] image,
                              @Param("summary") String summary, @Param("detail") byte[] detail);


}
