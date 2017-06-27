import java.util.ArrayList;

/**
 * Created by 王宁 on 2017/5/8.
 */
public class Student {
    Student(int id,String name,Course[] course){
        this.id = id;
        this.name=name;
        this.course=course;
    }

    private int id;
    private String name;
    private Course[] course;

    public void find(String courseName){
        for (Course c :course) {
          if (c.name.equals(courseName))
              System.out.println("课程id："+c.id+"课程名称："+c.name+"  成绩"+c.score);
      }

    }


    public void find(int id){
        for (Course c :course) {
           if (new Integer(id).equals(c.id))
            //  if(id==course[i].id)
                System.out.println("课程id："+c.id+"课程名称："+c.name+"  成绩"+c.score);
        }

    }
    public void avgCourse() {
        float sum = 0;
        for (int i = 0; i < course.length; i++) {
            sum += course[i].score;
        }
        float avg = sum / course.length;
        System.out.println("课程平均分"+avg);

    }
}
