import java.io.FileWriter;
import java.io.IOException;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;


public class ToyStore {
    private final Queue<Toy> toyQueue;

    public ToyStore() {
        toyQueue = new PriorityQueue<>();
    }

    public void addToy(Toy toy) {
        toyQueue.add(toy);
    }

    public void getToys(int count) {
        if (count > toyQueue.size()) {
            throw new IllegalArgumentException("Not enough toys in the store");
        }
        try (FileWriter fileWriter = new FileWriter("output.txt")) {
            Random random = new Random();
            for (int i = 0; i < count; i++) {
                String toyId = getRandomToyId(random);
                if (!toyId.isEmpty()) {
                    String result = "ID: " + toyId + "\n";
                    fileWriter.write(result);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getRandomToyId(Random random) {
        int totalFrequency = toyQueue.stream().mapToInt(Toy::getFrequency).sum();
        int randomValue = random.nextInt(totalFrequency);
        int sum = 0;
        for (Toy toy : toyQueue) {
            sum += toy.getFrequency();
            if (randomValue < sum) {
                return toy.getId();
            }
        }
        return "";
    }
}