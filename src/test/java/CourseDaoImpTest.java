import com.homework.Dao.CourseDao;
import com.homework.Dao.CourseDaoImpl;
import com.homework.models.ExchangeCourse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Date;

import static com.homework.util.Util.addOneExs;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CourseDaoImpTest {
    CourseDao dao;

    @BeforeEach
    public void initialize() {
        dao = new CourseDaoImpl();
    }

    @Test
    void IfReturnByDateOk() throws IOException {
        ExchangeCourse course1 = addOneExs(dao);
        ExchangeCourse course2 = dao.getCoursesByDate(new Date(124, 0, 1));
        assertEquals(course1, course2);


    }
}
