public class Demo {

    public static void main(String[] args) throws InterruptedException {
        int[] xs = {35, 52, 62, 82, 5, 27, 85,90};
        int[] ys = {42, 10, 77, 65, 45, 35, 15,5};
        RangeTree tree = new RangeTree(xs, ys);
        var a = tree.twoDimRangeSearch(15,95,5,65);
    }

}
