
package com.StudentServiceTesting;





import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.test.context.junit.jupiter.SpringExtension;


import com.Service.StudentServiceImpl;
import com.model.Student;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)

public class ApplicationTesting {

	
	
	@Autowired
	StudentServiceImpl stu;
	
	
	@Test
	public void findAll() {
		List<Student> stuu=stu.findByAll();

		assertThat(stuu,containsInAnyOrder(hasProperty("name",equalTo("shan"))));
		
		
		
		
	}
	
	
}
