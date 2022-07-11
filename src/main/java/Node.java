

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

public class Node {
    int i=0;
    String id;
    String name;
    List<Node> children;
    public String Node;

    public Node(String name) {
        this.name = name;
        this.id = UUID.randomUUID().toString();
        this.children = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String s) {
        name = s;
    }

    public List<Node> getChildren() {
        return children;
    }

    public void add(Node child) {
        this.children.add(child);
    }

    public void dell(String name) {
        for (int i = 0; i < children.size(); i++) {
            if (children.get(i).getName().equals(name)) {
                children.remove(i);
            }
        }
    }

    public void dellOC(String name) {
        for (int i = 0; i < children.size(); i++) {
            if (children.get(i).getName().equals(name)) {
                for (int j = i + 1; i < children.size(); j++) {
                    children.remove(j);
                }
            }
        }
    }

    public boolean search(String name) {
        for (int i = 0; i < children.size(); i++) {
            if (children.get(i).getName().equals(name)) {
                return true;
            } else
                return false;
        }
        return false;
    }

    public void rename(String name, String rename) {
        for (int i = 0; i < children.size(); i++) {
            if (children.get(i).getName().equals(name)) {
                children.get(i).setName(rename);
            }
        }
    }

    public String print(){
        return print("",0);
    }
    private String print(String s,int t)
    {
        for(int i=0;i<t;i++)
        {
            s+= " ";
        }
        s+=name;
        s+="\n";
        if(children.size()==0)
        {
            return s;
        }else {
            for (int i = 0; i < children.size(); i++)
            {
                s+= children.get(i).print("",t+1);
            }
        return s;
        }
    }
    public String printToHtml(Node root){

            String result = "  <ul>";
            result += "<li>";
            for(i=0;i<children.size();i++) {
            result +=children.get(i).name+ "<br>";
        }
            result += "</li>";
            result += "</ul>";
            return result;

    }
}