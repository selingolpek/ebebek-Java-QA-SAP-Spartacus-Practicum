public class Employee {
    private String name;
    private double baseSalary;
    private double netSalary; //maaş - vergi + bonus
    private int workHours;
    private int hireYear;
    private int currentYear = 2021;
    private int experienceYear;

    public Employee(String name, double baseSalary, int workHours, int hireYear) {
        this.name = name;
        this.baseSalary = baseSalary;
        this.workHours = workHours;
        this.hireYear = hireYear;
        experienceYear = currentYear - hireYear;
        netSalary = baseSalary - tax() + bonus();
    }

    public double tax() {  //sadece salary dikkate alındı
        if (baseSalary < 1000)
            return 0;
        else
            return baseSalary * 3 / 100;
    }

    public double bonus() {
        if (workHours <= 40)
            return 0;
        int bonusHours = workHours - 40;
        return bonusHours * 30;
    }

    public double raiseSalary() {  //case'e uyulmamız söylendiği için vergi ve bonuslar dikkate alınmadı
        if (experienceYear < 10)
            return baseSalary * 5 / 100;
        else if (experienceYear < 20)
            return baseSalary * 10 / 100;
        else
            return baseSalary * 15 / 100;
    }

    @Override
    public String toString() { //istenilen çıktıyı bastırır ve döndürür
        String text = "a";
        text = "Adı : " + name + '\n' +
                "Maaşı : " + baseSalary + '\n' +
                "Çalışma Saati : " + workHours + '\n' +
                "Başlangıç Yılı : " + hireYear + '\n' +
                "Vergi : " + tax() + '\n' +
                "Bonus : " + bonus() + '\n' +
                "Maaş Artışı : " + raiseSalary() + '\n' +
                "Vergi ve Bonuslar ile birlikte maaş : " + netSalary + '\n' +
                "Toplam Maaş : " + (netSalary + raiseSalary());
        System.out.println(text);
        return text;
    }
}
