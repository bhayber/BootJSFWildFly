package de.adesso.testJSF;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.Data;

@RestController
public class HelloController {
	@Autowired
	NamedParameterJdbcTemplate jdbcTemplate;

	@RequestMapping("/")
	String hello() {
		return "Hello World!";
	}

	@Data
	static class Result {
		public Result(int left2, int right2, long long1) {
			left = left2;
			right = right2;
			answer = long1;
		}

		public int getLeft() {
			return left;
		}

		public int getRight() {
			return right;
		}

		public long getAnswer() {
			return answer;
		}

		private final int left;
		private final int right;
		private final long answer;
	}

	// SQL sample
	@RequestMapping("/calc")
	Result calc(@RequestParam int left, @RequestParam int right) {
		MapSqlParameterSource source = new MapSqlParameterSource().addValue("left", left).addValue("right", right);
		return jdbcTemplate.queryForObject("SELECT :left + :right AS answer", source,
				(rs, rowNum) -> new Result(left, right, rs.getLong("answer")));
	}

	@RequestMapping("/hello/{name}")
	String hello(@PathVariable String name) {
		return "Hi " + name + " !";
	}
}
