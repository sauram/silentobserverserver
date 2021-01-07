import io.vertx.core.Vertx;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.http.HttpServer;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.Route;
import io.vertx.ext.web.Router;

public class App {

    public static void main(String[] args) {


        Vertx vertx = Vertx.vertx();

        HttpServer httpServer = vertx.createHttpServer();

        Router router = Router.router(vertx);

        Route handler2 = router
                .post("/give")
                //.consumes("*/json")
                .handler(routingContext -> {
                    System.out.println("came to post");
                    JsonObject json = new JsonObject()
                            .put("answer", "0");
                    HttpServerResponse response = routingContext.response();
                    response.setChunked(true);
                    //response.write("ji");
                    response.end(json.encodePrettily());
                });


        httpServer
                .requestHandler(router)
                .listen(8091);

    }
}