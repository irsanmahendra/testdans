package id.mahendra.test.job;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/job")
public class JobController {

	private final JobService service;

	@GetMapping(value = {"" , "/"})
	public ResponseEntity<List<Job>> findAll() {
		return ResponseEntity.ok(service.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Job> findById(@PathVariable("id") String id) {
		return ResponseEntity.ok(service.findById(id));
	}

}
