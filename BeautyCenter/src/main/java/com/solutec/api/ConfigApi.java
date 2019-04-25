package com.solutec.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.solutec.dao.ConfigRepository;
import com.solutec.entities.Config;

@RestController
@CrossOrigin("*")
public class ConfigApi {
	
	@Autowired
	private ConfigRepository configRepos;
	
	@RequestMapping(value="/config", method = RequestMethod.GET)
	public List<Config> getConfig(){
		return configRepos.findAll();
	}
	
	@RequestMapping(value="/config/{id}", method=RequestMethod.GET) 
	public Config getConf(@PathVariable Long idSalon) { 
		return configRepos.findOne(idSalon); 
		}
	
	@RequestMapping(value="/config", method=RequestMethod.POST) 
	public Config saveConfig(@RequestBody Config s) { 
		return configRepos.save(s); 
		}

	@RequestMapping(value="/config/{id}", method=RequestMethod.DELETE) 
	public boolean supConfig(@PathVariable Long id) { 
		configRepos.delete(id);
		return true; 
		}

	@RequestMapping(value="/config/{id}", method=RequestMethod.PUT) 
	public Config modifConfig(@PathVariable Long id, @RequestBody Config s) { 
		s.setIdConfig(id); 
		return configRepos.save(s); 
		}


}
