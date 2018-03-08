package com.cafe24.hr.dao.test;

import java.util.List;

import com.cafe24.hr.dao.EmployeesDao;
import com.cafe24.hr.vo.EmployeesVo;

public class EmployeesDaoTest {

	public static void main(String[] args) {
		updatetest();
		//getListTest();
	}


	public static void getListTest() {
		EmployeesDao dao = new EmployeesDao();
		List<EmployeesVo> list = dao.getList(1);
		for( EmployeesVo vo : list) {
			System.out.println( vo );
		}
	}
	
	public static void updatetest() {
		EmployeesDao dao = new EmployeesDao();
		
		EmployeesVo vo = new EmployeesVo();
		vo.setEmpNo( 10001L );
		vo.setBirthDate( "2018-03-08");
		vo.setFirstName( "마" );
		vo.setLastName( "이콜" );
		vo.setGender( "M" );
		vo.setHireDate( "2018-03-08" );
		
		dao.update(vo);
	}
}
