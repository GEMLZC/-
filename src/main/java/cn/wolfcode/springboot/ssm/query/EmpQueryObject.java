package cn.wolfcode.springboot.ssm.query;

import java.math.BigDecimal;

import org.springframework.util.StringUtils;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmpQueryObject extends QueryObject {
	private String keyword;
	private BigDecimal minSalary;
	private BigDecimal maxSalary;
	
	public String getKeyword() {
		return StringUtils.hasLength(keyword) ? keyword : null;
	}
}
