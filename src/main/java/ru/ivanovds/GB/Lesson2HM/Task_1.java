package ru.ivanovds.GB.Lesson2HM;

public class Task_1 {

    public static void main(String[] args) {
        String s = "cba";
        int[] index = new int[]{3, 2, 1};
        String result = new Task_1().shuffle(s, index);
        System.out.println(result);

//        System.out.println(new Task_1().shuffle("cba", new int[]{3, 2, 1}).equals("abc") ?
//                "Test is complete" : "Test is not complete");
    }

    public String shuffle(final String s, final int[] index){
        var sb = new StringBuilder();
        for (int j : index) {
            sb.append(s.charAt(j - 1));
        }

        return sb.toString();
    }
}
