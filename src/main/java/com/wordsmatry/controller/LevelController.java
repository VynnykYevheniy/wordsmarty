package com.wordsmatry.controller;

import com.wordsmatry.api.LevelDTO;
import com.wordsmatry.core.constant.ApiEndpoint;
import com.wordsmatry.service.LevelService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Yevhenii Vynnyk
 * @since 2023/09/27
 */
@RestController
@RequestMapping(value = ApiEndpoint.LEVEL, produces = {MediaType.APPLICATION_JSON_VALUE})
public class LevelController {
	@Autowired
	private LevelService levelService;

	@PostMapping(ApiEndpoint.CREATE)
	public void createLevel(@RequestBody LevelDTO levelDTO) {
		levelService.save(levelDTO);
	}

	@DeleteMapping(ApiEndpoint.DELETE)
	public void deleteLevel(@PathVariable Long id) {
		levelService.delete(id);
	}

	@GetMapping(ApiEndpoint.FIND_BY_ID)
	public LevelDTO getLevelById(@PathVariable Long id) {
		return levelService.findById(id);
	}

	@GetMapping(ApiEndpoint.FIND_ALL)
	public List<LevelDTO> getAllLevels() {
		return levelService.findAll();
	}

}