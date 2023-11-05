
public class Main {
    public static void main(String[] args) {
        // Создание объекта ToyStore
        ToyStore toyStore = new ToyStore();

        // Создание и добавление в игрушечную очередь нескольких игрушек
        Toy toy1 = new Toy("1", "конструктор", 2);
        Toy toy2 = new Toy("2", "робот", 2);
        Toy toy3 = new Toy("3", "кукла", 6);

        toyStore.addToy(toy1);
        toyStore.addToy(toy2);
        toyStore.addToy(toy3);

        // Вызов метода getToys для записи результатов в файл
        toyStore.getToys(3);
    }
}