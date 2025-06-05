import io.javalin.Javalin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class App {
    private static final Logger log = LoggerFactory.getLogger(App.class);
    private static final int PREFERRED_PORT = 7070;
    private static final int[] FALLBACK_PORTS = {7071, 8080, 9090};

    public static void main(String[] args) {
        startApplication();
    }

    private static void startApplication() {
        // Primero intentar con el puerto preferido
        Javalin app = createAndStartJavalin(PREFERRED_PORT);

        if (app == null) {
            log.warn("⚠ Puerto {} ocupado, probando alternativas...", PREFERRED_PORT);

            // Intentar con puertos alternativos
            for (int port : FALLBACK_PORTS) {
                app = createAndStartJavalin(port);
                if (app != null) break;
            }

            // Si todos los puertos fallaron, usar uno aleatorio
            if (app == null) {
                app = Javalin.create();
                app.start(0); // Puerto aleatorio
                log.info("✅ Servidor iniciado en puerto aleatorio: http://localhost:{}", app.port());
            }
        }

        configureRoutes(app);
    }

    private static Javalin createAndStartJavalin(int port) {
        try {
            Javalin app = Javalin.create(config -> {
                config.plugins.enableDevLogging();
                config.http.defaultContentType = "application/json";
            });
            app.start(port);
            log.info("✅ Servidor iniciado en http://localhost:{}", port);
            return app;
        } catch (Exception e) {
            log.warn("⛔ Puerto {} no disponible: {}", port, e.getMessage());
            return null;
        }
    }

    private static void configureRoutes(Javalin app) {
        app.get("/", ctx -> {
            log.info("Acceso a la ruta principal");
            ctx.json(new StatusResponse("Servidor funcionando", app.port()));
        });

        // Puedes añadir más rutas aquí
    }

    static class StatusResponse {
        public String status;
        public int port;

        public StatusResponse(String status, int port) {
            this.status = status;
            this.port = port;
        }
    }
}