
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NodeTests {
    @Test
    void createNode(){
        Node node = new Node("Корень");
        assertEquals("Корень", node.getName());
    }
    @Test
    void addNode(){
        Node root = new Node("Корень");
        Node child = new Node("Лист");
        root.add(child);
        assertEquals(1, root.getChildren().size());
        assertEquals("Лист", root.getChildren().get(0).getName());
    }
    @Test
    void deleteNode()
    {
        Node root = new Node("Корень");
        Node child = new Node("Лист");
        root.add(child);
        assertEquals(1, root.getChildren().size());
        assertEquals("Лист", root.getChildren().get(0).getName());
        child.dell("Лист");
    }
    @Test
    void deleteChildrens()
    {
        Node root = new Node("Корень");
        Node child = new Node("Лист");
        Node kid = new Node("Ствол");
        root.add(child);
        root.add(kid);
        assertEquals(2, root.getChildren().size());
        assertEquals("Лист", root.getChildren().get(0).getName());
        assertEquals("Ствол", root.getChildren().get(1).getName());
        root.dellOC("Корень");
    }
    @Test
    void search()
    {
        Node root = new Node("Корень");
        Node child = new Node("Лист");
        Node kid = new Node("Ствол");
        root.add(child);
        root.add(kid);
        assertEquals(2, root.getChildren().size());
        assertEquals("Лист", root.getChildren().get(0).getName());
        assertEquals("Ствол", root.getChildren().get(1).getName());
        root.search("Ствол");
    }
    @Test
    void rename()
    {
        Node root = new Node("Корень");
        Node child = new Node("Лист");
        Node kid = new Node("Ствол");
        root.add(child);
        root.add(kid);
        assertEquals(2, root.getChildren().size());
        assertEquals("Лист", root.getChildren().get(0).getName());
        assertEquals("Ствол", root.getChildren().get(1).getName());
        root.rename("Ствол", "Почка");
    }
    @Test
    void print() throws IOException {
        Node root = new Node("Корень");
        Node child = new Node("Лист");
        Node kid = new Node("Ствол");
        root.add(child);
        root.add(kid);
        assertEquals(2, root.getChildren().size());
        assertEquals("Лист", root.getChildren().get(0).getName());
        assertEquals("Ствол", root.getChildren().get(1).getName());
        System.out.println(root.print());
    }
}
