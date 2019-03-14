package com.javadev;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.javadev.dao.MenuDao;
import com.javadev.domain.Menu;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MenuTest {
	
	@Autowired
	private MenuDao menuDao;
	
	@Test
	public void testSelectMenuList(){
		List<Menu> list = menuDao.selectMenuList();
		for (Menu menu : list) {
			System.out.println(menu.getMenuName());
		}
	}
}
