/**
 * Created by 王宁 on 2017/5/8.
 * 建立一个Test.java文件，文件中包括三个类，主类Test，一个学生类（Student），一个课程类（Course）。
 * 课程类拥有属性（id：int，name:String，score:float）,通过构造函数给课程类属性赋值。
 * 学生类拥有属性（id：int，name：String，courses：Course[]（是一个课程类数组，表示学生本学期上的所有课程）），
 * 学生类拥有方法（find）按课程号进行查询，输出课程信息，方法（find）按照课程名进行查询，
 * 输出课程信息[注字符串类型判等使用”判断字符串”.equals(“判断字符串”)，不能使用==]，
 * 方法（avgCourse）求学生所有课程的平均分。
 * Test类拥有main方法，负责创建三门课程对象（（1，语文，76.3），（2，数学，89），（3，体育，90）），
 * 创建学生对象，把创建的课程对象存入学生课程数组。
 * 调用查询方法（分别按学号，课程名查询），输出课程信息。输出学生的平均分。
 */
public class Test {
    public static void main(String[] args) {
        Course c1 = new Course(1,"语文",76.3f);
        Course c2 = new Course(2,"数学",89f);
        Course c3 = new Course(3,"体育",90f);
        Course[] courses = {c1,c2,c3};

        Student student = new Student(1,"小明",courses);
        student.find("语文");
        student.find(3);
        student.find(2);
        student.find(1);
        student.avgCourse();
    }
}
