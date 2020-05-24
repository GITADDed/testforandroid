package ru.kpfu.itis.group905.makarov.ruby;

public class Num {
    private MyLinkedList2<String> value = new MyLinkedList2<>();

    public Num(){
        value.insert("1");
    }

    public String lookAndSay() {
        String result = value.getQuantityAndValue();
        value.InsertQuantityBeforeItem();
        value.combineTheSameItem();
        return result;
    }
}
