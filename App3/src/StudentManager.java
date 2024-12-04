import java.util.ArrayList;
import java.util.List;

public class StudentManager {
    private List<Student> students;

    public StudentManager() {
        students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void removeStudent(String id) {
        Student student = findStudent(id);
        if (student != null) {
            students.remove(student);
            System.out.println("Student with ID " + id + " has been removed.");
        } else {
            System.out.println("Student not found with ID: " + id);
        }
    }

    public void displayStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
        } else {
            for (Student student : students) {
                System.out.println(student);
            }
        }
    }

    public Student findStudent(String id) {
        for (Student student : students) {
            if (student.getId().equals(id)) {
                return student;
            }
        }
        return null; // Return null if student not found
    }

    public void editStudent(String id, String newName, double newScore) {
        Student student = findStudent(id);
        if (student != null) {
            Student updatedStudent = new Student(id, newName, newScore);
            removeStudent(id);
            addStudent(updatedStudent);
            System.out.println("Student with ID " + id + " has been updated.");
        } else {
            System.out.println("Student not found with ID: " + id);
        }
    }

    // Sorting students by score (Merge Sort)
    public void sortByScoreMergeSort() {
        students = mergeSort(students);
        System.out.println("Students sorted by score (Merge Sort):");
        displayStudents();
    }

    private List<Student> mergeSort(List<Student> list) {
        if (list.size() <= 1) {
            return list;
        }
        int middle = list.size() / 2;
        List<Student> left = mergeSort(list.subList(0, middle));
        List<Student> right = mergeSort(list.subList(middle, list.size()));
        return merge(left, right);
    }

    private List<Student> merge(List<Student> left, List<Student> right) {
        List<Student> result = new ArrayList<>();
        int i = 0, j = 0;
        while (i < left.size() && j < right.size()) {
            if (left.get(i).getScore() <= right.get(j).getScore()) {
                result.add(left.get(i));
                i++;
            } else {
                result.add(right.get(j));
                j++;
            }
        }
        while (i < left.size()) {
            result.add(left.get(i));
            i++;
        }
        while (j < right.size()) {
            result.add(right.get(j));
            j++;
        }
        return result;
    }
}
