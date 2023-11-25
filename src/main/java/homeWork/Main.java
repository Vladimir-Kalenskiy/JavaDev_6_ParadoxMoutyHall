package homeWork;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Main {
    private static final Random random = new Random();
    private static final int ROUND = 1000;
    private static boolean switched = true;

    public static void main(String[] args) {
        newSession(true);
        System.out.println("***************************");
        newSession(false);
    }

    private static void newSession(boolean switched){
        System.out.println("Начинаем автоигру.\n" +
                "Количество раундов: " + ROUND + "\n" +
                "Режим смены выбора: " + true);
        Map<Integer, String> game = paradox(ROUND, switched);
        System.out.println(game);
    }


    private static Map<Integer,String> paradox(int ROUND, boolean switched){
        Map<Integer, String> results = new HashMap<>();
        int wins = 0;

        for (int i = 0; i < ROUND; i++) {
            int prizeDoor = random.nextInt(3);
            int chooseUser = random.nextInt(3);
            int chooseAdmin = chooseAnotherDoor(prizeDoor, chooseUser);
            if(switched){
                chooseUser = chooseAnotherDoor(chooseUser, chooseAdmin);
            }
            if(chooseUser == prizeDoor){
                wins++;
                results.put(i, "Win");
            }else {
                results.put(i, "Lose");
            }
        }
        System.out.println("Статистика выигрыша: " + wins + "/" + ROUND);
        return results;
    }

    private static int chooseAnotherDoor(int door1, int door2) {
        int result;
        do
            result = random.nextInt(3);
        while (result == door1 || result == door2);
        return result;
    }
}
