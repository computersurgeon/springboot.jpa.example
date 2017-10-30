package springboot.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicsService {

	@Autowired
	private TopicRepository topicRepository;

	/*private List<Topics> topics = new ArrayList<>(Arrays.asList(new Topics("1", "java", "java description"),
			new Topics("2", "j2E", "java Enterprise Edition"), new Topics("3", "javaScript", "javaScript description")));*/

	public List<Topics> getTopics() {
		List<Topics> topicList = new ArrayList<>();
		 topicRepository.findAll().forEach(topicList::add);
		 return topicList;
	}

	public Topics getTopic(String id) {
		//return topics.stream().filter(t->t.getId().equals(id)).findFirst().get();
		return topicRepository.findOne(id);
	}

	public void saveTopic(Topics topic) {
		//topics.add(topic);
		topicRepository.save(topic);
	}

	public void deleteTopic(String id) {
		//topics.removeIf(t->t.getId().equals(id));
		topicRepository.delete(id);
	}

	public void updateTopic(String id, Topics topic) {
		/*for(int i=0;i<topics.size();i++){
			Topics t = topics.get(i);
			if(t.getId().equals(id))
			{
				topics.set(i, topic);
				return;
			}
			
		}*/
		topicRepository.save(topic);
	}
}
