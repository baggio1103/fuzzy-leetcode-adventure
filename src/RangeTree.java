import java.util.ArrayList;
import java.util.List;

public class RangeTree {
    Node root;
    List<Node> leaves;
    int[] xPoints;
    int[] yPoints;

    public RangeTree(int[] xs, int[] ys){
        leaves = new ArrayList<>();
        this.xPoints = xs;
        this.yPoints = ys;
        checkArraySize();
        createLeaves(xPoints, yPoints);
        SubTree.subtreePoints = false;
        constructTree(leaves);
        addLinksToLeafs();
    }

    public void createLeaves(int[] xs, int [] ys){
        for (int i = 0; i < xs.length; i++){
            leaves.add(new Node(xs[i], xs[i], ys[i]));
        }
    }

    public void constructTree(List<Node> leaves){
        if (leaves.size() == 1){
            root = leaves.get(0);
            return;
        }
        List<Node> nodeList = constructNodes(leaves);
        constructSubtree(nodeList);
        constructTree(nodeList);
    }

    public List<Node> constructNodes(List<Node> list){
        List<Node> nodeList = new ArrayList<>();
        for (int i = 0; i < list.size() - 1; i += 2){
            int value = getValue(list, i);
            Node node = new Node(value);
            node.left = list.get(i);
            node.right = list.get(i+1);
            nodeList.add(node);
        }
        return nodeList;
    }

    public void constructSubtree(List<Node> list){
        int size = xPoints.length / list.size();
        int index = 0;
        for (Node node : list) {
            int[] xs = new int[size], ys = new int[size];
            index = arrayCopy(xs, ys, xPoints, yPoints,index);
            getSubtree(node, xs, ys);
        }
    }

    public void getSubtree(Node node, int[] xs, int[] ys){
        if (!SubTree.hasSubtree) {
            SubTree.hasSubtree = true;
            node.subtree = new RangeTree(ys, xs);
            SubTree.hasSubtree = false;
        }
    }

    public List<Node> twoDimRangeSearch(int x1, int x2, int y1, int y2){
        List<Node> foundPoints = new ArrayList<>(); // contains all the points with a given range
        List<Node> leftSequence = getNodeSequence(x1);
        List<Node> rightSequence = getNodeSequence(x2);
        Node leftBoundaryNode = leftSequence.get(leftSequence.size()-1);
        Node rightBoundaryNode = rightSequence.get(rightSequence.size()-1);
        search(leftSequence, rightSequence, x1, x2, y1, y2, foundPoints);

        if (checkBounds(leftBoundaryNode, x1,x2,y1,y2)){
            foundPoints.add(leftBoundaryNode);
        }

        if (checkBounds(rightBoundaryNode, x1,x2,y1,y2)){
            foundPoints.add(rightBoundaryNode);
        }

        return foundPoints;
    }

    public void search(List<Node> leftSequence, List<Node> rightSequence, int x1, int x2, int y1, int y2, List<Node> points){
        for (Node node : leftSequence) {
            if (leftSequence.contains(node.left)) {
                if (node.right.subtree != null) {
                    List<Node> result = rangeSearch(node.right.subtree, y1, y2);
                    points.addAll(result);
                }else {
                    if (checkBounds(node.right, x1, x2, y1, y2)){
                        points.add(node.right);
                    }
                }
            }
        }

        for (Node node : rightSequence){
            if (rightSequence.contains(node.right)) {
                if (node.left.subtree != null) {
                    List<Node> result = rangeSearch(node.left.subtree, y1, y2);
                    points.addAll(result);
                }else {
                    if (checkBounds(node.left, x1, x2, y1, y2)){
                        points.add(node.left);
                    }
                }
            }
        }

    }

    public List<Node> getNodeSequence(int value){
        Node node = root;
        List<Node> nodeSequence = new ArrayList<>();
        while (node.left != null && node.right != null){
            if (value > node.value){
                node = node.right;
            }else{
                node = node.left;
            }
            nodeSequence.add(node);
        }
        return nodeSequence;
    }

    public List<Node> rangeSearch(RangeTree tree, int begin, int end){
        Node node = tree.root;
        List<Node> leaves = new ArrayList<>();

        while (node.right != null && node.left != null){
            if (begin > node.value){
                node = node.right;
            }else {
                node = node.left;
            }
        }

        if (node.next == null && node.value < begin){
            return leaves;
        }

        if (node.value < begin){
            node = node.next;
        }

        while (node.value <= end){
            leaves.add(node);
            node = node.next;
            if (node == null)break;
        }
        return leaves;
    }

    public boolean checkBounds(Node node, int x1, int x2, int y1, int y2){
        return (node.point.xCoordinate >= x1) && (node.point.xCoordinate <= x2) && (node.point.yCoordinate >= y1) && (node.point.yCoordinate <= y2);
    }

