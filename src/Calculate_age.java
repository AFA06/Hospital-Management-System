import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Calculate_age {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter your date of birth (dd/MM/yyyy): ");

		// Read the user's date of birth
		String dob = scanner.nextLine(); 

		LocalDate birthDate = LocalDate.parse(dob, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		LocalDate currentDate = LocalDate.now(); // Current date

		// Calculate age

		int age = Period.between(birthDate, currentDate).getYears();

		System.out.println("Your age is: " + age);

		// Determine the service or requirement based on age

		if (age >= 70) {
			System.out.println("You are eligible for a free meal once you visit the hospital.");
		}

		if (age < 18) {
			System.out.println("Ensure you are accompanied by an adult.");
		}

		if (age < 13) {
			System.out.println("You will be assigned a doctor who is paediatrically specialised.");
		}
	}
}
