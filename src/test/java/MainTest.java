import com.mobai.springmvcdemo.entity.Student;
import com.mobai.springmvcdemo.service.Impl.StudentServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static org.junit.Assert.assertNotNull;

@Service
public class MainTest {

  @Autowired
  StudentServiceImpl studentService;

  @Test
  public void testGetStudentById() {
    Student student = studentService.getStudentById(1);
    assertNotNull(student);
  }
}