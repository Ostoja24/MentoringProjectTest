import io.github.bonigarcia.wdm.WebDriverManager;
public class BaseTest {
    // Variables used in Test Project

    private final static String CREDENTIALS_ORG = "credentials_org";
    private String getCredentialsOrg;
    public void setup(){
        getCredentialsOrg = System.getProperty(CREDENTIALS_ORG); // Ścieżka dostępu do jsona z danymi dostępowymi
    }
    static void setupwebdriver() {
        WebDriverManager.chromedriver().setup();
    }

    }

