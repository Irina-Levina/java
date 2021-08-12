import java.util.ArrayList;
import java.util.List;

public class Node {

    String url;
    List <Node> cildren = new ArrayList<>();

    public Node(String url) {
        this.url = url;
    }

    public List<Node> getCildren() {
        return cildren;
    }

    public void setCildren(List<String> cildren) {
        List <Node> children = new ArrayList<>();
        for (String s: cildren) {
            children.add(new Node(s));
        }
    }

    @Override
    public String toString() {
        return url + "\n\t" + cildren ;
    }
}
