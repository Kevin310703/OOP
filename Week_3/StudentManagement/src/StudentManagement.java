import java.util.Arrays;
import java.util.Comparator;

public class StudentManagement {
    private static final int MAX_STUDENTS = 100;
    private static Student[] students = new Student[0];
    private static int currentSize;
    private static String firstAddedGroup;

    public StudentManagement() {
        students = new Student[MAX_STUDENTS];
        currentSize = 0;
    }

     static boolean sameGroup(Student s1, Student s2) {

        if (s1 == null || s2 == null) {
            return false;
        }

        // So sánh thuộc tính "group" của hai sinh viên
        return s1.getGroup().equals(s2.getGroup());
    }

    static void addStudent(Student newStudent) {
        if (currentSize < MAX_STUDENTS) {
            students[currentSize++] = newStudent;
        } else {
            System.out.println("Danh sách sinh viên đã đầy. Không thể thêm mới.");
        }
    }

    static void removeStudent(String id) {
        for (int i = 0; i < currentSize; i++) {
            if (students[i].getId().equals(id)) {
                // Di chuyển phần tử cuối cùng của mảng vào vị trí của phần tử cần xóa
                students[i] = students[currentSize - 1];
                students[currentSize - 1] = null;
                currentSize--;
                System.out.println("Đã xóa sinh viên có mã số " + id);
                return;
            }
        }

        System.out.println("Không tìm thấy sinh viên có mã số " + id);
    }

    static String studentsByGroup() {
        StringBuilder result = new StringBuilder();

        Arrays.sort(students, 0, currentSize, Comparator
                .comparing(Student::getGroup, Comparator.reverseOrder())
                .thenComparing(Student::getId));

        String currentGroup = "";
        for (int i = 0; i < currentSize; i++) {
            Student student = students[i];

            if (!student.getGroup().equals(currentGroup)) {
                // Nếu là lớp mới, in ra tên lớp
                result.append(student.getGroup()).append("\n");
                currentGroup = student.getGroup();
            }

            // In ra thông tin sinh viên
            result.append(student.getName()).append(" - ")
                    .append(student.getId()).append(" - ")
                    .append(student.getGroup()).append(" - ")
                    .append(student.getEmail()).append("\n");
        }

        return result.toString();
    }
}