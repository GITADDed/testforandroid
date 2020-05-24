package ru.kpfu.itis.group905.makarov.ruby;

public class LookAndSay {
    public static void main(String[] args) {
        int n = 10;
        Num num = new Num();
        System.out.println("1");
        for (int i = 0; i < n; i++) {
            System.out.println(num.lookAndSay());
        }
    }
}
