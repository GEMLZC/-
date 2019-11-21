package cn.wolfcode.springboot.ssm.service.impl;

import java.util.List;

import cn.wolfcode.springboot.ssm.domain.Employee;
import cn.wolfcode.springboot.ssm.mapper.EmployeeMapper;
import cn.wolfcode.springboot.ssm.query.QueryObject;
import cn.wolfcode.springboot.ssm.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;


@Service
@Transactional
public class EmployeeServiceImpl implements IEmployeeService {
	@Autowired
	private EmployeeMapper mapper;

	@Override
	public void remove(Long id) {
		mapper.deleteByPrimaryKey(id);
		//System.out.println(1/0);
	}

	@Override
	public void save(Employee record) {
		if (record.getId() != null) {
			mapper.updateByPrimaryKey(record);
		}else {
			mapper.insert(record);
		}

	}

	@Transactional(readOnly=true)
	@Override
	public Employee get(Long id) {
		
		return mapper.selectByPrimaryKey(id);
	}
	
	
	@Transactional(readOnly=true)
	@Override
	public PageInfo<Employee> allList(QueryObject qo) {
		PageHelper.startPage(qo.getCurrentPage(), qo.getPageSize());
		List<Employee> list = mapper.selectAll(qo);
		PageInfo<Employee> page = new PageInfo<>(list);
		if (page.getPrePage() == 0) {
			page.setPrePage(1);
		}
		if (page.getNextPage() == 0) {
			page.setNextPage(page.getPages());
		}
		return page;
	}

}
