import com.example.model.Employees;
import com.example.repository.EmployeeRepository;
import com.example.util.EmployeeType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.Date;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class Spring_boot_H2_test {
    @Autowired
    private EmployeeRepository empRepository;

    @Test
    @DisplayName("Create User Test ")
    void createEmpTest() {
        Employees created = empRepository.save(getEmp());
        assertTrue(created != null);
    }

    private Employees getEmp() {

        Employees emp = new Employees();
        emp.setEmpType(EmployeeType.S);
        emp.setEmpName("PeterM");
        emp.setPassword("ABC123abc*");
        emp.setDateofBirth(new Date());
        emp.setCreationTime(new Date());

        return emp;
    }
}