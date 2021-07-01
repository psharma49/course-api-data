package com.example.courseapi.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {
	
	@Autowired
	private TopicRepository topicRepository;
	
	private List<Topic> topics = new ArrayList <> ( Arrays.asList(
            new Topic("spring","spring framework","spring framework description"),
            new Topic("java","core java","core java description"),
            new Topic("javascript","Javascript","Javascript Description")
			));

	public List<Topic> getAllTopics()
	{
//		return topics;
		List<Topic> topicss = new ArrayList<> ();
		
		topicRepository.findAll().
		forEach(topicss::add);
		return topicss;
	}
	
	public Optional<Topic> getTopic(String id)
	{
//		return topics.stream().filter(t-> t.getId().equals(id)).findFirst().get();
		return topicRepository.findById(id);
	}
	
	public void addTopic(Topic topic)
	{
		
		topicRepository.save(topic);
	}

	public void updateTopic(Topic topic,String id) 
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
		topicRepository.save(topic);
	}

	public void deleteTopic(Topic topic, String id) 
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
		topicRepository.deleteById(id);

	}
}
