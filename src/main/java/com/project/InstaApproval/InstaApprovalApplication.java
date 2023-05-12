package com.project.InstaApproval;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.Scanner;

@SpringBootApplication
//public class InstaApprovalApplication {
//
//	public static void main(String[] args) {
//		SpringApplication.run(InstaApprovalApplication.class, args);
//	}
//
//}



public class InstaApprovalApplication {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String name, email, phone, employment, creditScore;
		double income;

		// Collect basic information
		System.out.println("Please provide your name: ");
		name = input.nextLine();

		System.out.println("Please provide your email address: ");
		email = input.nextLine();

		System.out.println("Please provide your phone number: ");
		phone = input.nextLine();

		System.out.println("Please provide your employment details: ");
		employment = input.nextLine();

		System.out.println("Please provide your credit score: ");
		creditScore = input.nextLine();

		System.out.println("Please provide your income: ");
		income = input.nextDouble();

		// Verify information
		boolean isVerified = verifyInformation(name, email, phone, employment, creditScore, income);

		if (isVerified) {
			// Provide eligibility criteria
			int minCreditScore = 700;
			double minIncome = 50000.00;
			boolean isEligible = checkEligibility(minCreditScore, minIncome, creditScore, income);

			if (isEligible) {
				// Provide loan options
				double loanAmount = 50000.00;
				int loanTerm = 60;
				double interestRate = 0.00;

				// Approve loan
				boolean isApproved = approveLoan(loanAmount, loanTerm, interestRate);

				if (isApproved) {
					// Disburse loan amount
					disburseLoan(loanAmount);
					System.out.println("Congratulations! Your loan has been approved and the loan amount has been disbursed.");
				} else {
					System.out.println("Sorry, your loan has been rejected. Please try again later.");
				}
			} else {
				System.out.println("Sorry, you are not eligible for a loan at this time. Please try again later.");
			}
		} else {
			System.out.println("Sorry, the information provided cannot be verified. Please try again.");
		}
	}

	public static boolean verifyInformation(String name, String email, String phone, String employment, String creditScore, double income) {
		// Verification code here
		return true;
	}

	public static boolean checkEligibility(int minCreditScore, double minIncome, String creditScore, double income) {
		// Eligibility code here
		return true;
	}

	public static boolean approveLoan(double loanAmount, int loanTerm, double interestRate) {
		// Loan approval code here
		return true;
	}

	public static void disburseLoan(double loanAmount) {
		// Loan disbursement code here
	}
}
