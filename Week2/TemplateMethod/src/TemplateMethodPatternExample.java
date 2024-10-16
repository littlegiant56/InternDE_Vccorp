public class TemplateMethodPatternExample {

    public static void main(String[] args) {
        PageTemplate homePage = new HomePage();
        PageTemplate detailPage = new DetailPage();
        PageTemplate contactPage = new ContactPage();

        System.out.println("Home Page:");
        homePage.showPage();
        System.out.println();

        System.out.println("Detail Page:");
        detailPage.showPage();
        System.out.println();

        System.out.println("Contact Page:");
        contactPage.showPage();
    }
}
