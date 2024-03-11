package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class CustomSortString {
    private static class CharacterOrder implements Comparable<CharacterOrder>{
        char aChar;
        int order;

        @Override
        public int compareTo(CharacterOrder characterOrder) {
            return this.order - characterOrder.order;
        }

        public CharacterOrder(char aChar, int order){
            this.aChar = aChar;
            this.order = order;
        }
    }

    public String customSortString(String order, String s) {
        int[] characterOrders = new int[100];
        Arrays.fill(characterOrders, 1000000);

        for(int i=0;i<order.length();i++){
            characterOrders[order.charAt(i)-'A'] = i;
        }

        List<CharacterOrder> answerList = new ArrayList<>();
        char[] sCharArray = s.toCharArray();

        for(char tempChar : sCharArray){
            answerList.add(new CharacterOrder(tempChar,characterOrders[tempChar-'A']));
        }

        Collections.sort(answerList);

        StringBuilder sb = new StringBuilder();
        for(CharacterOrder characterOrder : answerList){
            sb.append(characterOrder.aChar);
        }
        return sb.toString();
    }
}