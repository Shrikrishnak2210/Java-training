package telecom.boot.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import telecom.boot.dao.TelecomPlanDao;
import telecom.boot.model.TelecomPlan;

@RestController
@RequestMapping("/plan")
public class TelecomPlanController {

	private final TelecomPlanDao planDAO;

	@Autowired
	public TelecomPlanController(TelecomPlanDao planDAO) {
		this.planDAO = planDAO;
	}

	@GetMapping
	public ResponseEntity<List<TelecomPlan>> getAllPlans() {
		List<TelecomPlan> plans = planDAO.getAllPlans();
		return ResponseEntity.ok(plans);
	}

	@GetMapping("/{id}")
	public ResponseEntity<TelecomPlan> getPlanById(@PathVariable Long id) {
		TelecomPlan plan = planDAO.getPlanById(id);
		if (plan != null) {
			return ResponseEntity.ok(plan);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@PostMapping
	@Transactional
	public ResponseEntity<TelecomPlan> createPlan(@RequestBody TelecomPlan plan) {
		TelecomPlan createdPlan = planDAO.createPlan(plan);
		return ResponseEntity.status(HttpStatus.CREATED).body(createdPlan);
	}

	@PutMapping("/{id}")
	public ResponseEntity<TelecomPlan> updatePlan(@PathVariable Long id, @RequestBody TelecomPlan plan) {
		TelecomPlan existingPlan = planDAO.getPlanById(id);
		if (existingPlan != null) {
			existingPlan.setPlanName(plan.getPlanName());
			TelecomPlan updatedPlan = planDAO.updatePlan(existingPlan);
			return ResponseEntity.ok(updatedPlan);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletePlan(@PathVariable Long id) {
		TelecomPlan plan = planDAO.getPlanById(id);
		if (plan != null) {
			planDAO.deletePlan(plan);
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}
}