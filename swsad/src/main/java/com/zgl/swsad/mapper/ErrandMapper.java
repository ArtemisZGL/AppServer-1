package com.zgl.swsad.mapper;

import com.zgl.swsad.model.Errand;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

@Repository
public interface ErrandMapper {
    @Insert("INSERT INTO errand (description, taskId)" +
            " Values(#{description}, #{taskId})")
    @Options(useGeneratedKeys = true, keyProperty = "errandId")
    int insertErrand(Errand errand);

    @Update("UPDATE errand set description=#{description}, taskId=#{taskId} where errandId=#{errandId}")
    int updateErrand(Errand errand);

    @Select("SELECT * FROM errand WHERE taskId = #{taskId}")
    Errand selectErrandByTaskID(int id);//id 是taskid


    @Select("SELECT * FROM errand WHERE errandId = #{errandId}")
    Errand selectErrand(int id);

    @Delete("DELETE FROM errand WHERE errandId = #{errandId}")
    int deleteErrand(int id);
}
