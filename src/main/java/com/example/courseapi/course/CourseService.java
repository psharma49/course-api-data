package com.example.courseapi.course;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class CourseService {
	
	@Autowired
	private CourseRepository courseRepository;
	
	public List<Course> getAllCourses(String topicId)
	{
		
		List <Course> courses = new ArrayList<> ();
		courseRepository.findByTopicId(topicId).
		forEach(courses::add);
//		List<Course> courses = new ArrayList<> ();	
//		
//		courseRepository.findAll().
//		forEach(courses::add);
//		
//		List<Course> coursesFinal = new ArrayList<> ();
//		
//		for(int i=0; i<courses.size(); i++)
//		{
//			Course temp = courses.get(i);
//			Topic temp2 = temp.getTopic();
//			if(temp2.getId().equals(id))
//			{
//				coursesFinal.add(temp);
//			}
//			
//		}
		
//		courseRepository.findAll().
//		forEach(courses::add);
		return courses;
	}
	
	public Optional<Course> getCourse(String id)
	{
//		return topics.stream().filter(t-> t.getId().equals(id)).findFirst().get();
		return courseRepository.findById(id);
	}
	
	public void addCourse(Course course)
	{
		
		courseRepository.save(course);
	}

	public void updateCourse(Course course) 
	{
//		for(int i=0; i<topics.size(); i++)
//		{
//			Topic temp = topics.get(i);
//			if(temp.getId().equals(id))
//			{
//				topics.set(i, topic);
//				return;
//			}
//			
//		}
		courseRepository.save(course);
	}

	public void deleteCourse(Course course,String id) 
	{
//		for(int i=0; i<topics.size(); i++)
//		{
//			Topic temp = topics.get(i);
//			if(temp.getId().equals(id))
//			{
//				topics.remove(i);
//				return;
//			}
//			
//		}
		//Above code is also correct
//		topics.removeIf(t -> t.getId().equals(id) );
		courseRepository.deleteById(id);
	}
}
