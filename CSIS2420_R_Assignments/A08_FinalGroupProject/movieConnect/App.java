package movieConnect;

/**
 * The main class for the Movie Connect application.
 * <p>
 * This class contains the main method responsible for launching the application
 * by creating an instance of the {@link StartPageJFrame}.
 * </p>
 * <p>
 * To run the Movie Connect application, execute the {@code main} method in this class.
 * </p>
 * 
 * @author Kamdon Bird, Haiyang Liu
 * @version 1.0
 */
public class App {

    /**
     * The main entry point for the Movie Connect application.
     * <p>
     * This method creates an instance of {@link StartPageJFrame}, initializing
     * the start page and initiating the application.
     * </p>
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        new StartPageJFrame();
    }
}