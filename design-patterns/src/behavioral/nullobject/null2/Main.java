package behavioral.nullobject.null2;

public class Main {

    public static void main(String[] args) {

        Node root =
                new NodeImpl("1", new NodeImpl("11", new NodeImpl("111", NullNode.getInstance(),
                        NullNode.getInstance()), NullNode.getInstance()), new NodeImpl("12",
                        NullNode.getInstance(), new NodeImpl("122", NullNode.getInstance(),
                        NullNode.getInstance())));

        root.walk();
    }
}
