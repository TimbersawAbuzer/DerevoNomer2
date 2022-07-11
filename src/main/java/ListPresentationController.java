import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

/**
 * Контроллер отвечающий за представление списка.
 */
@Path("/")
public class ListPresentationController {
    private final List<String> list;
private final Node root;
    /**
     * Запоминает список, с которым будет работать.
     *
     * @param list список, с которым будет работать контроллер.
     */
    public ListPresentationController(List<String> list, Node root) {
        this.list = list;
    this.root=root;
    }

    /**
     * Пример вывода простого текста.
     */
    @GET
    @Path("example")
    @Produces("text/plain")
    public String getSimpleText() {
        return "hello world";
    }

    /**
     * Выводит HTML-страницу со списком, ссылками на страницы редактирования и копкой добавления записи.
     *
     * @return HTML-страница со списком.
     */
    @GET
    @Path("/")
    @Produces("text/html")
    public String getList() {
        String result =
                "<html>" +
                        "  <head>" +
                        "    <title>Вывод списка 123</title>" +
                        "  </head>" +
                        "  <body>" +
                        "    <h1>Список 123 </h1>" +
                        "    <ul>";
        for (int i = 0; i < list.size(); i++) {
            String listItem = list.get(i);
            result += "<li>" + listItem + " <a href=\"edit/" + i + "\">Редактировать</a> </li>";
        }
        result += "    </ul>" +
                "      <br/>" +
                "      <form method=\"post\" action=\"add_random_item\">" +
                "        <input type=\"submit\" value=\"Add random item\"/>" +
                "      </form>" +
                "  </body>" +
                "</html>";
        return result;
    }
    @GET
    @Path("/1")
    @Produces("text/html")
    public String getTree(){
        return"<html>"+
                "  <head>"+
                "    <title>Вывода дерева</title>"+
                "</head>"+
                " <body>"+
                "<h1>Вывод дерева</h1>"+
                root.printToHtml(root)+
                "</body>"+
                "</html>";
    }

}
