public class Auto {
    // Закрытый член нашего класса с названием фирмы автомобиля
    private String firm;
    // Закрытый член класса, содержащий максимальную скорость
    private int maxSpeed;

    private String gosNomer;

    // открытая функция (метод класса) для задания значения фирмы автомобиля
    public void setFirm(String firma) {
        firm = firma;
    }

    // открытая функция (метод класса) для задания значения максимальной скорости
    // автомобиля
    public void setMaxSpeed(int speed) {
        maxSpeed = speed;
    }

    public void setGosNumber (String num) {
        gosNomer = num;
    }

    // открытая функция (метод класса) для вывода значения максимальной скорости
    public int getMaxSpeed() {
        return maxSpeed;
    }

    // открытая функция (метод класса) для вывода значения заданной фирмы
    public String getFirm() {
        return firm;
    }

    public String getGosNumber () {
        return gosNomer;
    }


    // конструктор класса (без параметров)
    public Auto() {
        firm = "Без названия";
        maxSpeed = 0;
    }

    // конструктор класса (с параметрами)
    public Auto(String firma, int speed, String nomer) {
        firm = firma;
        maxSpeed = speed;
        gosNomer = nomer;
    }

    public void printNomer () {
        System.out.println("Номер автомобиля: " + gosNomer);
    }
}
