import javax.ws.rs.core.Application;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Web-приложение в котором регистрируются все ресурсы.
 */
public class WebApplication extends Application {

    private List<String> list = new ArrayList<>();
    private Node root;

    public WebApplication() {
        list.add("aaa");
        list.add("bbb");
        list.add("ccc");
        list.add("ddd");
        root= new Node ("с");
        root.add(new Node("Корень"));
        root.add(new Node("Ствол"));
        root.add(new Node("Ветка"));
        root.add(new Node("Яблоко"));
        root.add(new Node("Лист"));
    }

    /**
     * Возвращает список всех ресурсов web-приложения.
     * @return список всех ресурсов web-приложения.
     */
    @Override
    public Set<Object> getSingletons() {
        Set<Object> resources = new HashSet<>();
        resources.add(new ListPresentationController(list,root));
        return resources;
    }
}