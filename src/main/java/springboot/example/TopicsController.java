package springboot.example;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopicsController {

	@Autowired
	private TopicsService topicsServices;
	
	@RequestMapping(value="/topics")
	public List<Topics> getTopics(){
		return topicsServices.getTopics();
	}
	
	@RequestMapping(value="/topic/{id}", method=RequestMethod.GET)
	public Topics getTopic(@PathVariable String id){
		return topicsServices.getTopic(id);
	}
	
	@RequestMapping(value="/topic", method=RequestMethod.POST)
	public void saveTopic(@RequestBody Topics topic){
		topicsServices.saveTopic(topic);
	}
	
	@RequestMapping(value="/topic/{id}", method=RequestMethod.DELETE)
	public void deleteTopic(@PathVariable String id){
		topicsServices.deleteTopic(id);
	}
	
	@RequestMapping(value="/topic/{id}", method=RequestMethod.PUT)
	public void updateTopic(@PathVariable String id,@RequestBody Topics topic){
		topicsServices.updateTopic(id, topic);
	}
}
