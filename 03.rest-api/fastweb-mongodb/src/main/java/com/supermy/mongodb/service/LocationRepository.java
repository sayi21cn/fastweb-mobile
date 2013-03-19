package com.supermy.mongodb.service;

import java.util.List;

import org.springframework.data.mongodb.core.geo.Box;
import org.springframework.data.mongodb.core.geo.Distance;
import org.springframework.data.mongodb.core.geo.Point;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.supermy.mongodb.domain.Location;
 
/**
 * 自定义查询方法,格式为findBy+字段名+方法名,方法传进的参数即字段的值,此外还支持分页查询,通过传进一个Pageable对象会返回Page集合.<br/>
 * near与within方法区别,near方法查询后会对结果集对distance进行排序且有大小限制,而within是无序的也无大小限制
 * 
 * @author jamesmo
 *
 */
public interface LocationRepository extends MongoRepository<Location, String> {
 
	List<Location> findByPositionNear(Point p, Distance d);
 
	List<Location> findByPositionWithin(Box b);
	
	
 
}