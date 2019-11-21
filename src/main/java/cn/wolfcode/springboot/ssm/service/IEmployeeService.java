package cn.wolfcode.springboot.ssm.service;


import cn.wolfcode.springboot.ssm.domain.Employee;
import cn.wolfcode.springboot.ssm.query.QueryObject;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IEmployeeService {
	void remove(Long id);

	void save(Employee record);

	Employee get(Long id);

	PageInfo<Employee> allList(QueryObject qo);
}
