import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Student {
	private String name;
	private String surname;
	private double gpa;
	private double alesGrade;
	private double ydsScore;
	private double entranceScore;

	public Student() {
		super();
	}

	public Student(String name, String surname, double gpa, double alesGrade, double ydsScore) {
		super();
		this.name = name;
		this.surname = surname;
		this.gpa = gpa;
		this.alesGrade = alesGrade;
		this.ydsScore = ydsScore;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public double getGpa() {
		return gpa;
	}

	public void setGpa(double gpa) {
		this.gpa = gpa;
	}

	public double getAlesGrade() {
		return alesGrade;
	}

	public void setAlesGrade(double alesGrade) {
		this.alesGrade = alesGrade;
	}

	public double getYdsScore() {
		return ydsScore;
	}

	public void setYdsScore(double ydsScore) {
		this.ydsScore = ydsScore;
	}

	public double getEntranceScore() {
		return (this.gpa * 10) + (this.alesGrade * 0.3) + (this.ydsScore * 0.3);
	}

	public void setEntranceScore(double entranceScore) {
		this.entranceScore = entranceScore;
	}

	@Override
	public String toString() {
		return "Student [entranceScore=" + getEntranceScore() + ", name=" + name + ", surname=" + surname + ", gpa="
				+ gpa + ", alesGrade=" + alesGrade + ", ydsScore=" + ydsScore + ", entranceScore=" + entranceScore
				+ "]";
	}

}

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		List<Student> studentList = new ArrayList<Student>();

		while (studentList.size() < 10) {
			String name = null, surname = null;
			double gpa = 0, alesGrade = 0, ydsScore = 0;

			int studentListSize = studentList.size();

			System.out.println("Please enter the name of the student " + (studentListSize + 1) + ":");
			name = scan.next();
			System.out.println("Please enter the surname of the student " + (studentListSize + 1) + ":");
			surname = scan.next();
			System.out.println("Please enter the GPA of the student " + (studentListSize + 1) + ":");
			gpa = scan.nextDouble();
			System.out.println("Please enter the ALES Grade of the student " + (studentListSize + 1) + ":");
			alesGrade = scan.nextDouble();
			System.out.println("Please enter the YDS Score of the student " + (studentListSize + 1) + ":");
			ydsScore = scan.nextDouble();

			Student student = new Student(name, surname, gpa, alesGrade, ydsScore);
			if (student.getGpa() < 2 || student.getGpa() > 4 || student.getAlesGrade() < 70
					|| student.getAlesGrade() > 100 || student.getYdsScore() < 55 || student.getYdsScore() > 100) {
				System.out.println("This student is not eligible to apply.");
				continue;
			}
			studentList.add(student);
		}

		System.out.println("Entrance Score  Name       Surname     GPA      ALES Score    YDS Score");
		for (int i = 0; i < studentList.size(); i++) {
			Student student = studentList.get(i);

			System.out.println(student.getEntranceScore() + "            " + student.getName() + "         "
					+ student.getSurname() + "     " + student.getGpa() + "          " + student.getAlesGrade()
					+ "          " + student.getYdsScore() + "          ");
		}
		System.out.println();

		String searchName = null;
		do {
			System.out.println(
					"Please enter the name of the student that you want to see the score (This method will run until enter \"exit\"): ");
			searchName = scan.next();

			Student findedStudent = searchStudentWithName(studentList, searchName);
			if (findedStudent != null) {
				System.out.println(findedStudent.toString());
			} else {
				if (!searchName.equals("exit"))
					System.out.println("There is no such student!");
			}
		} while (!searchName.equals("exit"));

	}

	public static Student searchStudentWithName(List<Student> studentList, String searchName) {
		for (int i = 0; i < studentList.size(); i++) {
			if (searchName.equals(studentList.get(i).getName())) {
				return studentList.get(i);
			}
		}
		return null;
	}
}