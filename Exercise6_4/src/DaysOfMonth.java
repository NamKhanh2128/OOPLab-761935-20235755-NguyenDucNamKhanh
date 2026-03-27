import java.util.Scanner;

public class DaysOfMonth {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int year = -1;
        int month = -1;

        // Nhập và kiểm tra năm
        while (true) {
            System.out.print("Enter a year (e.g., 1999): ");
            String yearInput = scanner.nextLine().trim();
            try {
                year = Integer.parseInt(yearInput);
                if (year >= 0) break;
            } catch (NumberFormatException e) { }
            System.out.println("Invalid year! Please enter a valid non-negative number.");
        }

        // Nhập và kiểm tra tháng
        while (true) {
            System.out.print("Enter a month (name, abbreviation, or number): ");
            String monthInput = scanner.nextLine().trim().toLowerCase();
            month = getMonthNumber(monthInput);
            if (month != -1) break;
            System.out.println("Invalid month! Please try again.");
        }

        // Kiểm tra năm nhuận
        boolean isLeapYear = (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
        int days = 0;

        // Tính số ngày
        if (month == 2) {
            days = isLeapYear ? 29 : 28;
        } else if (month == 4 || month == 6 || month == 9 || month == 11) {
            days = 30;
        } else {
            days = 31;
        }

        System.out.println("Number of days in this month: " + days);
        scanner.close();
    }

    private static int getMonthNumber(String m) {
        switch (m) {
            case "january": case "jan.": case "jan": case "1": return 1;
            case "february": case "feb.": case "feb": case "2": return 2;
            case "march": case "mar.": case "mar": case "3": return 3;
            case "april": case "apr.": case "apr": case "4": return 4;
            case "may": case "5": return 5;
            case "june": case "jun": case "6": return 6;
            case "july": case "jul": case "7": return 7;
            case "august": case "aug.": case "aug": case "8": return 8;
            case "september": case "sept.": case "sep": case "9": return 9;
            case "october": case "oct.": case "oct": case "10": return 10;
            case "november": case "nov.": case "nov": case "11": return 11;
            case "december": case "dec.": case "dec": case "12": return 12;
            default: return -1;
        }
    }
}