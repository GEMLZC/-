package cn.wolfcode.springboot.ssm.mapper;



import cn.wolfcode.springboot.ssm.domain.Employee;
import cn.wolfcode.springboot.ssm.query.QueryObject;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface EmployeeMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Employee record);

    Employee selectByPrimaryKey(Long id);

    List<Employee> selectAll(QueryObject qo);

    int updateByPrimaryKey(Employee record);
}