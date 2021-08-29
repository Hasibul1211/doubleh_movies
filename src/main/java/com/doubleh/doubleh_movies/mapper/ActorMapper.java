package com.doubleh.doubleh_movies.mapper;


import com.doubleh.doubleh_movies.bean.Actor;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ActorMapper {

    @Select("select * from actor a,film_actor f where film_id=#{fid} and a.actor_id=f.actor_id")
   public List<Actor> getActorsByFilmId(int fid);


}