    public int arrayCopy(int[] xs, int[] ys, int[] xPoints, int[] yPoints,int index){
        for (int i = 0; i < xs.length; i++){
            xs[i] = xPoints[index];
            ys[i] = yPoints[index];
            index++;
        }
        return index;
    }

    public void addLinksToLeafs(){
        Node node = leaves.get(0);
        node.next = leaves.get(1);
        for (int i = 1; i < leaves.size()-1; i++){
            node = leaves.get(i);
            node.next = leaves.get(i+1);
            node.prev = leaves.get(i-1);
        }
        node = leaves.get(leaves.size()-1);
        node.prev = leaves.get(leaves.size()-2);
    }

    public int getValue(List<Node> list, int index){
        return list.get(index+1).value == 0 ? list.get(index).value : ( list.get(index).value + list.get(index+1).value)/2;
    }

    public void checkArraySize(){
        if (!isPowerOfTwo(xPoints.length)){
            xPoints = changeArray(xPoints);
            yPoints = changeArray(yPoints);
        }
        Array.sort(xPoints, yPoints);
    }

    public boolean isPowerOfTwo(int n){
        while (n != 1){
            if (n % 2 != 0){
                return false;
            }
            n = n / 2;
        }
        return true;
    }

    public int[] changeArray(int[] array){
        int[] newArray = new int[(getPower(array.length))];
        for (int i = 0; i < array.length; i++){
            newArray[i] = array[i];
        }
        return newArray;
    }

    public int getPower(int N){
        int i = 1;
        while (Math.pow(2,i) < N){
            i++;
        }
        return (int) Math.pow(2,i);
    }

    public void printLinkedList(){
        Node node = root;
        while (node.left != null){
            node = node.left;
        }
        System.out.println("Doubly LinkedList: ");
        while (node != null){
            System.out.print("("+node.point.xCoordinate + " " + node.point.yCoordinate + ") ");
            node = node.next;
        }
        System.out.println();
    }

    public void traverse(Node node){
        if (node == null){
            return;
        }
        System.out.print(node.value + " ");
        traverse(node.left);
        traverse(node.right);
    }

}


class Node{
    Node left;
    Node right;
    Node prev;
    Node next;
    int value;
    RangeTree subtree;
    Point point;
    public Node(int value, int x, int y){
        this.value = value;
        left = right = null;
        prev = next = null;
        subtree = null;
        point = new Point(x,y);
    }

    public Node(int value){
        this.value = value;
        left = right = null;
        prev = next = null;
        subtree = null;
        point = null;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                ", coordinates: X=" + point.xCoordinate + " Y=" + point.yCoordinate +
                '}';
    }
}

class Point{
    int xCoordinate;
    int yCoordinate;
    public Point(int x, int y) {
        if (SubTree.subtreePoints) {
            this.xCoordinate = x;
            this.yCoordinate = y;
        } else {
            this.xCoordinate = y;
            this.yCoordinate = x;
        }
    }
}

class SubTree{
    static boolean hasSubtree = false;
    static boolean subtreePoints = true;
}

class Array {

    public static void sort(int[] xs, int[] ys){
        mergeSort(xs, ys, 0, xs.length-1);
    }

    public static void mergeSort(int[] xs, int[] ys, int left, int right){
        if (left < right) {
            int middle = (left + right) / 2;
            mergeSort(xs, ys, left, middle);
            mergeSort(xs, ys,middle + 1, right);
            merge(xs, ys, left, middle, right);
        }
    }

    public static void merge(int[] xs, int[] ys, int left, int middle, int right){
        int size1 = middle - left + 1;
        int size2 = right - middle;

        int[] leftSubArray = new int[size1];
        int[] rightSubArray = new int[size2];

        int[] leftSubArray1 = new int[size1];
        int[] rightSubArray1 = new int[size2];


        for (int i = 0; i < size1; i++){
            leftSubArray[i] = xs[left+i];
            leftSubArray1[i] = ys[left+i];
        }
        for (int j = 0; j < size2; j++){
            rightSubArray[j] = xs[middle + 1 + j];
            rightSubArray1[j] = ys[middle + 1 + j];
        }

        int i = 0, j = 0;
        int k = left;

        while (i < size1 && j < size2){
            if (leftSubArray[i] <= rightSubArray[j]){
                xs[k] = leftSubArray[i];
                ys[k] = leftSubArray1[i];
                i++;
            }else {
                xs[k] = rightSubArray[j];
                ys[k] = rightSubArray1[j];
                j++;
            }
            k++;
        }

        while (i < size1){
            xs[k] = leftSubArray[i];
            ys[k] = leftSubArray1[i];
            i++;
            k++;
        }

        while (j < size2){
            xs[k] = rightSubArray[j];
            ys[k] = rightSubArray1[j];
            j++;
            k++;
        }
    }

}